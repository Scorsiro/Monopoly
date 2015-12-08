package Jeu;

import java.util.ArrayList;
import java.util.HashSet;

public class Groupe {
	private CouleurPropriete couleur;
	private int prixAchatMaison;
	private int prixAchatHotel;
	private ArrayList<ProprieteAConstruire> proprietes = new ArrayList<ProprieteAConstruire>();

	public HashSet<ProprieteAConstruire> getProprietes() {
		throw new UnsupportedOperationException();
	}
}