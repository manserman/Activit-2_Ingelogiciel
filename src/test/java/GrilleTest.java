
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test; // import pour l'annotation @Test indiquant qu'il s'agit d'une méthode de test


public class GrilleTest{
    @Test
    public void testSetValueHorsBornes() throws ValeurImpossibleException, CaractereInterditException, ValeurInitialeModificationException, HorsBornesException{
        Grille grille=new Sudoku(9,9);
        ElementDeGrille element=new Case(5);
        try{
            grille.setValue(10,9, element);
            fail("HorsBornesException aurait du être levee");}
        catch(HorsBornesException e)
        {

        }
        grille.setValue(2,1, element);
        try{
            grille.setValue(2,2, element);
            fail("ValeurImpossibleException aurait du être levee");}
        catch(ValeurImpossibleException e)
        {

        }
      
    }

    public void testSetValueValeursImpossible() throws HorsBornesException, ValeurImpossibleException, CaractereInterditException, ValeurInitialeModificationException{
        Grille grille=new Sudoku(9,9);
        ElementDeGrille element=new Case(5);
        grille.setValue(2,1, element);
        try{
            grille.setValue(2,2, element);
            fail("ValeurImpossibleException aurait du être levee");}
        catch(ValeurImpossibleException e)
        {

        }
      
    }
}