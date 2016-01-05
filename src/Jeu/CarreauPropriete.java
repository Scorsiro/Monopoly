package Jeu;

public abstract class CarreauPropriete extends Carreau {
    
	private int loyerBase;
        private Joueur j;
        private int prix;

        public CarreauPropriete(int numero, String nomCarreau, int prix) {
                super(numero, nomCarreau);
                this.prix = prix;
        }


	

        public Joueur getProprietaire(){
                return j;
        }
        
	public void setProprietaire(Joueur j) {
                this.j = j;
	}

	public int getPrix() {
                return prix;
	}

        public void setPrix(int prix) {
                this.prix = prix;
        }
        
	public void acheterPropriete() {
	}

	/*public int calculMontant () {}
        /*public int calculeLoyer(Joueur j ) {
	}*/
}