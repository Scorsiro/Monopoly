package Jeu;

public class CarreauMouvement extends CarreauAction {

    public CarreauMouvement(int numero, String nomCarreau, Monopoly mono) {
        super(numero, nomCarreau, mono);
    }

    

    @Override
    public void action(Joueur j) {
        
        this.getMonopoly().mettreEnPrison(j); 
        this.getMonopoly().getIHM().affichePrison();
    }
}