package Jeu;

public class CarreauArgent extends CarreauAction {
	private int _montant;

    public CarreauArgent(int numero, String nomCarreau, int montant) {
        super(numero, nomCarreau);
        setMontant(montant);
    }

    /**
     * @return the _montant
     */
    public int getMontant() {
        return _montant;
    }

    /**
     * @param _montant the _montant to set
     */
    private void setMontant(int _montant) {
        this._montant = _montant;
    }

    @Override
    public void action(Joueur j) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}