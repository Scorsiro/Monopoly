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
public abstract class CarteArgent extends Carte {
    
    
    private int montant ;

    public CarteArgent(String nom, String type,int montant, Monopoly mono) {
        super(nom,type,mono);
        this.montant = montant;
    }


    /**
     * @return the montant
     */
    public int getMontant() {
        return montant;
    }

    /**
     * @param montant the montant to set
     */
    public void setMontant(int montant) {
        this.montant = montant;
    }
}
