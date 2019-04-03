package fr.cactuscata.pcmeventv4.command;

import java.text.Normalizer;
import java.util.List;

import org.bukkit.command.BlockCommandSender;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import fr.cactuscata.pcmeventv4.utils.bukkit.PrefixMessage;

/**
 * Classe qui permet de gerer l'execution de commande via l'impl�mentation de
 * l'interface {@link CommandExecutor} ainsi que la compl�tion automatique avec
 * la tabultion ({@link TabCompleter}).
 * 
 * @author CactusCata
 * @version 2.5.1
 * @since 2.0.0
 * @see SimpleCommand NotSimpleCommand
 *
 */

public abstract class CCommandExecutor implements TabExecutor {

	/**
	 * M�thode qui permet aux classes filles telles que {@link SimpleCommand} ou
	 * {@link NotSimpleCommand} de g�rer les commandes.
	 * 
	 * @param sender
	 *            Sender qui a execut� la commande.
	 * @param args
	 *            Tableau des arguments de la commande.
	 * @throws CommandException
	 *             Lev� si la commande ne respecte pas le pattern voulu dans les
	 *             classes filles.
	 */
	
	protected abstract void onCommand(final CommandSender sender, final String[] args) throws CommandException;

	/**
	 * M�thode qui permet la compl�tion automatique avec la tabulation.
	 * 
	 * @param args
	 *            Tableau des arguments de la commande.
	 * @return Selon le nombre d'argument retourne une liste d'arguments possibles.
	 */
	protected abstract List<String> onTabComplete(final String[] args);

	@Override
	public final boolean onCommand(final CommandSender sender, final Command cmd, final String label,
			final String[] args) {
		try {
			this.onCommand(sender, args);
		} catch (final CommandException e) {
			sender.sendMessage(PrefixMessage.ERROR + normalizeMessage(sender, e.getMessage()));
		}
		return true;
	}

	@Override
	public final List<String> onTabComplete(final CommandSender sender, final Command cmd, final String label,
			final String[] args) {
		return this.onTabComplete(args);
	}

	/**
	 * M�thode qui permet, si le sender instancie l'interface
	 * {@link ConsoleCommandSender} de simplifier le message de telle sorte �
	 * retirer les accents ainsi que les caract�res non-UTF-8.
	 * 
	 * @param sender
	 *            Sender qui a execut� la commande.
	 * @param message
	 *            Message initiale cible.
	 * @return Le message normalis�.
	 */
	static final String normalizeMessage(final CommandSender sender, final String message) {
		return sender instanceof ConsoleCommandSender
				? Normalizer.normalize(message, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "")
				: message;
	}

	/**
	 * Enumeration qui permet de s�l�ctionner le/les sender voulu pour l'execution
	 * de certaines commandes ou arguments.
	 * 
	 * @author CactusCata
	 * @version 2.5.1
	 * @since 2.5.0
	 */
	public static enum SenderType {
		ALL(null),
		CONSOLE("la console"),
		PLAYER("un joueur"),
		COMMAND_BLOCK("un bloc de commande");

		private final String senderName;

		/**
		 * @param senderName
		 *            Nom d'affichage.
		 */
		private SenderType(final String senderName) {
			this.senderName = senderName;
		}

		/**
		 * M�thode qui retourne le nom d'affichage de chaque sender.
		 * 
		 * @return La nom d'affichage du sender.
		 */
		final String getSenderName() {
			return this.senderName;
		}

		/**
		 * M�thode v�rifie si un {@link CommandSender} est bien �gal � un
		 * {@link SenderType}.
		 * 
		 * @param sender
		 *            Sender cible.
		 * @param senderType
		 *            {@link SenderType} cible.
		 * @return Vrai si le sender correspond � sa valeur en tant que SenderType.
		 */
		public static final boolean checkSenderTypeIsCorrect(final CommandSender sender, final SenderType senderType) {
			return !(senderType != SenderType.ALL && senderType == SenderType.PLAYER && !(sender instanceof Player)
					|| senderType == SenderType.CONSOLE && !(sender instanceof ConsoleCommandSender)
					|| senderType == SenderType.COMMAND_BLOCK && !(sender instanceof BlockCommandSender));

		}

	}
	
}
