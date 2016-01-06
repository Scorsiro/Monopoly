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

public class CarteMouvement extends Carte{
    
    private int deplacement;
    private int numCase;
    private boolean passageD = false;
    
    public CarteMouvement(String nom, String type, int deplacement, int numCase) {
        super(nom, type);
        this.deplacement = deplacement;
        this.numCase = numCase;
    }

    public int getDeplacement() {
        return deplacement;
    }

    public void setDeplacement(int deplacement) {
        this.deplacement = deplacement;
    }

    public int getNumCase() {
        return numCase;
    }

    public void setNumCase(int numCase) {
        this.numCase = numCase;
    }
    
    public void executerCarte (Joueur j) {
        
        Carreau c;
        
        if(this.getDeplacement() != 0){
            int deplace = j.getPositionCourante().getNumero() + this.getDeplacement();
            c = j.getMono().calculPositionNum(deplace);
            j.setPositionCourante(c);
            
        } else {
            c = j.getMono().calculPositionNum(this.getNumCase());
            j.setPositionCourante(c);
            
                if(passageDepart(j)){
                    j.nouveauTourCash();
                }
        }

    }
    
    public boolean passageDepart (Joueur j) {
        
        Carreau c = j.getPositionCourante() ;
        int num = c.getNumero();
                
        return (num > this.getNumCase());
        
    }


}
