package fr.cactuscata.pcmeventv4.command.notsimplecmd.physic;

import org.bukkit.Material;
import org.bukkit.command.CommandSender;

import fr.cactuscata.pcmeventv4.command.CCommandExecutor.SenderType;
import fr.cactuscata.pcmeventv4.command.CommandException;
import fr.cactuscata.pcmeventv4.command.CommandValidator;
import fr.cactuscata.pcmeventv4.command.SubCommand;
import fr.cactuscata.pcmeventv4.utils.bukkit.PrefixMessage;

/**
 * Cette classe permet le fonctionnement de l'argument <code>'add'</code> de la
 * commande <code>'/physic'</code>.
 * 
 * @author Cactuscata
 * @version 2.5.1
 * @since 2.5.1
 * @see {@link PhysicCmd}.
 */

final class PhysicCmdAdd extends SubCommand {

	private final PhysicFile physicFile;

	/**
	 * D�finis les valeurs par d�faut pour sa super-classe {@link SubCommand}.
	 * 
	 * @param physicFile
	 *            Permet d'ajouter un materiel dans ceux whitelist via
	 *            {@link PhysicFile#getList()}.
	 */
	PhysicCmdAdd(final PhysicFile physicFile) {
		super("add", SenderType.ALL, "Veuillez pr�ciser le material !");
		this.physicFile = physicFile;
	}

	@Override
	protected final void execute(final CommandSender sender, final String[] args) throws CommandException {
		args[0] = args[0].toUpperCase();
		@SuppressWarnings("deprecation")
		final Material material = CommandValidator.isInteger(args[0]) ? Material.getMaterial(Integer.parseInt(args[0]))
				: Material.getMaterial(args[0]);
		CommandValidator.isNull(material, "La material '" + args[0] + "' n'existe pas !");
		CommandValidator.isTrue(!material.isBlock(), "La material '" + material.toString() + "' n'est pas un block !");
		CommandValidator.isTrue(this.physicFile.getList().contains(material),
				"La liste contient d�j� le material '" + material.toString() + "' !");
		this.physicFile.getList().add(material);
		sender.sendMessage(
				PrefixMessage.PREFIX + "Le material '" + material.toString() + " a �t� ajout� avec succ�s !");
	}

	@Override
	protected final String getHelp() {
		return "Vous pouvez grace � cet argument ajouter un material dans la liste (/physic list).";
	}

}
