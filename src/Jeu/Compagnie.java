package Jeu;

public class Compagnie extends CarreauPropriete {

    
        public Compagnie(int numero, String nomCarreau, int prix,Monopoly mono) {
                super(numero, nomCarreau, prix, mono);
        }
    
	

        // y a pas besoin de mettre le nombre de compagnie en pramètre 
        public int calculMontant(Joueur j) {
            
            int montant = 0 ; 
            //le propriètaire possède une carte compagnie ==> montant = 4 fois le montant des dés 
                if (this.getProprietaire().getCompagnies().size() == 1 ) {
                
                    montant = 4 * j.getDes(); 
                   
                }
                
            //le propriétaire possède deux cartes compagnie ==> montant = 10 fois le montant des dés 
                
                if ( this.getProprietaire().getCompagnies().size() == 2 ) {
        
                    montant = 10* j.getDes() ; 
                }
                
            return montant  ; }
       

         @Override
        public int calculLoyer(Joueur j) {
       
            Joueur jp = this.getProprietaire() ; 
            
            
            int montant = this.calculMontant(j) ; 
            
            int Ar = j.calculArgentRest(montant) ; 
            
            //affichage du nom du propriétaire , montant à payer, Argent restant au joueur aprés avoir payer
            this.getMonopoly().getIHM().afficheCalculLoyer(Ar, montant,jp.getNomJoueur());

            return montant ;
        }
         
        
         
    



        @Override
          public  void acheterPropriete(Joueur j ) {
            if (this.getProprietaire()==null){
            if (!j.peutPayer(this.getPrix())) {
                
                this.getMonopoly().getIHM().affichePeutPasPayer(); 
                
            }
            
            else {   
                
                if (1 ==this.getMonopoly().getIHM().getAchatRep()) {
                
                    this.getNomCarreau() ; 

                    j.payerLoyer(this.getPrix());
                   
                    this.setProprietaire(j);
                    j.getCompagnies().add(this); 
                    System.out.println("Vous venez d'acheter la propriete : "+this.getNomCarreau());

                }
                
                else {
                    
                    this.getMonopoly().getIHM().affichePasAcheter();
                       
                } 
            }
        } else this.getMonopoly().getIHM().affichePeutPasAcheter();;
        }
    }