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
public class CarteArgentFixe extends CarteArgent {

    public CarteArgentFixe(String nom, String type, int montant) {
        super(nom, type, montant);
    }

    
    
    
   public int calculMontant () {
   
       return this.getMontant() ; 
       
       
   }
   
   
   public void executerCarte (Joueur j) {
        
        int montant = this.calculMontant();
        j.getCash();
        if(j.peutPayer(montant)){
            int aR = j.calculArgentRest(montant);
            j.setCash(aR);
        } else {
            j.getMono().mettreEnFaillite(j);
        }
    }
    
    
}
