import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

    /**
     * Implémentation de l'interface Grille.
    */
    public class GrilleImpl implements Grille {
    private final int dimension;
    private boolean[][] lignesInitiales;
    private final Set<ElementDeGrille> alphabet;
    private ElementDeGrille grille[][];

    /**
     * @param elementDeGrilles
     * @param grilleTab
     */
    public GrilleImpl( ElementDeGrille[] elementDeGrilles, ElementDeGrille[][] grilleTab) {
        dimension=elementDeGrilles.length;
        this.alphabet = new HashSet<>();
        grille=grilleTab;
            for(int i=0; i<elementDeGrilles.length; i++) {
            this.alphabet.add(elementDeGrilles[i]);
        }
        setInitialesPositions(); // on conserve les valeurs initiales
    }
    
    @Override
    public Set<ElementDeGrille> getElements() {
        
        return this.alphabet;
    }

    @Override
    public int getDimension() {
       return this.dimension;
    }

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException, ElementInterditException, ValeurInitialeModificationException {
        if(isValeurInitiale(x, y)) {
            throw new ValeurInitialeModificationException();
        }
        
        if((x>this.dimension) || (x < 0) || (y>this.dimension) || (y < 0)) {
            throw new HorsBornesException();
        }

        if(value !=null && !isAlphabet(value)) {
            throw new ElementInterditException();
        }
        this.grille[x][y] = value;
    }

    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        if((x>this.dimension) || (x < 0) || (y>this.dimension) || (y < 0)) {
            throw new HorsBornesException();
        }
        return this.grille[x][y];
    }

    @Override
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

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException {
        if (! isJouable(x, y, value)) {  // à voir
            
            throw new ValeurImpossibleException(value);
        }
        return true;
    }

    @Override
    public boolean isValeurInitiale(int x, int y) {
       return lignesInitiales[x][y];
    }

    private void setInitialesPositions() {
        lignesInitiales= new boolean[dimension][dimension];
        for (int i = 0; i < this.dimension; i++) {
            for (int j = 0; j < this.dimension; j++) {
                if (this.grille[i][j] != null) {
                lignesInitiales[i][j]=true;
                }
                else 
                lignesInitiales[i][j]=false;
            }
        }
    }


    public boolean isAlphabet(ElementDeGrille element) {
        Iterator<ElementDeGrille> iterator = this.alphabet.iterator();
        while (iterator.hasNext()) {
            if(  iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    public boolean isJouable(int x, int y, ElementDeGrille element) {
        // Parcours de la ligne
        for (int i = 0; i < this.dimension; i++) {
            if (i != x && this.grille[i][y] != null && this.grille[i][y].equals(element)) {
                return false;
            }
        }

        // Parcours de la colonne
        for (int i = 0; i < this.dimension; i++) {
            if (i != y && this.grille[x][i] != null && this.grille[x][i].equals(element)) {
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
                if (i != x && j != y && this.grille[i][j] != null && this.grille[i][j].equals(element)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isRegionJouable(int startX, int startY) {
        ArrayList<ElementDeGrille> elements = new ArrayList<>();

        int dimensionCase = (int) Math.sqrt(this.dimension);
        for (int i = startX; i < startX + dimensionCase; i++) {
            for (int j = startY; j < startY + dimensionCase; j++) {
                ElementDeGrille element = this.grille[i][j];
                if (element != null) {
                    if (elements.contains(element)) {
                        return false;
                    } else {
                        elements.add(element);
                    }
                }
            }
        }
        return true;
    }
}
