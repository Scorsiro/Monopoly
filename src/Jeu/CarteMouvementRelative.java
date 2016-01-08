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
public class CarteMouvementRelative extends CarteMouvement {

    public CarteMouvementRelative(String nom, String type, int deplacement, int numCase, Monopoly mono) {
        super(nom, type, deplacement, numCase, mono);
    }
    
    
    

    @Override
    public void executerCarte(Joueur j ) {
          Carreau c;
        
        if(this.getNumCase() == 11){
            j.getMono().mettreEnPrison(j);        
        }

    }
    
    
    
}
