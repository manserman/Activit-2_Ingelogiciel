/**
 * Activité 2, ElementInterditException.java.
 * 
 * Auteur : Mohamadou Mansour
 * package-info.java: toutes les infos sur le package
 */
 
/**
 * Classe ElementInterditException.
 * Cette exception est levée lorsque la valeur saisie n'est pas comprise entre 0 et 9.
 */
public class ElementInterditException extends Exception {
    
   /**
    * Constructeur par défaut de ElementInterditException.
    * Il crée une nouvelle instance de l'exception avec un message prédéfini.
    */
   public ElementInterditException() {
       super("Saisie impossible car la valeur n'est pas comprise entre 0 et 9");
   }
   
   /**
    * Constructeur de ElementInterditException avec un message personnalisé.
    * 
    * @param message Le message d'erreur personnalisé.
    */
   public ElementInterditException(String valueOf) {

   }
}
