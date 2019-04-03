package fr.cactuscata.pcmeventv4.utils.bukkit;

/**
 * <p>
 * Cette classe �num�re la liste de tous les pr�fix de message. Celui utilis�
 * par d�faut sur la casi-totalit� des commandes est le prefix
 * {@link PrefixMessage#PREFIX}.
 * </p>
 * 
 * @author CactusCata
 * @version 2.5.1
 * @since 1.0.0
 */

public enum PrefixMessage {

	PREFIX("�1[�bMondeEvent�1]�e "),
	ERROR(PREFIX + "�c"),
	SENDER_BE_PLAYER(PrefixMessage.PREFIX + "�4La commande ne peut etre execute que par un joueur !"),
	SPY("�1[�3Spy�1]�7 "),
	CONFIG("�5[�7Config�5]�e "),
	NOT_ENOUGHT_PERMISSION(
			"�cI'm sorry, but you do not have permission to perform this command. Please contact the server administrators if you believe that this is in error."),
	VANISH("�f[�bVanish�f]�e "),
	ANTI_CHEAT_TESTFOR("�f[�9�lTestFor�f]�3 ");

	private final String text;

	/**
	 * Constructeur priv� qui enregistre la phrase ou le prefix d'un messagde.
	 * 
	 * @param text
	 *            Phrase ou prefix.
	 */
	private PrefixMessage(final String text) {
		this.text = text;
	}

	/**
	 * M�thode qui permet de r�cuperer la phrase ou le prefix associ�.
	 */
	@Override
	public final String toString() {
		return this.text;
	}

}