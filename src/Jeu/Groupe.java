package Jeu;

import java.util.ArrayList;
import java.util.HashSet;

public class Groupe {
	private CouleurPropriete _couleur;
	private int _prixAchatMaiHot;
	public ArrayList<ProprieteAConstruire> _proprietes = new ArrayList<ProprieteAConstruire>();
        private Joueur proprietaire = null; 

        Groupe(CouleurPropriete colGroupe, int prixMaiHot){
            setCouleur(colGroupe); 
            this.setPrixAchatMaiHot(prixMaiHot);
            
        } 

       /* private void setCouleurPropriete(String col){
            CouleurPropriete colour = null;
            if(col == "bleuFonce"){
                 colour=CouleurPropriete.bleuFonce;
            }else if(col =="orange"){
                colour=CouleurPropriete.orange;    
            }else if(col == "mauve"){
                colour=CouleurPropriete.mauve;   
            }else if(col == "violet"){
                colour=CouleurPropriete.violet;   
            }else if(col == "bleuCiel"){
                colour=CouleurPropriete.bleuCiel;  
            }else if(col == "jaune"){
                colour=CouleurPropriete.jaune;   
            }else if(col == "vert"){
                colour=CouleurPropriete.vert;  
            }else if(col == "rouge"){
                colour=CouleurPropriete.rouge;   
            }
            setCouleur(colour);
        }*/

	/*public HashSet<ProprieteAConstruire> getProprietes() {
		
	}*/

    /**
     * @return the _prixAchatMaison
     */
    public int getPrixAchatMaiHot() {
        return _prixAchatMaiHot;
    }

    /**
     * @param _prixAchatMaison the _prixAchatMaison to set
     */
    public void setPrixAchatMaiHot(int prixAchat) {
        this._prixAchatMaiHot = prixAchat;
    }

    /**
     * @return the _proprietes
     */
    public ArrayList<ProprieteAConstruire> getProprietes() {
        return _proprietes;
    }

    /**
     * @param _proprietes the _proprietes to set
     */
    public void setProprietes(ArrayList<ProprieteAConstruire> _proprietes) {
        this._proprietes = _proprietes;
    }

    /**
     * @return the _prixAchatHotel
     */
 

    /**
     * @return the _couleur
     */
    public CouleurPropriete getCouleur() {
        return _couleur;
    }

    /**
     * @param _couleur the _couleur to set
     */
    public void setCouleur(CouleurPropriete _couleur) {
        this._couleur = _couleur;
    }

    /**
     * @return the proprietaire
     */
    public Joueur getProprietaire() {
        return proprietaire;
    }

    /**
     * @param proprietaire the proprietaire to set
     */
    public void setProprietaire(Joueur proprietaire) {
        this.proprietaire = proprietaire;
    }
    
  
    public int getMinNbM () {
    
        int min = 4 ; 
        
        for(ProprieteAConstruire p : this.getProprietes()) {
    
            if(p.getNbmaison() < min ) {
            
            min = p.getNbmaison() ; 
            
            }
        }
        return min ; 
    
    
    }
}