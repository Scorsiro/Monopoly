package Jeu;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	private int nbDoubles = 0;
	private boolean prison = false;
	private int nbTourPrison = 0;
	private int dés = 0;
        private Carreau c;
        

        public Joueur(String nomJoueur) {
            this.nomJoueur = nomJoueur;
        }

        public String getNomjoueur() {
            return nomJoueur;
        }

        public void setNomJoueur(String nomJoueur) {
            this.nomJoueur = nomJoueur;
        }
        
        public int getArgent() {
		return cash;
	}

        public void setCash(int cash) {
            this.cash = cash;
        }
        

	public void payerLoyer(int l) {
		
	}

	public void recevoirLoyer(int l) {
		
	}

	public int getNbDoubles() {
		return this.nbDoubles;
	}

	public void setNbDoubles(int nbDoubles) {
		this.nbDoubles = nbDoubles;
	}


	public int getDés() {
		return this.dés;
	}


	public Carreau getPositionCourante() {
		
	}
        
        public void setPositionCourante(Carreau c) {
		this.c = c ;
	}

	public boolean getPrison() {
		return this.prison;
	}

	public void setPrison(boolean prison) {
		this.prison = prison;
	}

	public int getNbTourPrison() {
		return this.nbTourPrison;
	}

	public void setNbTourPrison(int nbTourPrison) {
		this.nbTourPrison = nbTourPrison;
	}

	

	public int getNbCompagnie() {
		
	}
        
        public int getNbPropriete() {
		
	}
        
        public int getNbGare() {
		
	}
        
}