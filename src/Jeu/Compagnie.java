package Jeu;

public class Compagnie extends CarreauPropriete {

    
        public Compagnie(int numero, String nomCarreau, int prix) {
                super(numero, nomCarreau, prix);
        }
    
	public void Action(Joueur j) {

	}

        private int calculMontant(int nbCompagnie) {
            
            Joueur proprietaire = this.getProprietaire() ; 
            int montant = 0 ; 
            //le propriètaire possède une carte compagnie ==> montant = 4 fois le montant des dés 
                if (this.getProprietaire().getCompagnies().size() == 1 ) {
                
                    montant = 4 * this.getProprietaire().getDes(); 
                   
                }
                
            //le propriétaire possède deux cartes compagnie ==> montant = 10 fois le montant des dés 
                
                if ( this.getProprietaire().getCompagnies().size() == 2 ) {
        
                    montant = 10* this.getProprietaire().getDes() ; 
                }
                
            return montant  ; }
        
        
	private int calculLoyer(Joueur j) {
            
            Joueur jp = this.getProprietaire() ; 
            int nbc = jp.getCompagnies().size() ; 
            
            int montant = this.calculMontant(nbc) ; 
            
            int Ar = j.calculArgentRest(montant) ; 
            //affichage du nom du propriétaire , montant à payer, Argent restant au joueur aprés avoir payer 
            //affiche() 

            return montant ; }

	public void Construire() {

	}       
     
	

	

	public void acheterPropriete() {

	}
}