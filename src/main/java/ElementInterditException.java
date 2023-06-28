/**
 * Activité 2, ElementInterditException .java.
 *
 * @author Mohamadou Mansour
 *package-info.java: toutes les infos sur le package
 */
/**
 * class ElementInterditException .
 */
public class ElementInterditException  extends Exception {
   public ElementInterditException () {
    super("Saisie impossible car la valur n'est pas comprise entre 0 et 9");
   }

public ElementInterditException(String valueOf) {
}
}