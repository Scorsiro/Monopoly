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
public class CarteMouvementFixe extends CarteMouvement  {

    public CarteMouvementFixe(String nom, String type, int deplacement, int numCase, Monopoly mono) {
        super(nom, type, deplacement, numCase, mono);
    }
    
   

    @Override
    public void executerCarte(Joueur j ) {
          Carreau c;
        
        if(this.getDeplacement() != 0){
            int deplace = j.getPositionCourante().getNumero() + this.getDeplacement();
            c = j.getMono().calculPositionNum(deplace);
            j.setPositionCourante(c);
            
        } else if (this.getDeplacement() == 0 && this.getNumCase() != 11){
            c = j.getMono().calculPositionNum(this.getNumCase());
            j.setPositionCourante(c);
            
                if(passageDepart(j)){
                    j.nouveauTourCash();
                }
        }
    }
}
