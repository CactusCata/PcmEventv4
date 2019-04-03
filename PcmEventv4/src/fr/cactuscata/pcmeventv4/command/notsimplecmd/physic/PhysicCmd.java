package fr.cactuscata.pcmeventv4.command.notsimplecmd.physic;

import fr.cactuscata.pcmeventv4.command.NotSimpleCommand;

/**
 * Cette classe permet de gerer la commande <code>'/physic'</code> qui permet
 * momentan�ment de d�sactiver la physic grade � l'argument
 * {@link PhysicCmdDisable 'disable'}, vous pouvez �galement filtrer les blocs
 * voulu grace � l'argument {@link PhysicCmdAdd 'add'} et les retirer avec
 * {@link PhysicCmdRemove 'remove'}. Vous pouvez voir la liste de tous les
 * mat�rieux withlist avec l'argument {@link PhysicCmdList 'list'}. Pour
 * r�activer la physique, vous n'avez qu'� utiliser l'argument
 * {@link PhysicCmdEnable 'enable'}.
 * 
 * @author CactusCata
 * @version 2.5.1
 * @since 2.5.1
 * @see PhysicCmdAdd PhysicCmdDisable PhysicCmdEnable PhysicCmdList
 *      PhysicCmdRemove
 *
 */

public final class PhysicCmd extends NotSimpleCommand {

	/**
	 * Instanciation de tous les arguments.
	 * 
	 * @param physicFile
	 *            Argument requis pour l'instanciation des diff�rents
	 *            objet-arguments.
	 */
	public PhysicCmd(final PhysicFile physicFile) {
		super(new PhysicCmdList(physicFile), new PhysicCmdAdd(physicFile), new PhysicCmdRemove(physicFile),
				new PhysicCmdEnable(physicFile), new PhysicCmdDisable(physicFile));
	}

	@Override
	protected final String getTutorialCommand() {
		return "Grace � cette commande vous pourrez ajouter ou supprimer des materials qui subiront la physique. (liste de tous les materials: https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html ).";
	}

}
