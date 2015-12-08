package Jeu;

public class Joueur {
	private String nomJoueur;
	private int cash = 1500;
	private int nbDoubles = 0;
        private int dés = 0;
	private boolean prison = false;
	private int nbTourPrison = 0;
        private int nbGare;
        private int nbCompagnie;
        private int nbPropriete;
        private Carreau c;
        private CouleurPropriete nbProprieteGroupe;
        

        public Joueur(String nomJoueur) {
                this.nomJoueur = nomJoueur;
                this.cash = cash;
        }
        
        //retourne le nom du joueur
        public String getNomjoueur() {
                return nomJoueur;
        }

        public void setNomJoueur(String nomJoueur) {
                this.nomJoueur = nomJoueur;
        }
        
        //retourne l'argent du joueur
        public int getArgent() {
		return cash;
	}

        public void setCash(int cash) {
                this.cash = cash;
        }
        
        public int getNbDoubles() {
		return this.nbDoubles;
	}

	public void setNbDoubles(int nbDoubles) {
		this.nbDoubles = nbDoubles;
	}
        
        //retourne le résultat des dés
        public int getDés() {
		return this.dés;
	}

	//retourne le carreau sur lequel est le joueur
	public Carreau getPositionCourante() {
		return this.c;
	}
        
        public void setPositionCourante(Carreau c) {
		this.c = c ;
	}

        //retourne vrai si le joueur est en prison
	public boolean getPrison() {
		return this.prison;
	}

	public void setPrison(boolean prison) {
		this.prison = prison;
	}
        
        //retourne le nombre de tour que passe le joueur en prison
	public int getNbTourPrison() {
		return this.nbTourPrison;
	}

	public void setNbTourPrison(int nbTourPrison) {
		this.nbTourPrison = nbTourPrison;
	}
        
        //retourne le nombre de compagnie que possède le joueur
	public int getNbCompagnie() {
		return nbCompagnie;
	}

        public void setNbCompagnie(int nbCompagnie) {
            this.nbCompagnie = nbCompagnie;
        }
        
        //retourne le nombre de gare que possède le joueur
        public int getNbGare() {
		return nbGare;
	}

        public void setNbGare(int nbGare) {
                this.nbGare = nbGare;
        }
        
        //retourne le nombre de propiété que possède le joueur
        public int getNbPropriete() {
		return nbPropriete;
	}

        public void setNbPropriete(int nbPropriete) {
                this.nbPropriete = nbPropriete;
        }

        //retourne le nombre de couleur de propriété que possède le joueur
        public CouleurPropriete getNbProprieteGroupe() {
                return nbProprieteGroupe;
        }

        public void setNbProprieteGroupe(CouleurPropriete nbProprieteGroupe) {
                this.nbProprieteGroupe = nbProprieteGroupe; 
        }
        
        //le joueur paye son loyer
        public void payerLoyer(int l) {
		
	} 
        
        //le joueur recoit son loyer
	public void recevoirLoyer(int l) {
		
	}
        
}