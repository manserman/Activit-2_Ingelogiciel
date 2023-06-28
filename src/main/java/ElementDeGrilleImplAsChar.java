public class ElementDeGrilleImplAsChar implements ElementDeGrille {
    private char valeur;
    

    public ElementDeGrilleImplAsChar(char value) {
        super();
        this.valeur = value;
    }

  
    @Override
    public boolean equals(Object elem) {
        if (!(elem instanceof ElementDeGrilleImplAsChar)) {
            return false;
        }
        ElementDeGrilleImplAsChar el = (ElementDeGrilleImplAsChar) elem;
        if (this.valeur == el.valeur)
            return true;

        return false;
    }
   public char getValeur(){
    return this.valeur;
   }

}
