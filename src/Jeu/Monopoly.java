package Jeu;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class Monopoly {
	private final int _nbMaisons = 32;
	private final int _nbHotels = 12;
        private ArrayList<Joueur> _joueurs ; //  = new ArrayList <> () ;
        private HashMap<Integer, Carreau> _carreaux  ; //= new HashMap<>() ;
        ArrayList<Carte> _cartes = new ArrayList<>();
        private IHM _IHM;
        private HashMap<CouleurPropriete,Groupe> _groupes;
        
        /* Constructor */
        public Monopoly(String dataFilename){
	       _joueurs = new ArrayList <> () ;  
               _carreaux = new HashMap<>();
               _groupes = new HashMap<>();
               _IHM = new IHM();
            buildGamePlateau(dataFilename);
            this.lancementJeu();
	}
        
        private void lancementJeu(){
            int choix = 0;
            String nomPremJ;
            while(choix != 2){
                choix = this.getIHM().affichageMenu();
                if(choix == 1){
                    nomPremJ = this.InitialiserPartie();
                    this.lancementPartie(nomPremJ);
                }
                if(choix == 3){
                   
                   
                }
            }
        }
        
        private void lancementPartie(String nomPremJ){
            int prem;
            while(this.getJoueurs().size() != 2){
                /* Donne l'indice du premier joueur devant commencer à jouer. */
                prem = getIndPrem(nomPremJ);
                /* boucle commençant par le premier qui a été tiré au sort. */ 
                for(int i = prem; i < (this.getJoueurs().size()); i++ ){
                    Joueur jTemp = this.getJoueurs().get(i);
                    this.getIHM().affichagePlateau();
                    this.jouerUnCoup(jTemp);
                    
                    
                    /* Facultatif à mettre dans l'IHM
                    System.out.println(this.getJoueurs().get(i).getNomJoueur() + this.getJoueurs().get(i).getPositionCourante().getNumero());
                    System.out.println(this.getJoueurs().get(i).getNomJoueur() + this.getJoueurs().get(i).getCash()); */
                }
                System.out.println("\n");
                for(int i = 1; i < prem; i++){
                    Joueur jTemp = this.getJoueurs().get(i);
                    this.getIHM().affichagePlateau();
                    this.jouerUnCoup(jTemp);
                    
                    
                    
                    /* Facultatif à mettre dans l'IHM
                    System.out.println(this.getJoueurs().get(i).getNomJoueur() + this.getJoueurs().get(i).getPositionCourante().getNumero());
                    System.out.println(this.getJoueurs().get(i).getNomJoueur() + " a " + this.getJoueurs().get(i).getCash()); */
                }
                
            }
        }
        
        
        
	public void jouerUnCoup(Joueur j) {
		this.lancerDésAvancer(j );
                this.getIHM().affichagePlateau();
                j.getPositionCourante().action(j);
                while (j.getNbDoubles() != 0  ) {
                    this.lancerDésAvancer(j);
                
                }
        }
                private void lancerDésAvancer(Joueur j) {
            
            if(j.getNbDoubles() < 3) {
                int d1 = this.genererChiffreDés() ; 
                int d2 = this.genererChiffreDés() ;
                int inter = 0;
                j.setDes(d1+d2);
                
                if (d1 == d2 ) {
                    j.setNbDoubles(j.getNbDoubles() + d1 );
                }
                else {j.setNbDoubles(0);}
                
                Carreau c = j.getPositionCourante() ;
                int num = c.getNumero(); 
                
                /*Si la nouvelle position sort du plateau, on fait la différence, et on l'ajoute à la case départ + argent*/
                if((num + d1 + d2) > 40){
                    inter =  (num + d1 +d2) - 40;
                    j.nouveauTourCash();
                } else {
                    inter = num + d1+d2;
                } 
                Carreau nc = this.calculPositionNum(inter) ; 
                j.setPositionCourante(nc);   
                this.getIHM().afficheArriveeCase(d1, d2, c, nc, j);
                }
            else {
                this.mettreEnPrison(j); 
            }  
            
        } 
          
        
         /*public void jouerPlusieursCoups(){
            for(Joueur j : _joueurs){
                jouerUnCoup(j);
            }   
         }*/

	public int genererChiffreDés() {
		
            Random rand = new Random () ;
            int d1 = 0;
            while(d1 == 0){
            d1 = rand.nextInt(7) ;
            }
            return d1 ; 
	}

	public Carreau calculPositionNum(int num) {
       
              return this.getCarreaux().get(num) ; 

	}

	public void mettreEnPrison(Joueur j) {
           
            j.setPositionCourante(this.calculPositionNum(11));
            j.setPrison(true);
            j.setNbDoubles(0) ; 
	}
        
         /***************************** Init Partie *****************************/
       public String InitialiserPartie(){
                Scanner sca = new Scanner(System.in);
                Scanner scb = new Scanner(System.in);
                boolean fin = false;
                
                ArrayList<Integer> lanceDe = new ArrayList<>();
                ArrayList<String> exA = new ArrayList<>();
                String nomPrem = null;
                
                int alea = 0;
                int nbJoueurs=0;
                int jMax = 0;
                
                while(jMax < 2 || jMax > 6){
                    System.out.print("\nEntrez le nombre de joueur désirant jouer : ");
                    jMax = scb.nextInt();
                }
                
                /* Init du joueur 0 avec pour nom vide et rang 0 (#Bouche trou) */
                Joueur jVide = new Joueur("vide", this);
                _joueurs.add(0,jVide);
                
                while (nbJoueurs < jMax) {
                    nbJoueurs++;
                    System.out.println("Joueur " + nbJoueurs);
                    System.out.print("Saisissez votre nom : ");
                    String nom = sca.nextLine();
                    Joueur j = new Joueur(nom, this);
                    _joueurs.add(j);
                }
                
                    lanceDe.add(0,0);
                    for(int j = 1; j<=nbJoueurs; j++){
                        lanceDe.add(j, genererChiffreDés()); //génère les chiffres dans l'arraylist avec les joueurs
                        System.out.println("Joueur "+ j + " fait un " + lanceDe.get(j) + ".");
                    }
                    
                    int max = Collections.max(lanceDe); // 'max' est le chiffre max de l'arraylist
                    int freq = Collections.frequency(lanceDe, max);
                    
                    if(freq == 1){
                        int temp = lanceDe.indexOf(max);
                        if(temp==0){temp++;}
                        nomPrem = this.getJoueurs().get(temp).getNomJoueur();
                        fin = true;
                    }else if(freq > 1){
                        Random rand = new Random();
                        
                        exA.add(0,"vide");
                        int i =1;
                        
                        while(i <= jMax){
                            if(lanceDe.get(i) == max){
                                if(i==0){i++;}
                                exA.add(1,this.getJoueurs().get(i).getNomJoueur());
                            }
                            i++;
                        }
                        while((alea < 1) || (alea > freq)){
                            alea = rand.nextInt(freq+1) ;
                        }
                        nomPrem = exA.get(alea);
                        
                        fin = true;
                        
                    }
                System.out.println("\nLe joueurs qui commence est " + nomPrem +'.');
                /*try{TimeUnit.SECONDS.sleep(5);}
                catch(InterruptedException a){}*/
                return nomPrem; 
       }
                
                
        
        
        /***************************** Init Game Plateau *****************************/
        private void buildGamePlateau(String dataFilename)
	{           
		try{
                        ArrayList<Integer> loyers = new ArrayList<>();
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
                        
			/* Creation des différents carreaux */
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					//System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        // Ajouts des differents loyers dans l'ArrayList (Les valeurs des loyers sont dans les case 5 à 10 du fichier.)
                                        for(int j = 5; j<=10; j++){
                                            loyers.add(j-5,Integer.parseInt(data.get(i)[j]));
                                        }
                                        
                                        Groupe grTemp = new Groupe(data.get(i)[11],Integer.parseInt(data.get(i)[11]));
                                        
                                        /* Init du carreau               numCase                                     numCase                         nom                           prix         couleur   oyers */
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[4]),grTemp,loyers));
                                }
				else if(caseType.compareTo("G") == 0){
					//System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new Gare(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3])));       
				}
				else if(caseType.compareTo("C") == 0){
					//System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new Compagnie(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3])));  
				}
				else if(caseType.compareTo("CT") == 0){
					//System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new CarreauTirage(Integer.parseInt(data.get(i)[1]),data.get(i)[2]));
				}
				else if(caseType.compareTo("CA") == 0){
					//System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new CarreauArgent(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3])));
				}
				else if(caseType.compareTo("CM") == 0){
					//System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new CarreauMouvement(Integer.parseInt(data.get(i)[1]),data.get(i)[2]));
				}
                                //else{
					//System.err.println("[buildGamePleateau()] : Invalid Data type");}
			}
			
		} 
		catch(FileNotFoundException e){
			System.err.println("[buildGamePlateau()] : File is not found!");
		}
		catch(IOException e){
			System.err.println("[buildGamePlateau()] : Error while reading file!");
		}
	}
        
        private ArrayList<String[]> readDataFile(String filename, String token) throws FileNotFoundException, IOException
	{
		ArrayList<String[]> data = new ArrayList<String[]>();
		
		BufferedReader reader  = new BufferedReader(new FileReader(filename));
		String line = null;
		while((line = reader.readLine()) != null){
			data.add(line.split(token));
		}
		reader.close();
		
		return data;
	}

  
                
    public ArrayList<Carte> getCartes() {
                   
        return _cartes;
    }
    
    public Carte genererCarte() {
                  
        Random rand = new Random ();
        int c = rand.nextInt(_cartes.size());
        return _cartes.get(c);
    }
    
    /*public void melangerCarte(){
                    
        Collections.shuffle(this.getCartes());
    } */   
     
    public void mettreEnFaillite(Joueur j){
                   
        _joueurs.remove(j);
    }
    
    
    public void tirerUneCarte(){
      
      
        Carte c = this.genererCarte() ; 
        c.executerCarte();
        // remettre la carte au dérnier indice 
        this.getCartes().remove(c) ; 
        this.getCartes().add(c); 
      
      
    }
    
    /**
     * @return the _nbMaisons
     */
    public int getNbMaisons() {
        return _nbMaisons;
    }

    /**
     * @return the _nbHotels
     */
    public int getNbHotels() {
        return _nbHotels;
    }

    /**
     * @return the _joueurs
     */
    public ArrayList<Joueur> getJoueurs() {
        return _joueurs;
    }

    /**
     * @param _joueurs the _joueurs to set
     */
    public void setJoueurs(ArrayList<Joueur> _joueurs) {
        this._joueurs = _joueurs;
    }

    /**
     * @return the _carreaux
     */
    public HashMap<Integer, Carreau> getCarreaux() {
        return _carreaux;
    }

    /**
     * @param _carreaux the _carreaux to set
     */
    public void setCarreaux(HashMap<Integer, Carreau> _carreaux) {
        this._carreaux = _carreaux;
    }

    /**
     * @return the _groupes
     */
    public HashMap<CouleurPropriete,Groupe> getGroupes() {
        return _groupes;
    }

    /**
     * @param _groupes the _groupes to set
     */
    public void setGroupes(HashMap<CouleurPropriete,Groupe> _groupes) {
        this._groupes = _groupes;
    }
        
    
    public Groupe getGroupe (CouleurPropriete c ) {
    
    return this.getGroupes().get(c) ; 
    }

    /**
     * @return the _IHM
     */
    public IHM getIHM() {
        return _IHM;
    }
        
    private int getIndPrem(String nomPrem){
        int i = 0, k = 0;
        for(Joueur j : this.getJoueurs()){
            if(nomPrem == j.getNomJoueur()){
              k=i;  
            }
            i++;
        }
        return k;
    }    
}
