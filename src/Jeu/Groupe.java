package Jeu;

import java.util.ArrayList;
import java.util.HashSet;

public class Groupe {
	private CouleurPropriete _couleur;
	private int _prixAchat;
	private ArrayList<ProprieteAConstruire> _proprietes;

        Groupe(String colGroupe, int prixMaiHot){
            setCouleurPropriete(colGroupe);
            this._proprietes = new ArrayList<ProprieteAConstruire>();
            this.setPrixAchat(prixMaiHot);
        }

        private void setCouleurPropriete(String col){
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
            _couleur = colour;
        }

	/*public HashSet<ProprieteAConstruire> getProprietes() {
		
	}*/

    /**
     * @return the _prixAchatMaison
     */
    public int getPrixAchat() {
        return _prixAchat;
    }

    /**
     * @param _prixAchatMaison the _prixAchatMaison to set
     */
    public void setPrixAchat(int prixAchat) {
        this._prixAchat = prixAchat;
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
}