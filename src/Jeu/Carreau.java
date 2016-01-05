package Jeu;

public abstract class Carreau {
	private int numero;
	private String nomCarreau;
        
	private Monopoly monopoly;

        public Carreau(int numero, String nomCarreau) {
            this.numero = numero;
            this.nomCarreau = nomCarreau;
        }

        public int getNumero() {
            return numero;
        }

        public void setNumero(int numero) {
            this.numero = numero;
        }

        public String getNomCarreau() {
            return nomCarreau;
        }

        public void setNomCarreau(String nomCarreau) {
            this.nomCarreau = nomCarreau;
        }
        
        public void construire (){
        
        }
        
        public abstract void action(Joueur j ) ; 
     

        /**
         * @return the monopoly
         */
        public Monopoly getMonopoly() {
            return monopoly;
        }

}