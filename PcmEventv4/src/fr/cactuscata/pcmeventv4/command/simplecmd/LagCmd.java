package fr.cactuscata.pcmeventv4.command.simplecmd;

import org.bukkit.command.CommandSender;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;

import fr.cactuscata.pcmeventv4.command.CommandException;
import fr.cactuscata.pcmeventv4.command.CommandValidator;
import fr.cactuscata.pcmeventv4.command.SimpleCommand;
import fr.cactuscata.pcmeventv4.utils.bukkit.PrefixMessage;
import fr.cactuscata.pcmeventv4.utils.bukkit.Tps;
import fr.cactuscata.pcmeventv4.utils.other.Maths;

/**
 * <p>
 * Cette classe permet d'executer la commande /lag, cette dernière permet de
 * récuperer son {@link PlayerPcm#getPing() ping} ainsi que les
 * {@link Tps#getTps() tps} moyens du serveur.
 * </p>
 * <p>
 * Si le nom d'un joueur est mis en argument, son {@link PlayerPcm#getPing()
 * ping} sera alors affiché pour le joueur qui a écrit la commande.
 * </p>
 * 
 * @author CactusCata
 * @version 2.5.1
 * @since 1.5.0
 */

public final class LagCmd extends SimpleCommand {

	/**
	 * Constructeur qui permet d'instancier la super-class.
	 */
	public LagCmd() {
		super(PrefixMessage.PREFIX, SenderType.ALL);
	}

	@Override
	public final void execute(final CommandSender sender, final String[] args) throws CommandException {
		if (args.length == 0) {
			final StringBuilder message = new StringBuilder("§3Tps serveur : §e")
					.append(Maths.arrondidouble(Tps.getTps(), 3)).append("\n").append(PrefixMessage.PREFIX)
					.append("§3Tps serveur en % : §e").append(Math.round((1.0D - Tps.getTps() / 20.0D) * 100.0D))
					.append(" %");

			if (sender instanceof Player)
				message.append("\n").append(PrefixMessage.PREFIX).append("§3Latence avec le server : §e")
						.append(((CraftPlayer) (Player) sender).getHandle().ping).append("§3 ms !");

			super.sendMessage(sender, message);
		} else {

			final Player target = CommandValidator.getPlayerByString(args[0]);
			CommandValidator.isTrue(!CommandValidator.isOnline(target),
					"Le joueur '" + args[0] + "' n'est pas en ligne !");
			super.sendMessage(sender, "Latence du joueur " + target.getDisplayName() + "§3 : "
					+ ((CraftPlayer) (Player) target).getHandle().ping + "§3 ms !");
		}
	}

	@Override
	protected final String getHelp() {
		return "Cette commande permet de récuperer les tps du serveur ainsi que les ms du joueur qui a éxectué la commande, il permet aussi de récuperer les ms d'un joueur préciser.";
	}

}
