package Jeu;

public class CarreauMouvement extends CarreauAction {

    public CarreauMouvement(int numero, String nomCarreau) {
        super(numero, nomCarreau);
    }

    @Override
    public void action(Joueur j) {
        
        this.getMonopoly().mettreEnPrison(j); 
        this.getMonopoly().getIHM().affichePrison();
    }
}