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
    
    
    
    public CarteLibere(String nom, String type, Monopoly mono) {
        super(nom, type, mono);
    }
    
    
  

    @Override
    public void executerCarte(Joueur j ) {
              boolean fin = false;
            
            
            //j.addCarte(this);

                if(j.isPrison()){
                    if(j.getMono().getIHM().getLibRep().equals("oui")) {
                        j.setPrison(false);
                        if(j.getCartes().size() == 1){
                            j.getCartes().remove(1);
                        } else {
                            j.getCartes().remove(2);    
                        }
                }
    
                }
    }
    
    /*public void addCarte(Joueur j) {
        j.addCarte(this);
    }*/
    
    
    
    
}


