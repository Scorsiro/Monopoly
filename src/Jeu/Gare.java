package Jeu;

public class Gare extends CarreauPropriete {
        

        public Gare(int numero, String nomCarreau, int prix, Monopoly mono) {
                super(numero,nomCarreau,prix,mono);
        }
        

        public int calculMontant (Joueur j) {
        
            Joueur jp = this.getProprietaire() ; 
            int nbgare = jp.getGares().size() ; 
 
            
            int montant = 25 * nbgare ; 
            
            return montant ; 
        
        }
     

  
        @Override
        public int calculLoyer(Joueur j) {
             
            Joueur jp = this.getProprietaire() ; 

            int montant = this.calculMontant(j) ; 

            int ar = j.calculArgentRest(montant) ; 

            this.getMonopoly().getIHM().afficheCalculLoyer(ar, montant,jp.getNomJoueur());
            return montant ; 

        }

       
      

        @Override
          public  void acheterPropriete(Joueur j ) {
        
            if (!j.peutPayer(this.getPrix())) {
                
                this.getMonopoly().getIHM().affichePeutPasPayer(); 
                
            }
            
            else {   
                
                if (1 == this.getMonopoly().getIHM().getAchatRep()) {
                
                    this.getNomCarreau() ; 

                    j.payerLoyer(this.getPrix());
                   
                    this.setProprietaire(j);
                   j.getGares().add(this); 

                }
                
                else {
                    
                    this.getMonopoly().getIHM().affichePasAcheter();
                       
                }
                
                
            }
       
        }
}