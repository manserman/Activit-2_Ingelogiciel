package exceptions;

import sudoku.ElementDeGrille;


/**
 * Activité 2, ValeurImpossibleException.java.
 *
 * @author Mohamadou Mansour
 * package-info.java: toutes les infos sur le package
 *
 * class ValeurImpossibleException .
 */
public class ValeurImpossibleException  extends Exception {
   public ValeurImpossibleException (  ) {
      super("Saisie impossible car la valur ne fais pas partie de l'alphabet");
   }

   public ValeurImpossibleException(String valueOf) {
      super(valueOf);
   }

   public ValeurImpossibleException( ElementDeGrille value) {
      super("Saisie impossible car non respect des regles");
   }
}
