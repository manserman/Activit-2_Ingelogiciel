import java.util.Set;

public class Sudoku implements Grille {
    private int x,y;

    public Sudoku(int x,int y){
      this.x=x;
      this.y=y;
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
    
}
