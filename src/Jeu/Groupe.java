import java.util.ArrayList;

public class Groupe {
	private CouleurPropriete _couleur;
	private int _prixAchatMaison;
	private int _prixAchatHotel;
	private ArrayList<ProprieteAConstruire> _proprietes = new ArrayList<ProprieteAConstruire>();

	public HashSet<ProprieteAConstruire> getProprietes() {
		throw new UnsupportedOperationException();
	}
}