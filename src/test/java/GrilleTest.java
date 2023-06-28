/* 
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test; // import pour l'annotation @Test indiquant qu'il s'agit d'une méthode de test


public class GrilleTest{
    @Test
    public void testSetValueHorsBornes() throws ValeurImpossibleException, CaractereInterditException, ValeurInitialeModificationException, HorsBornesException{
        Grille grille=new GrilleImpl(9);
        ElementDeGrille element=new ElementDeGrilleImplAsChar('5');
        try{
            grille.setValue(10,9, element);
            fail("HorsBornesException aurait du être levee");}
        catch(HorsBornesException e)
        {

        }
      
    }

    public void testSetValueValeursImpossible() throws HorsBornesException, ValeurImpossibleException, CaractereInterditException, ValeurInitialeModificationException{
        Grille grille=new GrilleImpl(9);
        ElementDeGrille element=new ElementDeGrilleImplAsChar('5');
        grille.setValue(2,1, element);
        try{
            grille.setValue(2,2, element);
             grille.setValue(3,2, element);
            fail("ValeurImpossibleException aurait du être levee");}
        catch(ValeurImpossibleException e)
        {

        }
      
    }
    
    public void testSetValueCaractereInterditImpossible() throws HorsBornesException, ValeurImpossibleException, CaractereInterditException, ValeurInitialeModificationException{
        Grille grille=new GrilleImpl(9);
        ElementDeGrille element=new ElementDeGrilleImplAsChar(':'); 
            
        grille.setValue(2,1, element);
        try{
            grille.setValue(2,2, element);
            fail("ValeurImpossibleException aurait du être levee");}
        catch(ValeurImpossibleException e)
        {

        }
      
    }
    public void testSetValueValeurInitialeModification() throws HorsBornesException, ValeurImpossibleException, CaractereInterditException, ValeurInitialeModificationException{
        ElementDeGrille[] element=new  ElementDeGrille[5]; 
        element[0]= new ElementDeGrilleImplAsChar('m');
        element[1]= new ElementDeGrilleImplAsChar('n');
        element[2]= new ElementDeGrilleImplAsChar('o');
        element[3]= new ElementDeGrilleImplAsChar('p');
        element[4]= new ElementDeGrilleImplAsChar('q');
        Grille grille=new GrilleImpl(4, element);
       ElementDeGrille element0=new ElementDeGrilleImplAsChar(':'); 
            
        
        try{
            grille.setValue(1,1, element0);
            fail("ValeurInitialeModificationException aurait du être levee");}
        catch(ValeurImpossibleException e)
        {

        }
      
    }

    public void testSetValue() throws HorsBornesException, ValeurImpossibleException, CaractereInterditException, ValeurInitialeModificationException
    {
         Grille grille=new GrilleImpl(9);
        ElementDeGrille element=new ElementDeGrilleImplAsChar('5');
         grille.setValue(2,9, element);
         assertEquals(grille.getValue(2,9),element);
         grille.setValue(2,3, element);
         assertEquals(grille.getValue(2,3),element);


          
    }
}*/