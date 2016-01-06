package Jeu;

public class Compagnie extends CarreauPropriete {

    
        public Compagnie(int numero, String nomCarreau, int prix,Monopoly mono) {
                super(numero, nomCarreau, prix, mono);
        }
    
	

        // y a pas besoin de mettre le nombre de compagnie en pramètre 
        public int calculMontant() {
            
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
       

         @Override
   
        public int calculLoyer(Joueur j) {
       
            Joueur jp = this.getProprietaire() ; 
            int nbc = jp.getCompagnies().size()-1 ; 
            
            int montant = this.calculMontant() ; 
            
            int Ar = j.calculArgentRest(montant) ; 
            
            //affichage du nom du propriétaire , montant à payer, Argent restant au joueur aprés avoir payer
            this.getMonopoly().getIHM().afficheCalculLoyer(Ar, montant,jp.getNomJoueur());

            return montant ;
        }
         
        
         
    


        
        
             
	public void Construire() {

	}     

}