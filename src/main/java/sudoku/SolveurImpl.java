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
    public boolean solve(Grille grille) {
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
                       Innerloop: for (ElementDeGrille element : 
                            grille.getElements()) {
                            // il on peut placer l'élément en respectant les règles
                            try {
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
                catch (HorsBornesException | ElementInterditException | 
                        ValeurInitialeModificationException e) {
                    e.printStackTrace();
                }
            }  
        }   
        // La grille est complète, la solution est trouvée
        return false;
    }

    /**
     * Point d'entrée de l'application.
     *
     * @param args les arguments de la ligne de commande
     */
    public static void main(String[] args) {
        InputStream in = 
    GrilleParser.class.getResourceAsStream("/grilles/sudoku16-expert.txt");
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
                        line = line + " " + 
                        String.valueOf(grille.getValue(i, j).getValeur());  
                    }
                    System.out.println(line);
                }
            }
        } catch (IOException | ValeurInitialeModificationException | 
                HorsBornesException | ValeurImpossibleException e) {
            e.printStackTrace();
        }
    }
}
