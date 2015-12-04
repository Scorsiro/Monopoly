public class Joueur {
	private String _nomJoueur;
	private int _cash = 1500;
	private int _nbDoubles = 0;
	private boolean _prison = false;
	private int _nbTourPrison = 0;
	private int _dés = 0;

	public void payerLoyer(int l) {
		throw new UnsupportedOperationException();
	}

	public void recevoirLoyer(int l) {
		throw new UnsupportedOperationException();
	}

	public int getNbDoubles() {
		return this._nbDoubles;
	}

	public void setNbDoubles(int nbDoubles) {
		this._nbDoubles = nbDoubles;
	}

	public int getNbGare() {
		throw new UnsupportedOperationException();
	}

	public int getDés() {
		return this._dés;
	}

	public int getArgent() {
		throw new UnsupportedOperationException();
	}

	public String getNP() {
		throw new UnsupportedOperationException();
	}

	public void setCash(Object cash, Object prix) {
		throw new UnsupportedOperationException();
	}

	public Carreau getPositionCourante() {
		throw new UnsupportedOperationException();
	}

	public boolean getPrison() {
		return this._prison;
	}

	public void setPrison(boolean prison) {
		this._prison = prison;
	}

	public int getNbTourPrison() {
		return this._nbTourPrison;
	}

	public void setNbTourPrison(int nbTourPrison) {
		this._nbTourPrison = nbTourPrison;
	}

	public void setPositionCourante(Carreau c) {
		throw new UnsupportedOperationException();
	}

	public int getNbCompagnie() {
		throw new UnsupportedOperationException();
	}
}