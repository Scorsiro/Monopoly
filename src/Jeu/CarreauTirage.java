package Jeu;

public class CarreauTirage extends CarreauAction {

    public CarreauTirage(int numero, String nomCarreau, Monopoly mono) {
        super(numero, nomCarreau, mono);
    }

    @Override
    public void action(Joueur j) {
        
        this.getMonopoly().tirerUneCarte(j); ; 
    }
}