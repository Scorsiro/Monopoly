/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Jeu;

/**
 *
 * @author adlit
 */
public class CarteArgentRelative extends CarteArgent {

   
    public CarteArgentRelative(int montant) {
        super(montant);
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
        int montant = 0 ; 
        
        for(Joueur joueur : this.getMonopoly().getJoueurs() && joueur  != j) {
            joueur.payerLoyer(10);
            montant = montant + 10 ; 
        
        }
       
        j.recevoirLoyer(montant);
        return montant ; 
   }
}
