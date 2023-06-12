package acttest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test; // import pour l'annotation @Test indiquant qu'il s'agit d'une méthode de test

import act.ElementDeGrille;
import act.Grille;
import act.HorsBornesException;
import act.*;
public class GrilleTest{
    @Test
    public void testSetValue(){
        Grille grille=new Sudoku(9,9);
        ElementDeGrille element=new Case(5);
        ElementDeGrille element1=new Case(3);
        try{
            grille.setValue(10,9, element);
            fail("HorsBornesException aurait du être levee");}
        catch(HorsBornesException e)
        {

        }
        try{
            grille.setValue(2,1, element);
            grille.setValue(2,2, element1);
            fail("ValeurImpossibleException aurait du être levee");}
        catch(ValeurImpossibleException e)
        {

        }
      
    }
}