package Jeu;

import Jeu.Groupe;

public class ProprieteAConstruire extends CarreauPropriete {
	private int nbMaisons = 0;
	private int nbHotels = 0;
	//private java.util.ArrayList<int> loyerMaison;
	private int nbmaison = 0;
	private boolean hotel = false;
	private int[] prixloyer;
	private Groupe groupePropriete;

	public Groupe getGroupeProprieté() {
		throw new UnsupportedOperationException();
	}

	public void action(Joueur j) {
		throw new UnsupportedOperationException();
	}

	public int getNbmaison() {
		return this.nbmaison;
	}

	public void setNbmaison(int nbmaison) {
		this.nbmaison = nbmaison;
	}

	public boolean getHotel() {
		return this.hotel;
	}

	public void setHotel(boolean hotel) {
		this.hotel = hotel;
	}

	public int[] getPrixloyer() {
		return this.prixloyer;
	}

	public void setPrixloyer(int[] prixloyer) {
		this.prixloyer = prixloyer;
	}

	public void construire() {
		throw new UnsupportedOperationException();
	}

	private int calculeLoyer() {
	}

	private int calculArgentRes(Object a) {
	}

        @Override
	private void acheterPropriete() {
	}

	public int calculLoyerPropriete(int nbPropriete) {
	}
}