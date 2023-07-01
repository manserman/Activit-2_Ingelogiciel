package exceptions;
   /**
   * Activité 2, ValeurInitialeModificationException.java.
   * @author Mohamadou Mansour
   * package-info.java: toutes les infos sur le package
   */
public class ValeurInitialeModificationException  extends Exception {
   /**
    * Constructeur par défaut de la classe ValeurInitialeModificationException
    * Il crée une nouvelle exception avec le message spécifiant qu'il 
    * est impossible de modifier les valeurs initiales.
    */
   public ValeurInitialeModificationException() {
      super("Impossible de modifier les veleurs initiales");
   }
}
