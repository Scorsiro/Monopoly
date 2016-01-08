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

    public CarteArgentFixe(String nom, String type, int montant, Monopoly mono) {
        super(nom, type, montant, mono);
    }

    
    
    
    public int calculMontant () {
   
       return this.getMontant() ; 
       
       
   }
   
   
    
    @Override
    public void executerCarte (Joueur j) {
        
        int montant = this.calculMontant();
        
        if(j.peutPayer(montant)){
            int aR = j.getCash() + montant ; // le montant des cartes est soit positif soit négatif
            j.setCash(aR);
        } else {
            j.getMono().mettreEnFaillite(j);
        }
    }

    
}
