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
 public class SolveurImpl implements Solveur{
    /**
     * Résoud une Grille.
     * @param grille Grille à résoudre
     * @return true si la grille a été résolue
     */
    
    @Override
    public static boolean solve(Grille grille) {
        int dimension = grille.getDimension();
        if (grille.isComplete()) {
            return true;
        }
        for (int x = 0; x < dimension; x++) {
            for (int y = 0; y < dimension; y++) {  
                try {
                    // si la case est vide
                    if (grille.getValue(x, y) == null) {
                        // parcourir les élements
                       Innerloop: for (ElementDeGrille element : grille.getElements()) {
                            // il on peut placer l'élément en respectant les règles
                            try{
                            if (grille.isPossible(x, y, element)) {
                                // Place l'élément dans la grille
                                grille.setValue(x, y, element);
                                // on cherche à remplir d'autres cases vides
                                if (solve(grille)) {
                                    // Récursivement, si la grille est résolue, la solution est trouvée
                                    return true;
                                }
                                // Aucun élément ne peut être placé ici, la solution est impossible
                                grille.setValue(x, y, null); 
                            }
                        } catch (ValeurImpossibleException e) {
                    continue Innerloop;
                }
                    }
                        return false;
                    }
                }
                catch (HorsBornesException | ElementInterditException | ValeurInitialeModificationException e) {
                    e.printStackTrace();
                }
            }  
        }   
        // La grille est complète, la solution est trouvée
        return false;
    }

    public int countPossibleElements(Grille grille, int x, int y) throws HorsBornesException {// compter le nombre de  choix possibles par case
        int count = 0;
        for (ElementDeGrille element : grille.getElements()) {
            try {
                if (grille.isPossible(x, y, element)) {
                    count++;
                }
            } catch (ValeurImpossibleException e) {
                // Ignorer les valeurs impossibles
            }
        }
        return count;
    }

    public  List<ElementDeGrille> getPossibleElements(Grille grille, int x, int y) {// Méthode pour avoir la liste des éléments possibles par case vide pour éviter de tester tous les éléments
        List<ElementDeGrille> possibleElements = new ArrayList<>();
        for (ElementDeGrille element : grille.getElements()) {
            try {
                if (grille.isPossible(x, y, element)) {
                    possibleElements.add(element);
                }
            } catch (ValeurImpossibleException e) {
                // Ignorer les valeurs impossibles
            } catch (HorsBornesException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return possibleElements;
    }

    public static void main(String[] args) {
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-expert.txt");
        try { 
            String line;
            Grille grille = GrilleParser.parse(in);
            if (!(new SolveurImpl()).solve(grille)) {
                System.out.println("Aucune solution trouvée.");
            
            } else {
                System.out.println("Solution trouvée :");
                for (int i = 0; i < grille.getDimension(); i++) {
                    line = new String();
                    for (int j = 0; j < grille.getDimension(); j++) {
                        line = line + " " + String.valueOf(grille.getValue(i, j).getValeur());  
                    }
                    System.out.println(line);
                }
            }
        } catch (IOException | ValeurInitialeModificationException | HorsBornesException | ValeurImpossibleException e) {
            e.printStackTrace();
        }
    }
}
