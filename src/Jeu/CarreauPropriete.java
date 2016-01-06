package Jeu;

public abstract class CarreauPropriete extends Carreau {
    
	private int loyerBase;
        private Joueur j;
        private int prix;
        
        

        public CarreauPropriete(int numero, String nomCarreau, int prix, Monopoly mono) {
                super(numero, nomCarreau,mono);
                this.prix = prix;
        }


	

        public Joueur getProprietaire(){
                return j;
        }
        
	public void setProprietaire(Joueur j) {
                this.j = j;
	}

	public int getPrix() {
                return prix;
	}

        public void setPrix(int prix) {
                this.prix = prix;
        }
        
	public  void acheterPropriete(Joueur j ) {
        
            if (!j.peutPayer(this.getPrix())) {
                
                this.getMonopoly().getIHM().affichePeutPasPayer(); 
                
            }
            
            else {   
                
                if (this.getMonopoly().getIHM().getAchatRep().equals("oui")) {
                
                this.getNomCarreau() ; 
                
                j.payerLoyer(this.getPrix());
                
                this.setProprietaire(j);
                
                }
                
               
            }
        
        }
        
       public void action(Joueur j) {
            
            Joueur jP = this.getProprietaire() ; 
            
            if (jP == null ) {
                //if(veutAcheter())
                this.acheterPropriete(j);
            }
            else if (jP != j) {
            
                this.calculLoyer(j) ; 

                j.payerLoyer(this.calculLoyer(j));
                jP.recevoirLoyer(this.calculLoyer(j));
            }
            
            this.construire(j);
        }

        // Les méthodes sont redéfinis dans : gare , compagnie , PropriétéAconstruire 
	public abstract int calculMontant () ; 
       
        public abstract int calculLoyer(Joueur j ) ; 
        
  
        
       
        
        
}