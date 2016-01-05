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
            
            this.getMonopoly().getIHM().afficheP();
            
                for(Groupe g : groupes) {
                    
                    int min = g.getMinNbM() ; // le minimum des maisons sur les propriétés appartenant au groupe 
                    
                    ArrayList<ProprieteAConstruire> collectP = g.getProprietes()  ; // toutes les propriétes du groupe  
                    
                    
                    //Pour chaque propriété on vérifie qu'elle a un nombre min de maison par rapport aux autres et que ça doit pas dépasser 4
                    
                    for(ProprieteAConstruire p : collectP){ 
                    
                        int nbM = p.getNbmaison(); 
                        
                        if (nbM<5 && nbM == min) {
                        
                        //Affichage de toutes les propriétés où le jour a la possibilité de construire 
                            
                        this.getMonopoly().getIHM().afficheConstruire(p);
                        
                        
                        
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