public class ProprieteAConstruire extends CarreauPropriete {
	private int _nbMaisons = 0;
	private int _nbHotels = 0;
	private java.util.ArrayList<int> _loyerMaison;
	private int _nbmaison = 0;
	private boolean _hotel = false;
	private int[] _prixloyer;
	private Groupe _groupePropriete;

	public Groupe getGroupeProprieté() {
		throw new UnsupportedOperationException();
	}

	public void action(Joueur j) {
		throw new UnsupportedOperationException();
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
		throw new UnsupportedOperationException();
	}

	private int calculeLoyer() {
		throw new UnsupportedOperationException();
	}

	private int calculArgentRes(Object a) {
		throw new UnsupportedOperationException();
	}

	private void acheterPropriete() {
		throw new UnsupportedOperationException();
	}

	public int calculLoyerPropriete(int nbPropriete) {
		throw new UnsupportedOperationException();
	}
}