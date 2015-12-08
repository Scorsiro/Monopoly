package Jeu;

import java.util.ArrayList;
import java.util.HashSet;

public class Groupe {
	private CouleurPropriete _couleur;
	private int _prixAchatMaison;
	private int _prixAchatHotel;
	private ArrayList<ProprieteAConstruire> _proprietes = new ArrayList<ProprieteAConstruire>();

        Groupe(String colGroupe, ProprieteAConstruire prop, int prixMaiHot){
            setCouleurPropriete(colGroupe);
            _proprietes.add(prop);
            this.setPrixAchatHotel(prixMaiHot);
            this.setPrixAchatMaison(prixMaiHot);
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
    public int getPrixAchatMaison() {
        return _prixAchatMaison;
    }

    /**
     * @param _prixAchatMaison the _prixAchatMaison to set
     */
    public void setPrixAchatMaison(int _prixAchatMaison) {
        this._prixAchatMaison = _prixAchatMaison;
    }

    /**
     * @return the _prixAchatHotel
     */
    public int getPrixAchatHotel() {
        return _prixAchatHotel;
    }

    /**
     * @param _prixAchatHotel the _prixAchatHotel to set
     */
    public void setPrixAchatHotel(int _prixAchatHotel) {
        this._prixAchatHotel = _prixAchatHotel;
    }
}