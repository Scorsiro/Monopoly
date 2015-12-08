package Jeu;

import Jeu.Groupe;

public class ProprieteAConstruire extends CarreauPropriete {
    
	private int _nbMaisons = 0;
	private int _nbHotels = 0;
	//private java.util.ArrayList<int> loyerMaison;
	private int _nbmaison = 0;
	private boolean _hotel = false;
	private int[] _prixloyer;
	private Groupe _groupePropriete;

        public ProprieteAConstruire(int numero, String nomCarreau, int prix, String col, int prixMaiHot) {
                super(numero, nomCarreau, prix);
                setGroupe(new Groupe(col,this,prixMaiHot));
        }

	/*public Groupe getGroupeProprieté() {
	}*/

	public void action(Joueur j) {
	}

	public int getNbmaison() {
		return this._nbmaison;
	}

	public void setNbmaison(int nbmaison) {
		this._nbmaison = nbmaison;
	}

	public boolean getHotel() {
		return this._hotel;
	}

	public void setHotel(boolean hotel) {
		this._hotel = hotel;
	}

	public int[] getPrixloyer() {
		return this._prixloyer;
	}

	public void setPrixloyer(int[] prixloyer) {
		this._prixloyer = prixloyer;
	}

	public void construire() {
	}

	/*private int calculeLoyer() {
	}


	public int calculLoyerPropriete(int nbPropriete) {
	}*/

    /**
     * @return the _groupePropriete
     */
    public Groupe getGroupe() {
        return _groupePropriete;
    }

    /**
     * @param _groupePropriete the _groupePropriete to set
     */
    public void setGroupe(Groupe _groupePropriete) {
        this._groupePropriete = _groupePropriete;
    }
}