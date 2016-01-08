package Jeu;

import java.util.ArrayList;
import java.util.HashSet;

public abstract class Carreau {
	private int numero;
	private String nomCarreau;
        
	private Monopoly monopoly;

        public Carreau(int numero, String nomCarreau,Monopoly mono) {
            this.numero = numero;
            this.nomCarreau = nomCarreau;
            monopoly = mono;
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
            
                boolean peutConstruire = false;
                
                for(Groupe g : groupes) {
                    
                    int min = g.getMinNbM() ; // le minimum des maisons sur les propriétés appartenant au groupe 
                    
                    ArrayList<ProprieteAConstruire> collectP = g.getProprietes()  ; // toutes les propriétes du groupe  
                    
                    
                    //Pour chaque propriété on vérifie qu'elle a un nombre min de maison par rapport aux autres et que ça doit pas dépasser 4
                    
                    for(ProprieteAConstruire p : collectP){ 
                    
                        int nbM = p.getNbmaison(); 
                        
                        if (nbM<5 && nbM == min && !p.getHotel()) {
                        
                            //Affichage de toutes les propriétés où le jour a la possibilité de construire 
                            
                            this.getMonopoly().getIHM().afficheConstruire(p) ; 
                            peutConstruire=true;
                         
                        }
                        
                        //else {
                            
                         //   this.getMonopoly().getIHM().affichePeutPasConstruire();
                    }
                    
                    
                }
                
                
                if (peutConstruire) {
                  
                       //Choix du joueur
                       Boolean mauvaiseSaisie = true;
                       while (mauvaiseSaisie){
                       int numC = this.getMonopoly().getIHM().getConstruireRep() ; 
                       
                       //Return le carreau avec le numC pour incrémenter le nbmaison ... 
                       
                       
                       Carreau c = this.getMonopoly().getCarreaux().get(numC);
                       //ProprieteAConstruire p = this.getMonopoly().get
                       
                       HashSet<ProprieteAConstruire> collec = j.getProprietes();
                       /*Boolean trouve = false;
                       int i=0;
                       while (!trouve && i<collec.size()) {
                          
                       }
                       */
                       
                       //obligé de faire comme ça car pas de HashMap
                       for (ProprieteAConstruire p : collec){
                           if (p.getNumero()==numC) {
                               ProprieteAConstruire pc = p;
                               Groupe gc = p.getGroupePropriete();
                               if (pc.getProprietaire()==j && j.getGroupes().contains(gc) && gc.getMinNbM()==pc.getNbmaison() && !pc.getHotel() && pc.getNbmaison()<5){
                                   mauvaiseSaisie=false;
                                   int prix = gc.getPrixAchatMaiHot();
                                   if (j.peutPayer(prix)){
                                       j.payerLoyer(prix);
                                       if (pc.getNbmaison()<4){
                                           pc.setNbmaison(pc.getNbmaison()+1);
                                       }
                                       else {
                                           pc.setNbmaison(0);
                                           pc.setHotel(true);
                                       }
                                       this.getMonopoly().getIHM().afficheCarteProprieteAC(pc);
                                   }
                                   else {
                                       this.getMonopoly().getIHM().affichePeutPasPayer();
                                       mauvaiseSaisie=false;
                                   }
                               }
                               //else {System.out.println("Mauvaise saisie !"); }
                           }
                           //else {System.out.println("Mauvaise saisie !"); }
                       }
                
            
                if (mauvaiseSaisie){
                    System.out.println("Mauvaise saisie !"); 
                }
                }       
                
            
            
            
            }
            else this.getMonopoly().getIHM().affichePeutPasConstruire();
            
            } 
            else this.getMonopoly().getIHM().affichePeutPasConstruire();
        }
        
        
        public abstract void action(Joueur j ) ; 
     

        /**
         * @return the monopoly
         */
        public Monopoly getMonopoly() {
            return monopoly;
        }

}