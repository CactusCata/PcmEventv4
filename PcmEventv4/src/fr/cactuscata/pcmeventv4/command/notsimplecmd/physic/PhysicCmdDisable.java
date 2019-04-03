package fr.cactuscata.pcmeventv4.command.notsimplecmd.physic;

import org.bukkit.command.CommandSender;

import fr.cactuscata.pcmeventv4.command.CCommandExecutor.SenderType;
import fr.cactuscata.pcmeventv4.command.CommandException;
import fr.cactuscata.pcmeventv4.command.CommandValidator;
import fr.cactuscata.pcmeventv4.command.SubCommand;
import fr.cactuscata.pcmeventv4.utils.bukkit.PrefixMessage;

/**
 * Cette classe permet le fonctionnement de l'argument <code>'disable'</code> de
 * la commande <code>'/physic'</code>.
 * 
 * @author Cactuscata
 * @version 2.5.1
 * @since 2.5.1
 * @see {@link PhysicCmd}.
 */

final class PhysicCmdDisable extends SubCommand {

	private final PhysicFile physicFile;

	/**
	 * D�finis les valeurs par d�faut pour sa super-classe {@link SubCommand}.
	 * 
	 * @param physicFile
	 *            Permet de d�sactiver la physique via
	 *            {@link PhysicFile#disablePhysic()}.
	 */
	PhysicCmdDisable(final PhysicFile physicFile) {
		super("disable", SenderType.ALL);
		this.physicFile = physicFile;
	}

	@Override
	protected final void execute(final CommandSender sender, final String[] args) throws CommandException {
		CommandValidator.isTrue(!this.physicFile.isPhysicEnable(), "La physique est d�j� d�sactiv�e !");
		this.physicFile.disablePhysic();
		sender.sendMessage(PrefixMessage.PREFIX + "La physique � bien �t� d�sactiv�e !");
	}

	@Override
	protected final String getHelp() {
		return "Grace � cet argument vous pourrez d�sactiver momentan�ment la physique du monde.";
	}

}
