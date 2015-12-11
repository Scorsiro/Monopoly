package Jeu;

import Jeu.Groupe;
import java.util.ArrayList;

public class ProprieteAConstruire extends CarreauPropriete {
    
	private int _nbMaisons = 0;
	private int _nbHotels = 0;
	//private java.util.ArrayList<int> loyerMaison;
	private int _nbmaison = 0;
	private boolean _hotel = false;
	private ArrayList<Integer> _prixLoyers = new ArrayList<>();
	private Groupe _groupePropriete;

        public ProprieteAConstruire(int numero, String nomCarreau, int prix, String col,ArrayList<Integer> Loyers, int prixMaiHot) {
                super(numero, nomCarreau, prix);
                setGroupe(new Groupe(col,this,prixMaiHot));
                setPrixLoyers(Loyers);
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

	public ArrayList<Integer> getPrixLoyers() {
		return this._prixLoyers;
	}

	public void setPrixLoyers(ArrayList<Integer> prixloyer) {
		this._prixLoyers = prixloyer;
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