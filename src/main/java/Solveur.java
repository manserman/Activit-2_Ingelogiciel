import java.io.IOException;
import java.io.InputStream;

/**
 * Interface de résolveur de Grille
 *
 * @author Sébastien Choplin <sebastien.choplin@u-picardie.fr>
 */
public interface Solveur {
    /**
     * Résoud une Grille
     *
     * @param grille Grille à résoudre
     * @return true si la grille a été résolue
     */
    public static boolean solve(Grille grille) {
        if(grille.isComplete())
        return true;
            int dimension = grille.getDimension();

            for (int x = 0; x < dimension; x++) {
                for (int y = 0; y < dimension; y++) {
                     
                    try {
                       if (grille.getValue(x, y) == null) {// si la case est vide
                            for (ElementDeGrille element : grille.getElements()) {// parcourir les élements
                                if (grille.isPossible(x, y, element)) {// il on peut placer l'élément en respectant les règles
                                    grille.setValue(x, y, element); // Place l'élément dans la grille
                                    if (solve(grille)) {// on cherche à remplir d'autres cases vides
                                        return true; // Récursivement, si la grille est résolue, la solution est trouvée
                                    }
                                    // Aucun élément ne peut être placé ici, la solution est impossible
                                    grille.setValue(x, y, null); 
                                }
                            }

                            
                            return false;
                         }
                    } catch (HorsBornesException | ElementInterditException | ValeurImpossibleException | ValeurInitialeModificationException e) {
                        e.printStackTrace();
                   
                    }
                }
                
            }
        

        return false; // La grille est complète, la solution est trouvée
    }

public static void main(String[] args) {
    InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");
    try { 
        String line;
        Grille grille = GrilleParser.parse(in);
        if (!solve(grille)) {
            System.out.println("Aucune solution trouvée.");
          
        } else {
            System.out.println("Solution trouvée :");
            for (int i = 0; i < grille.getDimension(); i++) {
                line=new String();
                for (int j = 0; j < grille.getDimension(); j++) {
                    
                    line=line+" "+String.valueOf(grille.getValue(i, j).getValeur());
                    
                }
                System.out.println(line);
            }
        }
    } catch (IOException | ValeurInitialeModificationException | HorsBornesException | ValeurImpossibleException e) {
        e.printStackTrace();
    }
}
}
