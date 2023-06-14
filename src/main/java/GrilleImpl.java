import java.util.Set;

public class GrilleImpl implements Grille {
    private int lignes=9;
    private int colonnes=9;
    private ElementDeGrille[] elementsInitiales;
    private ElementDeGrille[][] grille;

    public GrilleImpl(int x, int y) {
        this.lignes = x;
        this.colonnes = y;
        this.grille = new ElementDeGrille[x][y];
    }

    public GrilleImpl(ElementDeGrille[] elements) {
        this.elementsInitiales = elements;
        this.lignes; // Valeur par défaut pour une grille de Sudoku 9x9
        this.colonnes;
        this.grille = new ElementDeGrille[lignes][colonnes];
        initialiserGrille();
    }

    public GrilleImpl(int x, int y, ElementDeGrille[] elements) {
        this.lignes = x;
        this.colonnes = y;
        this.elementsInitiales = elements;
        this.grille = new ElementDeGrille[x][y];
        initialiserGrille();
    }

    private void initialiserGrille() {
        for (ElementDeGrille element : elementsInitiales) {
            int x = element.getX();
            int y = element.getY();
            grille[x][y] = element;
        }
    }

    @Override
    public Set<ElementDeGrille> getElements() {
        Set<ElementDeGrille> elements = new HashSet<>();
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (grille[i][j] != null) {
                    elements.add(grille[i][j]);
                }
            }
        }
        return elements;
    }

    @Override
    public int getDimension() {
        return lignes;
    }

    @Override
    public void setValue(int x, int y, ElementDeGrille value)
            throws HorsBornesException, ValeurImpossibleException, CaractereInterditException,
            ValeurInitialeModificationException {
        if (!estDansGrille(x, y)) {
            throw new HorsBornesException();
        }

        if (grille[x][y] instanceof ValeurInitiale) {
            throw new ValeurInitialeModificationException();
        }

        if (value instanceof Valeur) {
            char val = ((Valeur) value).getValeur();
            if (!estValeurPossible(val)) {
                throw new CaractereInterditException();
            }
        }

        grille[x][y] = value;
    }

    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        if (!estDansGrille(x, y)) {
            throw new HorsBornesException();
        }
        return grille[x][y];
    }

    @Override
    public boolean isComplete() {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                if (grille[i][j] == null) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value) throws HorsBornesException, CaractereInterditException {
        if (!estDansGrille(x, y)) {
            throw new HorsBornesException();
        }

        if (value instanceof Valeur) {
            char val = ((Valeur) value).getValeur();
            if (!estValeurPossible(val)) {
                throw new CaractereInterditException();
            }
        }

        return true; 
    }

    public boolean isValeurInitiale(int x, int y) {
        if (!estDansGrille(x, y)) {
            return false;
        }
        return grille[x][y] instanceof ValeurInitiale;
    }

    private boolean estDansGrille(int x, int y) {
        return x >= 0 && x < lignes && y >= 0 && y < colonnes;
    }

    @Override
    private boolean estValeurPossible(char val) {
        // Vérifier si la valeur est un chiffre entre 1 et 9 inclusivement
        return val >= '1' && val <= '9';
    }  
    
}
