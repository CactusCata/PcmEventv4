package fr.cactuscata.pcmeventv4.command.simplecmd.warp;

import org.bukkit.command.CommandSender;

import fr.cactuscata.pcmeventv4.command.CommandException;
import fr.cactuscata.pcmeventv4.command.CommandValidator;
import fr.cactuscata.pcmeventv4.command.SimpleCommand;
import fr.cactuscata.pcmeventv4.utils.bukkit.PrefixMessage;
import fr.cactuscata.pcmeventv4.utils.other.StringUtils;

/**
 * <p>
 * Cette classe permet l'execution de la commande /warps, cette derni�re permet
 * d'acceder � la liste de tous les warps pr�sent dans l'objet {@link WarpFile}.
 * </p>
 * 
 * @author CactusCata
 * @version 2.5.1
 * @since 1.0.0
 * @see SetWarpCmd WarpCmd DelWarpCmd WarpInfoCmd
 */

public final class WarpsCmd extends SimpleCommand {

	private final WarpFile warpFile;

	/**
	 * M�thode qui permet d'instancier la super-class et permet �galemet de garder
	 * en m�moire l'objet {@link WarpFile}.
	 * 
	 * @param warpFile
	 *            Qui permettra de recuperer la liste de tous les warps via
	 *            {@link WarpFile#getAllWarps()}.
	 */
	public WarpsCmd(final WarpFile warpFile) {
		super(PrefixMessage.PREFIX, SenderType.ALL);
		this.warpFile = warpFile;
	}

	@Override
	protected final void execute(final CommandSender sender, final String[] args) throws CommandException {
		CommandValidator.isTrue(this.warpFile.getNumberWarp() == 0, "Il n'y a aucun warp existant !");
		super.sendMessage(sender,
				"Liste de tous les warps: " + StringUtils.join(this.warpFile.getAllWarps().keySet(), ", ") + ".");

	}

	@Override
	protected final String getHelp() {
		return "Cette commande permet de visualiser la liste de tous les warps pr�sents.";
	}

}
