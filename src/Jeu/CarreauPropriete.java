package Jeu;

public abstract class CarreauPropriete extends Carreau {
    
	private int loyerBase;
        private Joueur j;
        private int prix;

        public CarreauPropriete(int numero, String nomCarreau, int prix) {
                super(numero, nomCarreau);
                this.prix = prix;
        }


	public void acheterPropriete() {
	}

	public int calculArgentRes(int a) {
	}

	public int calculeLoyer() {
	}

        public Joueur getPropriétaire(){
                return j;
        }
        
	public void setPropriétaire(Joueur j) {
                this.j = j;
	}

	public int getPrix() {
                return prix;
	}

        public void setPrix(int prix) {
                this.prix = prix;
        }
        
}