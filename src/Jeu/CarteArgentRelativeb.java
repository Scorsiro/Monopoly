/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;

/**
 *
 * @author prudhomj
 */
public class CarteArgentRelativeb extends CarteArgent {

    public CarteArgentRelativeb(String nom, String type, int montant, Monopoly mono) {
        super(nom, type, montant, mono);
    }
    
  
    
    // Dans le cas où la carte tirée est une carte Argent qui demande de faire des réparation sur toutes les maisons 
    //25e pour chaque maison et 100e pour chaque hotel 
    
    
    public int calculMontantRepa(Joueur j ) {
    
        int montant = 0 ;  
        for (ProprieteAConstruire p : j.getProprietes()) {
       
            montant =  25 * p.getNbmaison() + montant ; 
          
            if(p.getHotel()){
            
                montant = montant + 100 ; 
          }
       
        }
       return montant ; 
    }
    
    // Dans le cas ou je joueur j tire une carte "C'est votre anniversaire 
    // tous les joueur doivent donné 10e au joueur j 
    
    public int calculMontantAnniv (Joueur j ) {
        //int montant = 0 ; 
        
        /*for(Joueur joueur : this.getMonopoly().getJoueurs()) {
            if(joueur != j){
            montant = montant + 10 ; 
            }
            
        }*/
        
        
        
        return (j.getMono().getJoueurs().size()-1) * 10 ; 
   }

    
    @Override
    public void executerCarte (Joueur j) {
            
      
        // 0 correspond aux cartes répartions
        
        if(this.getMontant() == 0 ){
            
            int montant = this.calculMontantRepa(j);
            
            if(j.peutPayer(montant)){
                int aR = j.calculArgentRest(montant);
                j.setCash(aR);
                
            } else {
                j.getMono().mettreEnFaillite(j);
            }
            
            // 1 correspond a la carte anniversaire
        } else if (this.getMontant() == 1) {
             
            int montant = this.calculMontantAnniv(j);
            j.recevoirLoyer(montant);
            
            for(int i = 1;i < this.getMonopoly().getJoueurs().size(); i++){//exception levée null pointer exception (à cause du joueur 0 ?)
                this.getMonopoly().getJoueurs().get(i).payerLoyer(10);
            }
        }
    
 
    }

}
