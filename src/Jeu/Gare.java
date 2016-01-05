package Jeu;

public class Gare extends CarreauPropriete {
        

        public Gare(int numero, String nomCarreau, int prix) {
                super(numero,nomCarreau,prix);
        }
        

        public int calculMontant () {
        
            Joueur jp = this.getProprietaire() ; 
            int nbgare = jp.getCompagnies().size() ; 
 
            
            int montant = 25 * nbgare ; 
            
            return montant ; 
        
        }
     

  
        @Override

        public int calculLoyer(Joueur j) {
             
            Joueur jp = this.getProprietaire() ; 

            int montant = this.calculMontant() ; 

            int ar = j.calculArgentRest(montant) ; 

            this.getMonopoly().getIHM().afficheCalculLoyer(ar, montant,jp.getNomJoueur());
            return montant ; 

        }

       
      

         

        public void construire() {
	}
}