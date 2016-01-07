package Jeu;

public abstract class CarreauPropriete extends Carreau {
    
	private int loyerBase;
        private Joueur j;
        private int prix;
        Monopoly mono;
        
        

        public CarreauPropriete(int numero, String nomCarreau, int prix, Monopoly mono) {
                super(numero, nomCarreau,mono);
                this.prix = prix;
                this.mono = mono;
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
                
                if (this.getMonopoly().getIHM().getAchatRep() == 1) {
                this.getNomCarreau() ; 
                j.payerLoyer(this.getPrix());
                
                this.setProprietaire(j);
                } 
            }
        }
        
        @Override
       public void action(Joueur j) {
            
            Joueur jP = this.getProprietaire() ; 
            int rep = -1;
                
            if (jP != j) {
                int montant = this.calculLoyer(j) ; 
                j.payerLoyer(montant);
                jP.recevoirLoyer(montant);
            }
            
            while(rep != 0){
                rep = mono.getIHM().AfficheMenuPA();
                if(rep == 1){
                    if (jP == null ) {
                        this.acheterPropriete(j);
                    }else{
                        mono.getIHM().affichePasAcheter();
                    }
                }else if( rep == 2){
                    this.construire(j);
                }
            }     
        }

        // Les méthodes sont redéfinis dans : gare , compagnie , PropriétéAconstruire 
	public abstract int calculMontant () ; 
       
        public abstract int calculLoyer(Joueur j ) ; 
        
  
        
       
        
        
}