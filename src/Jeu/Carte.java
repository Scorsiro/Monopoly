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
public abstract class Carte {
    
    private String nom ; 
    private String type ; 

    public Monopoly getMonopoly() {
        return monopoly;
    }
    private Monopoly monopoly ; 

    public Carte(String nom, String type, Monopoly mono) {
        this.nom = nom;
        this.type = type;
        this.monopoly = mono;
    }
    
    
    
    

    /**
     * @return the nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param nom the nom to set
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }
    
    public abstract void executerCarte (Joueur j) ; 

    
}
