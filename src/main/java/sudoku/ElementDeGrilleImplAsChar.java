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
  
    @Override
    public boolean equals(final Object elem) {
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
     * Obtient la valeur de l'élément de grille.
     * @return La valeur de l'élément.
     */
    public char getValeur() {
        return this.valeur;
    }
}
