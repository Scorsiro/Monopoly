package Jeu;

import java.util.ArrayList;

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
        
        public void construire (Joueur j ){
            
            ArrayList <Groupe> groupes = j.getGroupes() ; 
            
            if (!groupes.isEmpty()) {
            
                for(Groupe g : groupes) {
                    
                    int min = g.getMinNbM();
                    ArrayList<ProprieteAConstruire> collectP = g.getProprietes()  ; 
                    
                    for(ProprieteAConstruire p : collectP){
                    
                        int nbM = p.getNbmaison(); 
                        
                        if (nbM<5 && nbM == min) {
                        
                        this.getMonopoly().getIHM().afficheConstruire();
                        this.getMonopoly().getIHM().afficheP(p);
                        
                        }
                        else {
                        this.getMonopoly().getIHM().affichePeutPasConstruire();
                        }
                    
                    }
                  
                 
                
                
                }
            
            
            }
            
            
            
        
        }
        
        public abstract void action(Joueur j ) ; 
     

        /**
         * @return the monopoly
         */
        public Monopoly getMonopoly() {
            return monopoly;
        }

}