import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class GrilleImpl implements Grille {
    private final int dimension;
    private int lignes=9;
    private int colonnes=9;
    private ElementDeGrille[] elementsInitiales;
    private final ElementDeGrille[] alphabet;
    private char position[][];
    private ElementDeGrille position1[][];
 public GrilleImpl(ElementDeGrille[] elementDeGrilles, ElementDeGrille[][] grilleTab) {
        dimension=elementDeGrilles.length;
        alphabet=elementDeGrilles;
        position1=grilleTab;

    }
    public GrilleImpl(int x,int y){
      this.lignes=x;
      this.colonnes=y;
    }
    public GrilleImpl(ElementDeGrille[] elements){
        position=new char[lignes][colonnes];
     this.elementsInitiales=elements;
     init();
    }
    private void init(){

    }
     public GrilleImpl(int x,int y,ElementDeGrille[] elements){
      this.lignes=x;
      this.colonnes=y;
      this.elementsInitiales=elements;
    }
    @Override
    public Set<ElementDeGrille> getElements() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public int getDimension() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getDimension'");
    }

    @Override
    public void setValue(int x, int y, ElementDeGrille value) throws HorsBornesException, ValeurImpossibleException,
            CaractereInterditException, ValeurInitialeModificationException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setValue'");
    }

    @Override
    public ElementDeGrille getValue(int x, int y) throws HorsBornesException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getValue'");
    }

    @Override
    public boolean isComplete() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isComplete'");
    }

    @Override
    public boolean isPossible(int x, int y, ElementDeGrille value)
            throws HorsBornesException, CaractereInterditException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isPossible'");
    }

    @Override
    public boolean isValeurInitiale(int x, int y) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'isValeurInitiale'");
    }
     private void placerElementsAleatoirement() {

        for (int i = 0; elementsInitiales; i++) {
            
              
                   
                }
            }
        
    }

    
}
