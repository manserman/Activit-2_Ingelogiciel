package sudoku;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import exceptions.ElementInterditException;
import exceptions.HorsBornesException;
import exceptions.ValeurImpossibleException;
import exceptions.ValeurInitialeModificationException;

/**
 * Interface de résolveur de Grille.
 *
 * @author Sébastien Choplin <sebastien.choplin@u-picardie.fr>
 */
 public class SolveurImpl implements Solveur {
    /**
     * Résoud une Grille.
     * @param grille Grille à résoudre
     * @return true si la grille a été résolue
     */
    @Override
    public final boolean solve(final Grille grille) {
    int dimension = grille.getDimension();
    if (grille.isComplete()) {
        return true;
    }

    // Trouver la prochaine case vide avec le moins de choix possibles
    int minChoices = Integer.MAX_VALUE;
    int selectedX = -1;
    int selectedY = -1;

    for (int x = 0; x < dimension; x++) {
        for (int y = 0; y < dimension; y++) {
            try {
                if (grille.getValue(x, y) == null) {
                    int choices = countPossibleElements(grille, x, y);
                    if (choices < minChoices) {
                        minChoices = choices;
                        selectedX = x;
                        selectedY = y;
                    }
                }
            } catch (HorsBornesException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    if (selectedX == -1 || selectedY == -1) {
        // Aucune case vide trouvée, la grille est complète
        return true;
    }

    // Récursivement essayer chaque choix possible pour la case sélectionnée
    for (ElementDeGrille element : getPossibleElements(grille, selectedX,
    selectedY)) {
        try {
            if (grille.isPossible(selectedX, selectedY, element)) {
                grille.setValue(selectedX, selectedY, element);
                if (solve(grille)) {
                    return true;
                }
                grille.setValue(selectedX, selectedY, null);
            }
        } catch (ValeurImpossibleException e) {
            // Le choix courant n'est pas possible, passer au prochain choix
            continue;
        } catch (HorsBornesException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ElementInterditException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ValeurInitialeModificationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Aucun choix possible n'a conduit à une solution, retourner false
    return false;
}
/**
 * Méthode qui compte la les éléments possibles pour une
 * case vide donnée dans la grille.
 *
 * @param grille La grille de jeu.
 * @param x      La coordonnée X de la case.
 * @param y      La coordonnée Y de la case.
 * @return Une nombre d'éléments possibles pour la case.
 */
public final int countPossibleElements(final Grille grille,final int x,
               final int y) throws  HorsBornesException {
    // compter le nombre de  choix possibles par case
    int count = 0;
    for (ElementDeGrille element : grille.getElements()) {
        try {
            if (grille.isPossible(x, y, element)) {
                count++;
            }
        } catch (ValeurImpossibleException e) {
            // Ignorer les valeurs impossibles
            e.printStackTrace();
        }
    }
    return count;
}

/**
 * Méthode qui retourne la liste des éléments possibles pour une
 * case vide donnée dans la grille.
 *
 * @param grille La grille de jeu.
 * @param x      La coordonnée X de la case.
 * @param y      La coordonnée Y de la case.
 * @return Une liste d'éléments possibles pour la case vide spécifiée.
 */
public final List<ElementDeGrille> getPossibleElements(final Grille grille,
final int x,final int y) {
    // Méthode pour avoir la liste des éléments possibles par case
    //vide pour éviter
    //de tester tous les éléments
    List<ElementDeGrille> possibleElements = new ArrayList<>();
    for (ElementDeGrille element : grille.getElements()) {
        try {
            if (grille.isPossible(x, y, element)) {
                possibleElements.add(element);
            }
        } catch (ValeurImpossibleException e) {
            // Ignorer les valeurs impossibles
            e.printStackTrace();
        } catch (HorsBornesException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    return possibleElements;
}

    /**
     * Point d'entrée de l'application.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(final String[] args) {
        InputStream in =
    GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");
        try {
            Grille grille = GrilleParser.parse(in);
            if (!(new SolveurImpl()).solve(grille)) {
                System.out.println("Aucune solution trouvée.");
            } else {
                System.out.println("Solution trouvée :");
                for (int i = 0; i < grille.getDimension(); i++) {
                    StringBuffer buf = new StringBuffer();
                    for (int j = 0; j < grille.getDimension(); j++) {
                        buf.append(" ");
                     buf.append(String.valueOf(grille.getValue(i, j)
                     .getValeur()));
                    }
                    System.out.println(buf.toString());
                }
            }
        } catch (IOException | ValeurInitialeModificationException
               | HorsBornesException | ValeurImpossibleException e) {
            e.printStackTrace();
        }
    }
}
