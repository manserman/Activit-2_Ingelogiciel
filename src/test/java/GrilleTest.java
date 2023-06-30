
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test; // import pour l'annotation @Test indiquant qu'il s'agit d'une méthode de test

import exceptions.ElementInterditException;
import exceptions.HorsBornesException;
import exceptions.ValeurImpossibleException;
import exceptions.ValeurInitialeModificationException;
import sudoku.ElementDeGrille;
import sudoku.ElementDeGrilleImplAsChar;
import sudoku.Grille;
import sudoku.GrilleImpl;
import sudoku.GrilleParser;

public class GrilleTest {

    @Test
    public void testSetValueHorsBornes() throws ValeurImpossibleException,
            ValeurInitialeModificationException, HorsBornesException, IOException, ElementInterditException {
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);
        ElementDeGrille element = new ElementDeGrilleImplAsChar('5');
        try {
            grille.setValue(25, 9, element);
            fail("HorsBornesException aurait du être levee");
        } catch (HorsBornesException e) {

        }

    }

    @Test
    public void testSetValueValeursImpossible() throws HorsBornesException, ValeurImpossibleException,
            ValeurInitialeModificationException, IOException, ElementInterditException {
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);
        ElementDeGrille element = new ElementDeGrilleImplAsChar('b');

        try {
            grille.setValue(2, 2, element);

            fail("ValeurImpossibleException aurait du être levee");
        } catch (ValeurImpossibleException e) {

        }

    }

    @Test
    public void testSetValueCaractereInterditImpossible() throws HorsBornesException, ValeurImpossibleException,
            ValeurInitialeModificationException, IOException, ElementInterditException {
        ElementDeGrille element = new ElementDeGrilleImplAsChar(':');
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);
        try {
            grille.setValue(2, 2, element);
            fail("ElementInterditException aurait du être levee");
        } catch (ElementInterditException e) {

        }

    }

    @Test
    public void testSetValueValeurInitialeModification() throws HorsBornesException, ValeurImpossibleException,
            ValeurInitialeModificationException, IOException, ElementInterditException {

        ElementDeGrille element0 = new ElementDeGrilleImplAsChar('0');
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);

        try {
            grille.setValue(0, 0, element0);
            fail("ValeurInitialeModificationException aurait du être levee");
        } catch (ValeurInitialeModificationException e) {

        }

    }

    @Test
    public void testSetValue() throws HorsBornesException, ValeurImpossibleException,
            ValeurInitialeModificationException, ElementInterditException, IOException {
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);
        ElementDeGrille element0 = new ElementDeGrilleImplAsChar('6');
        ElementDeGrille element1 = new ElementDeGrilleImplAsChar('c');
        grille.setValue(0, 1, element0);
        assertEquals(grille.getValue(0, 1), element0);
        grille.setValue(1, 1, element1);
        assertEquals(grille.getValue(1, 1), element1);

    }

    @Test
    public void testIspossibleValeurImpossible()
            throws ValeurImpossibleException, IOException, ValeurInitialeModificationException, HorsBornesException {
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);
        ElementDeGrille element0 = new ElementDeGrilleImplAsChar('0');

        try {
            grille.isPossible(0, 0, element0);
            fail("ValeurImposisbleException aurait du être levee");
        } catch (ValeurImpossibleException e) {

        }
    }

    @Test
    public void testIspossibleHorsBorne()
            throws ValeurImpossibleException, IOException, ValeurInitialeModificationException, HorsBornesException {
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);
        ElementDeGrille element0 = new ElementDeGrilleImplAsChar('0');

        try {
            grille.isPossible(25, 0, element0);
            fail("HorsBornesException aurait du être levee");
        } catch (HorsBornesException e) {

        }
    }

    @Test
    public void testIspossible()
            throws ValeurImpossibleException, IOException, ValeurInitialeModificationException, HorsBornesException {
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);
        ElementDeGrille element0 = new ElementDeGrilleImplAsChar('6');

        try {
            assertTrue(grille.isPossible(0, 1, element0));

        } catch (ValeurImpossibleException e) {

        }
    }

    @Test
    public void testIsComplete()
            throws IOException, ValeurImpossibleException, ValeurInitialeModificationException, HorsBornesException {
        {
            InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");
            Grille grille = GrilleParser.parse(in);
            ElementDeGrille[] alphabet = new ElementDeGrille[3];
            ElementDeGrille[][] tableau = new ElementDeGrille[3][3];
            for (int i = 0; i < 3; i++) {
                alphabet[i] = new ElementDeGrilleImplAsChar((char) i);
                for (int j = 0; j < 3; j++) {
                    tableau[i][j]= alphabet[i];
                }
            }
            Grille grille1 = new GrilleImpl(alphabet, tableau);
            assertFalse(grille.isComplete());
            assertTrue(grille1.isComplete());

        }

    }

    @Test
    public void testIsValeurInitiiale()
            throws ValeurImpossibleException, IOException, ValeurInitialeModificationException, HorsBornesException {
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);

        assertTrue(grille.isValeurInitiale(0, 0));
        assertFalse(grille.isValeurInitiale(0, 1));

    }
      @Test
    public void testGetValueHorsBornes() throws ValeurImpossibleException,
            ValeurInitialeModificationException, HorsBornesException, IOException, ElementInterditException {
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);
        try {
            grille.getValue(25, 9);
            fail("HorsBornesException aurait du être levee");
        } catch (HorsBornesException e) {

        }

    }
      @Test
    public void testGetValue() throws ValeurImpossibleException,
            ValeurInitialeModificationException, HorsBornesException, IOException, ElementInterditException {
        InputStream in = GrilleParser.class.getResourceAsStream("/grilles/sudoku16-a.txt");

        Grille grille = GrilleParser.parse(in);
        ElementDeGrille element = new ElementDeGrilleImplAsChar('3');
        ElementDeGrille element1 = new ElementDeGrilleImplAsChar('4');
        try {
            assertEquals(element, grille.getValue(0, 0) );
            assertFalse(element1.equals(grille.getValue(0, 0) ));
        } catch (HorsBornesException e) {

        }

    }
}