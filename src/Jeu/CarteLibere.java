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
public class CarteLibere extends Carte {
    
    
    
    public CarteLibere(String nom, String type) {
        super(nom, type);
    }
    
    
    public void executerCarte (Joueur j) {
    
            boolean fin = false;
            
            j.possedeCarteLiberation();
            j.addCarte(this);
            
            while(fin != true){
                if(j.isPrison()){
                    if(j.getMono().getIHM().getLibRep() == "oui") {
                        j.setPrison(false);
                    } else {
                        fin = true;
                    }
                } else {
                    fin = true;
                }
            }
    
    }
    
}


