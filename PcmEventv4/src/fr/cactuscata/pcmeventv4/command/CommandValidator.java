package fr.cactuscata.pcmeventv4.command;

import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.cactuscata.pcmeventv4.command.CCommandExecutor.SenderType;
import fr.cactuscata.pcmeventv4.utils.bukkit.UUIDFetcher;
import fr.cactuscata.pcmeventv4.utils.other.StringUtils;

/**
 * Cette classe permet de v�rifier des v�rit�s et si elles sont pas respect�s,
 * l'exception {@link CommandException} est lev� (pour la plus part des cas).
 * 
 * @author CactusCata
 * @version 2.5.1
 * @since 2.5.0
 * @see CCommandExecutor
 *
 */

public final class CommandValidator {

	/**
	 * M�thode qui permet la conversion d'une cha�ne de carat�re en nombre entier.
	 * 
	 * @param stringInt
	 *            La chaine de caract�res qui doit �tre convertie en nombre entier.
	 * @return Le nombre voulu.
	 * @throws CommandException
	 *             Si la cha�ne de caract�re n'est pas un nombre.
	 */
	public static final int getInt(final String stringInt) throws CommandException {
		try {
			return Integer.parseInt(stringInt);
		} catch (final NumberFormatException e) {
			throw new CommandException("Le nombre '" + stringInt + "' n'est pas un nombre entier valide !");
		}
	}

	/**
	 * M�thode qui permet la conversion d'une cha�ne de caract�re en nombre �
	 * virgule.
	 * 
	 * @param stringFloat
	 *            La cha�ne de caract�re qui doit �tre convertie en nombre �
	 *            virgule.
	 * @return Le nombre � virgule.
	 * @throws CommandException
	 *             Si la cha�ne de caract�re n'est pas convertissable en nombre �
	 *             virgule.
	 */
	public static final float getFloat(final String stringFloat) throws CommandException {
		try {
			return Float.parseFloat(stringFloat);
		} catch (final NumberFormatException e) {
			throw new CommandException("Le nombre '" + stringFloat + "' n'est pas un nombre � valide !");
		}
	}

	/**
	 * M�thode qui l�ve l'exception {@link CommandException} si le boolean choisi
	 * est vrai.
	 * 
	 * @param booleanValue
	 *            Le boolean en question.
	 * @param message
	 *            Message envoy� si le boolean est vrai.
	 * @throws CommandException
	 *             Si le boolean est vrai.
	 */
	public static final void isTrue(final boolean booleanValue, final String message) throws CommandException {
		if (booleanValue)
			throw new CommandException(message);
	}

	/**
	 * M�thode qui l�ve l'exception {@link CommandException} si le boolean choisi
	 * est vrai.
	 * 
	 * @param booleanValue
	 *            Le boolean en question.
	 * @param message
	 *            Message envoy� si le boolean est vrai.
	 * @throws CommandException
	 *             Si le boolean est vrai.
	 */
	public static final void isFalse(final boolean booleanValue, final String message) throws CommandException {
		isTrue(!booleanValue, message);
	}

	/**
	 * M�thode qui v�rifie le nombre d'argument pr�sent et l�ve l'exception
	 * {@link CommandException} si le nombre d'argument n'est pas assez grand.
	 * 
	 * @param args
	 *            Le tableau cible.
	 * @param index
	 *            Index.
	 * @param message
	 *            Message envoy� si le tableau cibleau � une taile inf�rieur �
	 *            l'index.
	 * @throws CommandException
	 *             Exception lev� si tableau cibleau � une taile inf�rieur �
	 *             l'index.
	 */
	public static final void argsSizeIsPresent(final String[] args, final int index, final String message)
			throws CommandException {
		if (args.length < index)
			throw new CommandException(message);
	}

	/**
	 * M�thode qui v�rifie le nombre d'arguments pr�sents et envois un message si
	 * besoin.
	 * 
	 * @param args
	 *            Tableau cible.
	 * @param messages
	 *            Tableau de message correctif.
	 * @throws CommandException
	 *             Exception lev� si
	 *             <code> (args.length &lsaquo; messages.lentgh) </code>.
	 */
	public static final void argsSizeIsPresent(final String[] args, final String... messages) throws CommandException {
		if (args.length < messages.length)
			throw new CommandException(messages[args.length]);
	}

	/**
	 * M�thode qui r�cupere un joueur connect� par son pseudo.
	 * 
	 * @param playerName
	 *            Pseudo du joueur.
	 * @return Le joueur (peut �tre null si le joueur sp�cifi� n'est pas connect�).
	 */
	public static final Player getPlayerByString(final String playerName) {
		return Bukkit.getPlayerExact(playerName);
	}

	/**
	 * M�thode qui envois une exception si l'objet sp�cifi� est null.
	 * 
	 * @param object
	 *            Objet cible.
	 * @param message
	 *            Message envoy� si l'objet est �gal � null.
	 * @throws CommandException
	 *             Exception lev� si l'objet est �gal � null.
	 */
	public static final void isNull(final Object object, final String message) throws CommandException {
		if (object == null)
			throw new CommandException(message);
	}

	/**
	 * M�thode qui renvois un un boolean qui d�terminera si le joueur sp�cifi� est
	 * bien connect� via
	 * <code>(player != null &amp; &amp; player.isOnline())</code>.
	 * 
	 * @param player
	 *            Le joueur cible.
	 * @return Vrai si le joueur est connect�.
	 */
	public static final boolean isOnline(final Player player) {
		return player != null && player.isOnline();
	}

	/**
	 * M�thode qui l�ve l'exception {@link CommandException} si le joueur n'est pas
	 * en ligne.
	 * 
	 * @param player
	 *            Le joueur cible.
	 * @param message
	 *            Le message de l'exception.
	 * @throws CommandException
	 *             Se l�ve si le joueur n'est en ligne.
	 */
	public static final void isNotOnline(final Player player, final String message) throws CommandException {
		if (!isOnline(player))
			throw new CommandException(message);
	}

	/**
	 * M�thode qui l�ve l'exception {@link CommandException} si le nombre sp�cif�
	 * est sup�rieur � une autre valeur.
	 * 
	 * @param amount
	 *            Le nombre cible.
	 * @param secondAmount
	 *            La valeur fixe.
	 * @throws CommandException
	 *             Se l�ve si la premi�re valeur est sup�rieur � la seconde.
	 */
	public static final void isSuperiorTo(final Number amount, final Number secondAmount) throws CommandException {
		isSuperiorTo(amount, secondAmount, "Le nombre " + amount + " doit �tre sup�rieur � " + secondAmount + " !");
	}

	/**
	 * M�thode qui l�ve l'exception {@link CommandException} si le nombre sp�cif�
	 * est sup�rieur � une autre valeur.
	 * 
	 * @param amount
	 *            Le nombre cible.
	 * @param secondAmount
	 *            La valeur fixe.
	 * @param message
	 *            Le message d'erreur envoy�.
	 * @throws CommandException
	 *             Se l�ve si la premi�re valeur est sup�rieur � la seconde.
	 */
	public static final void isSuperiorTo(final Number amount, final Number secondAmount, final String message)
			throws CommandException {
		if (amount.floatValue() > secondAmount.floatValue())
			throw new CommandException("Le nombre " + amount + " doit �tre sup�rieur � " + secondAmount + " !");
	}

	/**
	 * M�thode qui l�ve l'exception {@link CommandException} si le premier est
	 * inf�rieur au second.
	 * 
	 * @param amount
	 *            Le nombre cible.
	 * @param secondAmount
	 *            La valeur fixe.
	 * @throws CommandException
	 *             Se l�ve si la premiere valeur est inf�rieur � la seconde.
	 */
	public static final void isInferiorTo(final Number amount, final Number secondAmount) throws CommandException {
		isInferiorTo(amount, secondAmount, "Le nombre " + amount + " doit �tre inf�rieur � " + secondAmount + " !");
	}

	/**
	 * M�thode qui l�ve l'exception {@link CommandException} si le premier est
	 * inf�rieur au second.
	 * 
	 * @param amount
	 *            Le nombre cible.
	 * @param secondAmount
	 *            La valeur fixe.
	 * @param message
	 *            Le message d'erreur � envoyer.
	 * @throws CommandException
	 *             Se l�ve si la premiere valeur est inf�rieur � la seconde.
	 */
	public static final void isInferiorTo(final Number amount, final Number secondAmount, final String message)
			throws CommandException {
		if (amount.floatValue() < secondAmount.floatValue())
			throw new CommandException(message);
	}

	public static final void isBetweenTo(final Number value, final Number min, final Number max)
			throws CommandException {
		isBetweenTo(value, min, max, String.format("Le nombre '%f' doit �tre inf�rieur � %f et sup�rieur � %f",
				value.floatValue(), max.floatValue(), min.floatValue()));
	}

	public static final void isBetweenTo(final Number value, final Number min, final Number max, final String message)
			throws CommandException {
		if (value.floatValue() < min.floatValue() || value.floatValue() > max.floatValue())
			throw new CommandException(message);
	}

	/**
	 * M�thode qui r�cupere l'{@link UUID} du joueur pr�cis� sous forme de
	 * {@link String} grace � la m�thode {@link UUIDFetcher#getUUIDOf(String)}. Si
	 * l'UUID n'existe pas, alors l'exception {@link CommandException} est lev�.
	 * 
	 * @param playerName
	 *            Le nom du joueur.
	 * @return L' {@link UUID} du joueeur cible.
	 * @throws CommandException
	 *             Si le joueur n'existe pas.
	 */
	public static final UUID getUUIDByName(final String playerName) throws CommandException {
		final UUID uuid = UUIDFetcher.getUUIDOf(playerName);
		if (uuid == null)
			throw new CommandException("Le joueur " + playerName + " n'existe pas !");
		return uuid;
	}

	/**
	 * M�thode qui permet de verifi� l'�galit� d'un objet � un autre via
	 * {@link Object#equals(Object)} et l�ve l'exception {@link CommandException} si
	 * la valeur de retour est �gale � <code>true</code>.
	 * 
	 * @param first
	 *            Premier objet cible.
	 * @param second
	 *            Second objet cible.
	 * @param message
	 *            Message envoy� dans l'exception si la valeur de retour est �gale �
	 *            <code>true</code>.
	 * @throws CommandException
	 *             Lev� si la valeur de retour est �gale <code>true</code>.
	 */
	public static final void is(final Object first, final Object second, final String message) throws CommandException {
		if (first.equals(second))
			throw new CommandException(message);
	}

	/**
	 * M�thode qui verifie la non-�galit� entre deux objets via
	 * !{@link Object#equals(Object)} et l�ve l'exception {@link CommandException}
	 * si la les deux objets ne sont pas �gaux.
	 * 
	 * @param first
	 *            Premier objet cible.
	 * @param second
	 *            Second objet cible.
	 * @param message
	 *            Message si l'exception est lev�.
	 * @throws CommandException
	 *             Lev� si le premier objet n'est pas �gal au second.
	 */
	public static final void isNot(final Object first, final Object second, final String message)
			throws CommandException {
		if (!first.equals(second))
			throw new CommandException(message);
	}

	/**
	 * M�thode qui v�rifie si une liste est vide, si <code>true</code> est retourn�
	 * alors l'exception {@link CommandException} est lev�.
	 * 
	 * @param list
	 *            Liste cible.
	 * @param message
	 *            Message envoy� si l'excetption est lev�.
	 * @throws CommandException
	 *             Exception lev� si la liste cibl� est vide.
	 */
	public static final void listIsEmpty(final List<?> list, final String message) throws CommandException {
		isTrue(list.isEmpty(), message);
	}

	/**
	 * M�thode qui permet de v�rifier quelle est l'interface qui h�rite de
	 * {@link CommandSender} pour lever l'exception {@link CommandException} si
	 * aucun sender n'a �t� trouv�.
	 * 
	 * @param sender
	 *            Sender cible.
	 * @param senderTypes
	 *            Tableau de sender accessibles.
	 * @throws CommandException
	 *             Lev� si aucun sender appropri� n'a �t� trouv�.
	 */
	public static final void checkSender(final CommandSender sender, final SenderType... senderTypes)
			throws CommandException {
		for (final SenderType senderT : senderTypes) {
			if (SenderType.checkSenderTypeIsCorrect(sender, senderT)) {
				return;
			}
		}

		if (senderTypes.length == 1)
			throw new CommandException(
					"Il n'y a que " + senderTypes[0].getSenderName() + " qui peut executer la commande !");
		else {
			final String[] args = new String[senderTypes.length];
			for (int i = 0, j = args.length; i < j; i++)
				args[i] = senderTypes[i].getSenderName();
			throw new CommandException(
					"Les seuls sender qui peuvent envoyer la commande sont " + StringUtils.join(args, ", ") + " !");
		}

	}

	/**
	 * M�thode qui v�rifie si le {@link String} en argument est un nombre entier
	 * 
	 * @param intValue
	 *            Le {@link String} a converitr en nombre si possible
	 * @return <code>True</code> si le nombre est un nombre entier,
	 *         <code>flase</code> sinon.
	 */
	public static final boolean isInteger(final String intValue) {
		try {
			Integer.parseInt(intValue);
			return true;
		} catch (final NumberFormatException e) {
			return false;
		}
	}
}
