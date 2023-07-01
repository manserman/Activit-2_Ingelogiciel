package exceptions;
/**
 * Activité 2, ElementInterditException.java.
 * Auteur : Mohamadou Mansour & Tshibangu Kevin
 * package-info.java: toutes les infos sur le package
 */
/**
 * Classe ElementInterditException.
 * Cette exception est levée car elle doit être entre 0 et 9
 */
public class ElementInterditException extends Exception {
    /**
     * Constructeur par défaut de ElementInterditException.
     */
   public ElementInterditException() {
       super("Saisie impossible car la valeur n'est pas comprise entre 0 et 9");
   }
}
