/**
 * Activité 2, ValeurImpossibleException .java.
 *
 * @author Mohamadou Mansour
 *package-info.java: toutes les infos sur le package
 */
package act;
/**
 * class ValeurImpossibleException .
 */
public class ValeurImpossibleException  extends Exception {
   public ValeurImpossibleException () {
    super("Saisie impossible car la valur n'est pas comprise entre 0 et 9");
   }
}