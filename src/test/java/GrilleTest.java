import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;
import java.io.InputStream;

import org.junit.jupiter.api.Test;

import exceptions.ElementInterditException;
import exceptions.HorsBornesException;
import exceptions.ValeurImpossibleException;
import exceptions.ValeurInitialeModificationException;
import sudoku.ElementDeGrille;
import sudoku.ElementDeGrilleImplAsChar;
import sudoku.Grille;
import sudoku.GrilleImpl;
import sudoku.GrilleParser;
/**
 * Implémentation de des tests unitaires.
 *
 * @author : Groupe_Z
 */
public class GrilleTest {
/**
* chemin de la grille que nous alons utiliser pour les test.
*/
private static final String TEST_GRID_FILE = "/grilles/sudoku16-a.txt";
/**
* taille de la grille que nous alons utiliser pour les test.
*/
private static final int GRID_SIZE = 16;
    /**
     * Affecte une valeur dans une case de la grille, ou null pourviderla case.
     *
     * @throws ValeurImpossibleException si l'élément de grille n'est pas
     * autorisé à cette position dans la grille aux vues des autres valeurs
     * de la grille
     * @throws ElementInterditException si l'élément de grille n'est pas 
     * autorisé dans cette grille
     * @throws HorsBornesException si x ou y sont en dehors de la grille
     * @throws ValeurInitialeModificationException si une valeur initiale de la
     * grille est en position x,y
     * @throws IOException
     */
@Test
public final void testSetValueHorsBornes() throws IOException,
     HorsBornesException, ValeurImpossibleException,
     ValeurInitialeModificationException, ElementInterditException {
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);
    ElementDeGrille element = new ElementDeGrilleImplAsChar('5');
    try {
        grille.setValue(GRID_SIZE + 1, GRID_SIZE - 7, element);
        fail("HorsBornesException aurait dû être levée");
    } catch (HorsBornesException e) {
        // Exception attendue
    }
}
    /**
     * Affecte une valeur dans une case de la grille, ou null pourviderla case.
     *
     * @throws ValeurImpossibleException si l'élément de grille n'est pas
     * autorisé à cette position dans la grille aux vues des autres valeurs
     * de la grille
     * @throws ElementInterditException si l'élément de grille n'est pas
     * autorisé dans cette grille
     * @throws HorsBornesException si x ou y sont en dehors de la grille
     * @throws ValeurInitialeModificationException si une valeur initiale de la
     * grille est en position x,y
     * @throws IOException
     */
@Test
public final void testSetValueValeursImpossible() throws IOException,
     HorsBornesException, ValeurImpossibleException,
     ValeurInitialeModificationException, ElementInterditException {
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);
    ElementDeGrille element = new ElementDeGrilleImplAsChar('b');

    try {
        grille.setValue(2, 2, element);
        fail("ValeurImpossibleException aurait dû être levée");
    } catch (ValeurImpossibleException e) {
        // Exception attendue
    }
}
    /**
     * Affecte une valeur dans une case de la grille, ou null pourviderla case.
     *
     * @throws ValeurImpossibleException si l'élément de grille n'est pas
     * autorisé à cette position dans la grille aux vues des autres valeurs
     * de la grille
     * @throws ElementInterditException si l'élément de grille n'est pas
     * autorisé dans cette grille
     * @throws HorsBornesException si x ou y sont en dehors de la grille
     * @throws ValeurInitialeModificationException si une valeur initiale de la
     * grille est en position x,y
     * @throws IOException
     */
@Test
public final void testSetValueCaractereInterditImpossible() throws IOException,
     HorsBornesException, ValeurImpossibleException,
     ValeurInitialeModificationException, ElementInterditException {
    ElementDeGrille element = new ElementDeGrilleImplAsChar(':');
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);
    try {
        grille.setValue(2, 2, element);
        fail("ElementInterditException aurait dû être levée");
    } catch (ElementInterditException e) {
        // Exception attendue
    }
}
    /**
     * Affecte une valeur dans une case de la grille, ou null pourviderla case.
     *
     * @throws ValeurImpossibleException si l'élément de grille n'est pas
     * autorisé à cette position dans la grille aux vues des autres valeurs
     * de la grille
     * @throws ElementInterditException si l'élément de grille n'est pas
     * autorisé dans cette grille
     * @throws HorsBornesException si x ou y sont en dehors de la grille
     * @throws ValeurInitialeModificationException si une valeur initiale de la
     * grille est en position x,y
     * @throws IOException
     */
@Test
public final void testSetValueValeurInitialeModification() throws IOException,
     HorsBornesException, ValeurImpossibleException,
     ValeurInitialeModificationException, ElementInterditException {

    ElementDeGrille element0 = new ElementDeGrilleImplAsChar('0');
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);

    try {
        grille.setValue(0, 0, element0);
        fail("ValeurInitialeModificationException aurait dû être levée");
    } catch (ValeurInitialeModificationException e) {
        // Exception attendue
    }
}
    /**
     * Affecte une valeur dans une case de la grille, ou null pourviderla case.
     *
     * @throws ValeurImpossibleException si l'élément de grille n'est pas
     * autorisé à cette position dans la grille aux vues des autres valeurs
     * de la grille
     * @throws ElementInterditException si l'élément de grille n'est pas
     * autorisé dans cette grille
     * @throws HorsBornesException si x ou y sont en dehors de la grille
     * @throws ValeurInitialeModificationException si une valeur initiale de la
     * grille est en position x,y
     * @throws IOException
     */
@Test
public final  void testSetValue() throws IOException,
     HorsBornesException, ValeurImpossibleException,
     ValeurInitialeModificationException, ElementInterditException {
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);
    ElementDeGrille element0 = new ElementDeGrilleImplAsChar('6');
    ElementDeGrille element1 = new ElementDeGrilleImplAsChar('c');
    grille.setValue(0, 1, element0);
    assertEquals(element0, grille.getValue(0, 1));
    grille.setValue(1, 1, element1);
    assertEquals(element1, grille.getValue(1, 1));
}
    /**
     * Teste si une valeur peut être placée dans la grille.
     *
     * @throws HorsBornesException      si x ou y sont hors bornes
     * @throws ValeurImpossibleException si la valeur est impossible à placer
     * à cette position
     * @throws ValeurInitialeModificationException si une valeur initiale de
     *  la grille est en position x,y
     * @throws IOException
     */
@Test
public final void testIspossibleValeurImpossible()
        throws IOException, ValeurImpossibleException,
        ValeurInitialeModificationException, HorsBornesException {
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);
    ElementDeGrille element0 = new ElementDeGrilleImplAsChar('0');

    try {
        grille.isPossible(0, 0, element0);
        fail("ValeurImpossibleException aurait dû être levée");
    } catch (ValeurImpossibleException e) {
        // Exception attendue
    }

    ElementDeGrille element1 = new ElementDeGrilleImplAsChar('8');
    try {
        grille.isPossible(1, 0, element1);
        fail("ValeurImpossibleException aurait dû être levée");
    } catch (ValeurImpossibleException e) {
        // Exception attendue
    }
    try {
        grille.isPossible(GRID_SIZE - 10, GRID_SIZE - 13, element1);
        fail("ValeurImpossibleException aurait dû être levée");
    } catch (ValeurImpossibleException e) {
        // Exception attendue
    }
    ElementDeGrille element2 = new ElementDeGrilleImplAsChar('9');
    try {
        grille.isPossible(2, 0, element2);
        fail("ValeurImpossibleException aurait dû être levée");
    } catch (ValeurImpossibleException e) {
        // Exception attendue
    }
}
     /**
     * Teste si une valeur peut être placée dans la grille.
     *
     * @throws HorsBornesException      si x ou y sont hors bornes
     * @throws ValeurImpossibleException si la valeur est impossible à placer
     *  à cette position
     * @throws ValeurInitialeModificationException si une valeur initiale de
     *  la grille est en position x,y
     * @throws IOException
     */
@Test
public final void testIspossibleHorsBorne()
        throws IOException, ValeurImpossibleException,
        ValeurInitialeModificationException, HorsBornesException {
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);
    ElementDeGrille element0 = new ElementDeGrilleImplAsChar('0');

    try {
        grille.isPossible(GRID_SIZE + 1, 0, element0);
        fail("HorsBornesException aurait dû être levée");
    } catch (HorsBornesException e) {
        // Exception attendue
    }
}
     /**
     * Teste si une valeur peut être placée dans la grille.
     *
     * @throws HorsBornesException      si x ou y sont hors bornes
     * @throws ValeurImpossibleException si la valeur est impossible à placer
     *  à cette position
     * @throws ValeurInitialeModificationException si une valeur initiale de la
     *  grille est en position x,y
     * @throws IOException
     */
@Test
public final void testIspossible()
        throws IOException, ValeurImpossibleException,
        ValeurInitialeModificationException, HorsBornesException {
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);
    ElementDeGrille element0 = new ElementDeGrilleImplAsChar('6');

    try {
        assertTrue(grille.isPossible(0, 1, element0));
    } catch (ValeurImpossibleException e) {
        // Exception attendue
    }

    try {
        assertTrue(grille.isPossible(0, 1, null));
    } catch (ValeurImpossibleException e) {
        // Exception attendue
    }
}
 /**
     * Teste si la grille est remplie.
     *
     * @throws HorsBornesException      si x ou y sont hors bornes
     * @throws ValeurImpossibleException si la valeur est impossible à placer
     * à cette position
     * @throws ValeurInitialeModificationException si une valeur initiale de
     * la grille est en position x,y
     * @throws IOException
     */
@Test
public final void testIsComplete()
        throws IOException, ValeurImpossibleException,
        ValeurInitialeModificationException, HorsBornesException {
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);
    Grille grille = GrilleParser.parse(in);
    ElementDeGrille[] alphabet = new ElementDeGrille[GRID_SIZE];
    ElementDeGrille[][] tableau = new ElementDeGrille[GRID_SIZE][GRID_SIZE];
    for (int i = 0; i < GRID_SIZE; i++) {
        alphabet[i] = new ElementDeGrilleImplAsChar((char) i);
        for (int j = 0; j < GRID_SIZE; j++) {
            tableau[i][j] = alphabet[i];
        }
    }
    Grille grille1 = new GrilleImpl(alphabet, tableau);
    assertFalse(grille.isComplete());
    assertTrue(grille1.isComplete());
}
    /**
     * Test si la grille est remplie.
     * @throws HorsBornesException      si x ou y sont hors bornes
     * @throws ValeurImpossibleException si la valeur est impossible à placer
     * à cette position
     * @throws ValeurInitialeModificationException si une valeur initiale de la
     * grille est en position x,y
     * @throws IOException
     */
@Test
public final void testIsValeurInitiiale()
        throws IOException, ValeurImpossibleException,
        ValeurInitialeModificationException, HorsBornesException {
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);

    assertTrue(grille.isValeurInitiale(0, 0));
    assertFalse(grille.isValeurInitiale(0, 1));
}
/**
* Renvoie une valeur de la grille.
* @throws HorsBornesException      si x ou y sont hors bornes
* @throws ValeurImpossibleException si la valeur est impossible à placer à
* cette position
* @throws ValeurInitialeModificationException si une valeur initiale de
* la grille est en position x,y
* @throws IOException
* @throws IOException
*/
@Test
public final void testGetValueHorsBornes() throws ValeurImpossibleException,
        ValeurInitialeModificationException, HorsBornesException, IOException {
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);
    try {
        grille.getValue(GRID_SIZE + 1, 0);
        fail("HorsBornesException aurait dû être levée");
    } catch (HorsBornesException e) {
        // Exception attendue
    }
}
/**
* Renvoie une valeur de la grille.
* @throws HorsBornesException      si x ou y sont hors bornes
* @throws ValeurImpossibleException si la valeur est impossible à
* placer à cette position
* @throws ValeurInitialeModificationException si une valeur initiale de la
* grille est en position x,y
* @throws IOException
*/
@Test
public final void testGetValue() throws ValeurImpossibleException,
        ValeurInitialeModificationException, HorsBornesException,
        IOException {
    InputStream in = GrilleParser.class.getResourceAsStream(TEST_GRID_FILE);

    Grille grille = GrilleParser.parse(in);
    ElementDeGrille element = new ElementDeGrilleImplAsChar('3');
    ElementDeGrille element1 = new ElementDeGrilleImplAsChar('4');
    try {
        assertEquals(element, grille.getValue(0, 0));
        assertNotEquals(element1, grille.getValue(0, 0));
    } catch (HorsBornesException e) {
        // Exception attendue
    }
}

}
