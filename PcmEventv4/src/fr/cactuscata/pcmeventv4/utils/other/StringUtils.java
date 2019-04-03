package fr.cactuscata.pcmeventv4.utils.other;

import java.util.List;
import java.util.Set;

/**
 * Cette classe permet quelques utilitaires sur l'objet {@link String}.
 * 
 * @author CactusCata
 * @version 2.5.1
 * @since 2.5.0
 */

public final class StringUtils {

	/**
	 * Cette m�thode permet re rejoindre plusieurs �l�ments de {@link Set}.
	 * 
	 * @param list
	 *            Objet {@link Set}.
	 * @param separator
	 *            Objet {@link String} comme s�parateur.
	 * @return La liste rejoite.
	 */
	public static final String join(final Set<String> list, final String separator) {
		return join(list.toArray(new String[list.size()]), separator);
	}

	/**
	 * Cette m�thode permet re rejoindre plusieurs �l�ments de {@link List}.
	 * 
	 * @param list
	 *            Objet {@link List}.
	 * @param separator
	 *            Objet {@link String} comme s�parateur.
	 * @return La liste rejoite.
	 */
	public static final String join(final List<String> list, final String separator) {
		return join(list.toArray(new String[list.size()]), separator);
	}

	/**
	 * Cette m�thode permet de rejoindre un tableay avec un s�parateur.
	 * 
	 * @param array
	 *            Tableau.
	 * @param separator
	 *            Objet {@link String} comme s�parateur.
	 * @return La liste rejoite.
	 */
	public static final String join(final String[] array, final String separator) {
		return join(array, 0, separator);
	}

	/**
	 * M�thode qui permet de rejoindre diff�rents arguments � partir d'un certain
	 * index.
	 * 
	 * @param array
	 *            Tableau de {@link String}.
	 * @param indexToStart
	 *            Index auquel commence le join.
	 * @param separator
	 *            S�parateur de type {@link String}
	 * @return Le join.
	 */
	public static final String join(final String[] array, final int indexToStart, final String separator) {
		final StringBuilder build = new StringBuilder();
		for (int i = indexToStart, j = array.length; i < j; i++) {
			if (i != indexToStart)
				build.append(separator);
			build.append(array[i]);
		}
		return build.toString();
	}

	/**
	 * Cette m�thode permet de retirer une partie d'un tableau en ciblant son index.
	 * 
	 * @param index
	 *            Index � retirer.
	 * @param oldArray
	 *            Ancien tableau.
	 * @return Nouveau tableau sans la valeur � l'index choisis.
	 */
	public static final String[] removeIndex(final int index, final String[] oldArray) {
		final String[] newArray = new String[oldArray.length - 1];

		for (int i = 0, j = oldArray.length, k = 0; k < j; k++)
			if (k != index) {
				newArray[i] = oldArray[k];
				i++;
			}

		return newArray;
	}

	/**
	 * Cette methode permet de convertir un tableau d'{@link Object} en tableau de
	 * {@link String} avec la m�thode {@link Object#toString()}.
	 * 
	 * @param arrayObject
	 *            Le tableau d'objet.
	 * @return Le nouveay tableau de type {@link String}.
	 */
	public static final String[] toStringArray(final Object[] arrayObject) {
		String[] arrayString = new String[arrayObject.length];
		for (int i = 0, j = arrayObject.length; i < j; i++)
			arrayString[i] = arrayObject[i].toString();
		return arrayString;
	}

	public static final <E> E getCorrectStringInArray(final E[] array, final E value) {
		for (final E e : array)
			if (e.equals(value))
				return e;
		return null;
	}

	public static final String capitalize(final String value) {
		return value.substring(0, 1).toUpperCase() + value.substring(0).toLowerCase();
	}

}
