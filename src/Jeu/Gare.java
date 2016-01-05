package Jeu;

public class Gare extends CarreauPropriete {
        

        public Gare(int numero, String nomCarreau, int prix) {
                super(numero,nomCarreau,prix);
        }
        
	public void action(Joueur j) {
	}

	public void construire() {
	}

        public int calculMontant () {
        
            Joueur jp = this.getProprietaire() ; 
            int nbgare = jp.getCompagnies().size() ; 
 
            
            int montant = 25 * nbgare ; 
            
            return montant ; 
        
        }
     

  
        @Override

        public int calculeLoyer(Joueur j) {
             
            Joueur jp = this.getProprietaire() ; 

            int montant = this.calculMontant() ; 

            int ar = j.calculArgentRest(montant) ; 

            return montant ; 

        }

         @Override
        
         public void acheterPropriete() {
            
             throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

}