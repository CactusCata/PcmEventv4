package fr.cactuscata.pcmeventv4.command;

import org.bukkit.command.CommandSender;

/**
 * Classe qui permet de faire h�riter de la m�thode
 * {@link ExecutableCommand#execute(CommandSender, String[])} toutes les classes
 * qui h�rites de la classe {@link NotSimpleCommand}. Cette classe est
 * uniquement constitu� pour cela.
 * 
 * @author CactusCata
 * @version 2.5.1
 * @since 2.5.0
 * @see CCommandExecutor NotSimpleCommand
 *
 */

public interface ExecutableCommand {

	/**
	 * M�thode qui permet � des classes qui h�rites de {@link NotSimpleCommand}
	 * d'�tre executables.
	 * 
	 * @param sender
	 *            Sender qui a execut� la commande.
	 * @param args
	 *            Liste des arguments.
	 * @throws CommandException
	 *             Exception lev� si la commande ne respecte pas la structure voulu.
	 */
	public void execute(final CommandSender sender, final String[] args) throws CommandException;

}
