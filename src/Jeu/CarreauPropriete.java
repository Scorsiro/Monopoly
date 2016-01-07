package Jeu;

public abstract class CarreauPropriete extends Carreau {
    

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
        
	
 
        
        
        @Override
       public void action(Joueur j) {
            
            Joueur jP = this.getProprietaire() ; 
            int rep = 0;
                
            if (jP != j && jP != null) {
                int montant = this.calculLoyer(j) ; 
                j.payerLoyer(montant);
                jP.recevoirLoyer(montant);
            }
            while(rep != 3){
                rep = mono.getIHM().afficheCadreChoix();
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
        
        public abstract void acheterPropriete(Joueur j ) ;
        
       
        
        
}