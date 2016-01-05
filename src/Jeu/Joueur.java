package Jeu;

import java.util.ArrayList;
import java.util.HashSet;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	private int nbDoubles = 0;
        private int des = 0;
	private boolean prison = false;
	private int nbTourPrison = 0;
        private Carreau positionCourante;
        private CouleurPropriete couleur;
        private HashSet<Gare> gares;
        private HashSet <Compagnie> compagnies;
        private HashSet <ProprieteAConstruire> proprietes ; 
        private HashSet <CarteLibere> cartes ; 
        private ArrayList <Groupe> groupes ; 
        private Monopoly mono;

    /**
     * @return the nomJoueur
     */
    public Joueur(String nomJoueur,Monopoly mono) {
        this.nomJoueur = nomJoueur;
        this.mono=mono;
        this.setPositionCourante(mono.calculPositionNum(1));
    }

        
    
    public String getNomJoueur() {
        return nomJoueur;
    }

    /**
     * @param nomJoueur the nomJoueur to set
     */
    public void setNomJoueur(String nomJoueur) {
        this.nomJoueur = nomJoueur;
    }

    /**
     * @return the cash
     */
    public int getCash() {
        return cash;
    }

    /**
     * @param cash the cash to set
     */
    public void setCash(int cash) {
        this.cash = cash;
        
    }
    
    //Ajouter le bonus de 200e à chaque fois que le joueur finit le tour 
    public void nouveauTourCash (){
        
        this.setCash(this.getCash()+200) ; 
    
    }

    /**
     * @return the nbDoubles
     */
    public int getNbDoubles() {
        return nbDoubles;
    }

    /**
     * @param nbDoubles the nbDoubles to set
     */
    public void setNbDoubles(int nbDoubles) {
        this.nbDoubles = nbDoubles;
    }

    /**
     * @return the des
     */
    public int getDes() {
        return des;
    }

    /**
     * @param des the des to set
     */
    public void setDes(int des) {
        this.des = des;
    }

    /**
     * @return the prison
     */
    public boolean isPrison() {
        return prison;
    }

    /**
     * @param prison the prison to set
     */
    public void setPrison(boolean prison) {
        this.prison = prison;
    }

    /**
     * @return the nbTourPrison
     */
    public int getNbTourPrison() {
        return nbTourPrison;
    }

    /**
     * @param nbTourPrison the nbTourPrison to set
     */
    public void setNbTourPrison(int nbTourPrison) {
        this.nbTourPrison = nbTourPrison;
    }

    /**
     * @return the positionCourante
     */
    public Carreau getPositionCourante() {
        return positionCourante;
    }

    /**
     * @param positionCourante the positionCourante to set
     */
    public void setPositionCourante(Carreau positionCourante) {
        this.positionCourante = positionCourante;
    }

    /**
     * @return the nbProprieteGroupe
     */
    public CouleurPropriete getCouleur() {
        return couleur;
    }

    /**
     * @param nbProprieteGroupe the nbProprieteGroupe to set
     */
    public void setCouleur(CouleurPropriete couleur) {
        this.couleur = couleur;
    }

    /**
     * @return the gares
     */
    public HashSet<Gare> getGares() {
        return gares;
    }

    /**
     * @param gares the gares to set
     */
    public void setGares(HashSet<Gare> gares) {
        this.gares = gares;
    }

    /**
     * @return the compagnies
     */
    public HashSet <Compagnie> getCompagnies() {
        return compagnies;
    }

    /**
     * @param compagnies the compagnies to set
     */
    public void setCompagnies(HashSet <Compagnie> compagnies) {
        this.compagnies = compagnies;
    }

    /**
     * @return the proprietes
     */
    public HashSet <ProprieteAConstruire> getProprietes() {
        return proprietes;
    }

    /**
     * @param proprietes the proprietes to set
     */
    public void setProprietes(HashSet <ProprieteAConstruire> proprietes) {
        this.proprietes = proprietes;
    }

    /**
     * @return the cartes
     */
    public HashSet <CarteLibere> getCartes() {
        return cartes;
    }

    /**
     * @param cartes the cartes to set
     */
    public void setCartes(HashSet <CarteLibere> cartes) {
        this.cartes = cartes;
    }

    /**
     * @return the groupes
     */
    public ArrayList <Groupe> getGroupes() {
        return groupes;
    }

    /**
     * @param groupes the groupes to set
     */
    public void setGroupes(ArrayList <Groupe> groupes) {
        this.groupes = groupes;
    }
    
    
    public void payerLoyer (int l )  {
        
        this.setCash(this.getCash() - l );
    
    }
    
    public void recevoirLoyer (int l ) {
        this.setCash( this.getCash() + l );
    } 
     
    /*public void addGroupe (Groupe groupe) {
        
        for (ProprieteAConstruire p : groupe.getProprietes() ) {
        
            if (p.getProprietaire() == this) {
            
                this.getGroupes().add(groupe) ; 
                groupe.setProprietaire(this);
            }
            
        }
     }*/
    
    
    public void addGroupe (Groupe groupe) {
    
        boolean gotAll = true ; 
        for (int i = 0 ; i  <= groupe.getProprietes().size() ; i++) {
            
            if(groupe.getProprietes().get(i).getProprietaire() != this) {
            
                gotAll = false ;
            }
    
        }
        if (!gotAll) {
        
            this.getGroupes().add(groupe) ; 
            groupe.setProprietaire(this);
        }
    
    
    
    
    }
    
    public boolean possedeCarteLiberation () {
    
        return ( !this.getCartes().isEmpty()) ; 
    }
    
    
    public boolean peutPayer (int montant) {
    
        return (this.getCash()> montant ) ; 
    }
    
    
  
    
   public int calculArgentRest (int loyer) {
       
       return ( this.getCash() - loyer ) ; 

   }
    
    
    public void addCarte(CarteLibere c) {
        
        this.getCartes().add(c) ;
    
    }
    
    public void removeCarte (CarteLibere c ) {
    
        this.getCartes().remove(c) ; 
    }
    
   
}