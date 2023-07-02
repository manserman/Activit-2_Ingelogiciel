package sudoku;
import java.util.Set;
import exceptions.ElementInterditException;
import exceptions.HorsBornesException;
import exceptions.ValeurImpossibleException;
import exceptions.ValeurInitialeModificationException;

   /**
    * Interface de grille de sudoku.
    * Chaque case d'une Grille peut contenir un ElementDeGrille
    * ou null si aucun élément n'est placé
    * Une Grille doit toujours respecter les règles du sudoku
    * Une Grille peut contenir des cases qui ne doivent pas être modifiées
    * @author Sébastien Choplin <sebastien.choplin@u-picardie.fr>
    */
    public interface Grille {
    /**
     * Renvoie les ElementDeGrille pouvant exister dans le grille.
     * @return un ensemble contenant les éléments de grille possibles
     */
    Set<ElementDeGrille> getElements();

    /**
     * @return largeur/hauteur de la grille.
     */
    int getDimension();

    /**
     * Affecte une valeur dans une case de la grille, null pour 'vider' la case.
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value élément à mettre dans la case, null pour vider la case
     * @throws ValeurImpossibleException si élm pas autorisé à cette position
     *                 dans la grille aux vues des autres valeurs de la grille
     * @throws ElementInterditException élm pas autorisé dans cette grille
     * @throws HorsBornesException si x ou y sont en dehors de la grille
     * @throws ValeurInitialeModificationException valeur init en position x,y
     */
    void setValue(int x, int y, ElementDeGrille value)
        throws HorsBornesException, ValeurImpossibleException,
        ElementInterditException, ValeurInitialeModificationException;

    /**
     * Renvoie une valeur de la grille.
     * @param x position x dans la grille
     * @param y position y dans la grille
     * @return élm de la case x,y, null s'il n'y a pas d'élm à cette position
     * @throws HorsBornesException si x ou y sont en dehors de la grille
     */
    ElementDeGrille getValue(int x, int y) throws HorsBornesException;

    /**
     * Teste si une grille est remplie.
     *
     * @return true si la grille est complete
     */
    boolean isComplete();

    /**
     * Teste si une valeur peut être placée dans la grille.
     *
     * @param x     position x dans la grille
     * @param y     position y dans la grille
     * @param value valeur à mettre dans la case
     * @return true si value être en position x,y respectant règles du sudoku
     *         et sans modifier une valeur initiale
     * @throws HorsBornesException      si x ou y sont hors bornes
     * @throws ValeurImpossibleException si la valeur est impossible à placer
     */
    boolean isPossible(int x, int y, ElementDeGrille value)
        throws HorsBornesException, ValeurImpossibleException;

    /**
     * @param x     position x dans la grille.
     * @param y     position y dans la grille
     * @return true si la case x,y contient une valeur initiale de la grille
     */
    boolean isValeurInitiale(int x, int y);
}
