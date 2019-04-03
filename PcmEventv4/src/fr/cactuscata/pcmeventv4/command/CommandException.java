package fr.cactuscata.pcmeventv4.command;

/**
 * Cette classe permet de gerer tous les patternes possibles de toutes les
 * {@link SubCommand}, {@link SimpleCommand} ou encore {@link NotSimpleCommand}.
 * 
 * 
 * @author CactusCata
 * @version 2.5.1
 * @since 2.5.0
 * @see CCommandExecutor
 */

public final class CommandException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructeur de la classe qui permet de passer en param�tre le message
	 * d'erreur.
	 * 
	 * @param message
	 *            Message d'erreur mit en param�tre.
	 */
	public CommandException(final String message) {
		super(message);
	}

}
