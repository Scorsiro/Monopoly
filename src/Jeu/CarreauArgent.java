package Jeu;

public class CarreauArgent extends CarreauAction {
	private int _montant;

    public CarreauArgent(int numero, String nomCarreau, int montant, Monopoly mono) {
        super(numero, nomCarreau,mono);
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
        
        j.recevoirLoyer(this.getMontant());
    }
}