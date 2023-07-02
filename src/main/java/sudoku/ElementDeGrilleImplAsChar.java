package sudoku;

/**
 * Implémentation de l'interface ElementDeGrille.
 * Cette classe représente un élément de grille avec une valeur de type char.
 * @author : Groupe_Z
 */
public class ElementDeGrilleImplAsChar implements ElementDeGrille {

    /**
    * Valeur de l'élément de la grille.
    */
    private char valeur;

    /**
     * Constructeur de la classe ElementDeGrilleImplAsChar.
     * @param value La valeur de l'élément de grille.
     */
    public ElementDeGrilleImplAsChar(final char value) {
        super();
        this.valeur = value;
    }

    /**
     * Vérifie si l'objet spécifié est égal à l'élément de grille.
     *
     * @param elem L'objet à comparer.
     * @return true si l'objet est égal à l'élément de grille, sinon false.
     */
    @Override
    public final boolean equals(final Object elem) {
        if (!(elem instanceof ElementDeGrilleImplAsChar)) {
            return false;
        }
        ElementDeGrilleImplAsChar el = (ElementDeGrilleImplAsChar) elem;
        if (this.valeur == el.valeur) {
            return true;
        }
        return false;
    }

    /**
     * Retourne le code de hachage de l'objet.
     *
     * @return le code de hachage de l'objet
     */
    public final int hashCode() {
      return Character.hashCode(valeur);
    }
    /**
     * Obtient la valeur de l'élément de grille.
     * @return La valeur de l'élément.
     */
    @Override
    public final char getValeur() {
        return this.valeur;
    }
}
