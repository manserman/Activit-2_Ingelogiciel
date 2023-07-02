package sudoku;
import java.util.Set;
import exceptions.ElementInterditException;
import exceptions.HorsBornesException;
import exceptions.ValeurImpossibleException;
import exceptions.ValeurInitialeModificationException;
import java.util.HashSet;
import java.util.Iterator;

/**
* Implémentation de l'interface Grille.
*/
public class GrilleImpl implements Grille {

    /**
     * Dimension de la grille de Sudoku.
     */
    private final int dimension;

    /**
     * Tableau indiquant les lignes initiales de la grille.
     */
    private boolean[][] lignesInitiales;

    /**
     * Ensemble des éléments de grille autorisés.
     */
    private final Set<ElementDeGrille> alphabet;

    /**
     * Grille de Sudoku.
     */
    private ElementDeGrille[][] grille;

    /**
     * Constructeur de la classe GrilleImpl.
     *
     * @param elementDeGrilles le tableau d'éléments de grille
     * @param grilleTab        le tableau bidimensionnel représentant la grille
     */
    public GrilleImpl(final ElementDeGrille[] elementDeGrilles, 
                    final ElementDeGrille[][] grilleTab) {
        dimension = elementDeGrilles.length;
        this.alphabet = new HashSet<>();
        grille = grilleTab;
            for (int i = 0; i < elementDeGrilles.length; i++) {
            this.alphabet.add(elementDeGrilles[i]);
        }
        // on conserve les valeurs initiales
        setInitialesPositions();
    }
    
    public Set<ElementDeGrille> getElements() {
        return this.alphabet;
    }

    public int getDimension() {
       return this.dimension;
    }

    public void setValue(final int x, final int y, final ElementDeGrille value) 
        throws HorsBornesException, ValeurImpossibleException, 
        ElementInterditException, ValeurInitialeModificationException {
                if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
                    throw new HorsBornesException();
                }
                if (isValeurInitiale(x, y)) {
                    throw new ValeurInitialeModificationException();
                }
                if (!isJouable(x, y, value) || isValeurInitiale(x, y)) {
                    throw new ValeurImpossibleException(value);
                }
                if (value != null && !isAlphabet(value)) {
                    throw new ElementInterditException();
                }
                this.grille[x][y] = value;
    }

    public ElementDeGrille getValue(final int x, final int y) 
        throws HorsBornesException {
        if ((x > this.dimension) || (x < 0) || 
            (y > this.dimension) || (y < 0)) {
            throw new HorsBornesException();
        }
        return this.grille[x][y];
    }

    public boolean isComplete() {
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if (this.grille[i][j] == null) {   
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isPossible(final int x, final int y, final ElementDeGrille value) 
        throws HorsBornesException, ValeurImpossibleException {
        if (x < 0 || x >= dimension || y < 0 || y >= dimension) {
                    throw new HorsBornesException();
                }
        if (value == null && !isValeurInitiale(x, y)) {
            return true;
        }

        if (!isJouable(x, y, value) || isValeurInitiale(x, y)) {
            throw new ValeurImpossibleException(value);
        }
        return true;
    }

    public boolean isValeurInitiale(final int x, final int y) {
       return lignesInitiales[x][y];
    }

    /**
     * Définit les positions initiales dans la grille.
     */
    private void setInitialesPositions() {
        lignesInitiales = new boolean[dimension][dimension];
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if (this.grille[i][j] != null) {
                    lignesInitiales[i][j] = true;
                } else {
                    lignesInitiales[i][j] = false;
                }
            }
        }
    }

    /**
     * Vérifie si l'élément donné fait partie de l'alphabet de la grille.
     *
     * @param element l'élément à vérifier
     * @return true si l'élément fait partie de l'alphabet, false sinon
     */
    public boolean isAlphabet(final ElementDeGrille element) {
        Iterator<ElementDeGrille> iterator = this.alphabet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Vérifie si élm donné peut être joué à la position spécifiée.
     *
     * @param x       la position x dans la grille
     * @param y       la position y dans la grille
     * @param element l'élément à jouer
     * @return true si l'élément peut être joué à cette position, false sinon
     */
    public boolean isJouable(final int x, final int y, 
                            final ElementDeGrille element) {
        // Parcours de la ligne
        for (int i = 0; i < this.dimension; i++) {
            if (i != x && this.grille[i][y] != null && 
                this.grille[i][y].equals(element)) {
                return false;
            }
        }

        // Parcours de la colonne
        for (int i = 0; i < this.dimension; i++) {
            if (i != y && this.grille[x][i] != null && 
                this.grille[x][i].equals(element)) {
                return false;
            }
        }

        // Parcours de la sous-grille
        int dimensionCase = (int) Math.sqrt(this.dimension);
        int sousGrilleXDebut = x - (x % dimensionCase);
        int sousGrilleXFin = sousGrilleXDebut + dimensionCase;
        int sousGrilleYDebut = y - (y % dimensionCase);
        int sousGrilleYFin = sousGrilleYDebut + dimensionCase;

        for (int i = sousGrilleXDebut; i < sousGrilleXFin; i++) {
            for (int j = sousGrilleYDebut; j < sousGrilleYFin; j++) {
                if (i != x && j != y && this.grille[i][j] != null && 
                    this.grille[i][j].equals(element)) {
                    return false;
                }
            }
        }
        return true;
    }

}
