package Jeu;

import Jeu.Groupe;
import java.util.ArrayList;

public class ProprieteAConstruire extends CarreauPropriete {
    
	//private int _nbMaisons = 0;
	//private int _nbHotels = 0;
	//private java.util.ArrayList<int> loyerMaison;
	private int _nbmaison = 0;
	private boolean _hotel = false;
	private ArrayList<Integer> _prixLoyers;
	private Groupe _groupePropriete;

        public ProprieteAConstruire(int numero, String nomCarreau, int prix, Groupe g,ArrayList<Integer> loyers, Monopoly mono) {
                super(numero, nomCarreau, prix, mono);
                
                this._prixLoyers = new ArrayList<>();
                
                setGroupepropriete(g);
                
                setPrixLoyers(loyers);
        }

	/*public Groupe getGroupeProprieté() {
	}*/

	

	public int getNbmaison() {
		return this._nbmaison;
	}

	public void setNbmaison(int nbmaison) {
		this._nbmaison = nbmaison;
	}

	public boolean getHotel() {
		return this._hotel;
	}

	public void setHotel(boolean hotel) {
		this._hotel = hotel;
	}

	public ArrayList<Integer> getPrixLoyers() {
		return this._prixLoyers;
	}

	public void setPrixLoyers(ArrayList<Integer> prixloyer) {
		this._prixLoyers = prixloyer;
	}




        /**
         * @return the _groupePropriete
         */
        public Groupe getGroupePropriete() {
            return _groupePropriete;
        }

        /**
         * @param _groupePropriete the _groupePropriete to set
         */
        public void setGroupepropriete(Groupe _groupePropriete) {
            this._groupePropriete = _groupePropriete;
            this._groupePropriete.getProprietes().add(this);
        }



        @Override
        public int calculMontant(Joueur j) {

          // return le prix à payer : les prix sont stockés dans une arraylist ( le prix dépend du nombre de maison sur la propriété)
          // Si y a un hotel sur la propriété on retourne le prix dans la position 5 dans l'arrayList 
            int montant = 0 ; 
            
            if(this.getHotel()){
            
                montant = this.getPrixLoyers().get(5) ; 
            
            }
            else {
            
                montant = this.getPrixLoyers().get(this.getNbmaison()) ; 
            }
            
          return montant ; 

        }

        @Override
        public int calculLoyer(Joueur j) {
            Joueur jp = this.getProprietaire() ; 
            //int nbM = this.getNbmaison() ; 
            int montant = this.calculMontant(j) ; 

            int Ar = j.calculArgentRest(montant) ; 

            this.getMonopoly().getIHM().afficheCalculLoyer(Ar, montant, jp.getNomJoueur());

        return montant ; }
        
        
        @Override
        public  void acheterPropriete(Joueur j ) {
        if (this.getProprietaire()==null){
            if (!j.peutPayer(this.getPrix())) {
                
                this.getMonopoly().getIHM().affichePeutPasPayer(); 
                
            }
            
            else {   
                int rep = this.getMonopoly().getIHM().getAchatRep();
                if (rep == 1) {
                
                    this.getNomCarreau() ; 

                    j.payerLoyer(this.getPrix());
                   
                    this.setProprietaire(j);
                    j.getProprietes().add(this); 
                    this.getProprietaire().addGroupe(this.getGroupePropriete());
                    System.out.println("Vous venez d'acheter la propriete : "+this.getNomCarreau());
                    this.getMonopoly().getIHM().afficheCarteProprieteAC(this);
                    

                }
                
                else {
                    
                    this.getMonopoly().getIHM().affichePasAcheter();
                       
                }
                
                
            }
        } else this.getMonopoly().getIHM().affichePeutPasAcheter();
        }
    }