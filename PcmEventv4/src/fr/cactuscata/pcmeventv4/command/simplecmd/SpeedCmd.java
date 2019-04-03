package fr.cactuscata.pcmeventv4.command.simplecmd;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cactuscata.pcmeventv4.command.CommandException;
import fr.cactuscata.pcmeventv4.command.CommandValidator;
import fr.cactuscata.pcmeventv4.command.SimpleCommand;
import fr.cactuscata.pcmeventv4.utils.bukkit.PrefixMessage;

/**
 * <p>
 * Cette classe permet d'executer la commande /speed, cette derni�re permet
 * d'aller plus vite, que �a sois dans les airs ou sur la terre.
 * </p>
 * <p>
 * La commande doit avoir pour argument un nombre entre un et dix.
 * </p>
 * 
 * @author CactusCata
 * @version 2.5.1
 * @since 1.0.0
 */

public final class SpeedCmd extends SimpleCommand {

	/**
	 * Constructeur qui permet d'instancier la super-class.
	 */
	public SpeedCmd() {
		super(PrefixMessage.PREFIX, SenderType.PLAYER, "Veuillez pr�ciser la puissance du speed !");
	}

	@Override
	protected final void execute(final CommandSender sender, final String[] args) throws CommandException {
		final float amount = CommandValidator.getFloat(args[0]);
		CommandValidator.isBetweenTo(amount, 0, 100);
		final Player playerSender = (Player) sender;
		playerSender.setWalkSpeed(amount / 10);
		playerSender.setFlySpeed(amount / 20);
		super.sendMessage(sender, String.format("Votre vitesse � �t� mise � %f ! ( 2 par d�faut )", amount));

	}

	@Override
	protected final String getHelp() {
		return "Grace � cette commande vous pourrez modifier votre vitesse d�placement ainsi que celle de vol.";
	}

}
