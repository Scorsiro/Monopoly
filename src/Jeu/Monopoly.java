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


public class Monopoly {
	private final int _nbMaisons = 32;
	private final int _nbHotels = 12;
        private ArrayList<Joueur> _joueurs ; //  = new ArrayList <> () ;
        private HashMap<Integer, Carreau> _carreaux  ; //= new HashMap<>() ;
        private IHM _IHM;
        private HashMap<CouleurPropriete,Groupe> _groupes;
        
        /* Constructor */
        public Monopoly(String dataFilename){
	       _joueurs = new ArrayList <> () ;  
               _carreaux = new HashMap<>();
               _groupes = new HashMap<>();
            buildGamePlateau(dataFilename);
            this.lancementPartie();
	}
        
        private void lancementPartie(){
            int choix = 0;
            String nomPremJ;
            while(choix != 0){
                choix = this.getIHM().affichageMenu();
                if(choix == 1){
                    nomPremJ = this.InitialiserPartie();
                }
                if(choix == 3){
                    //this.lancementDemo();
                }
            }
        }
        
	public void jouerUnCoup(Joueur j) {
		this.lancerDésAvancer(j );
                
                while (j.getNbDoubles() != 0  ) {
                    this.lancerDésAvancer(j);
                
                }
                
                
	}

	private void lancerDésAvancer(Joueur j) {
            
            if(j.getNbDoubles() < 3) {
                int d1 = this.genererChiffreDés() ; 
                int d2 = this.genererChiffreDés() ; 
                j.setDes(d1+d2);
                
                if (d1 == d2 ) {
                    j.setNbDoubles(j.getNbDoubles() + d1 );
                }
                else {j.setNbDoubles(0);}
                
                Carreau c = j.getPositionCourante() ; 
                int num = c.getNumero() ; 
                Carreau nc = this.calculPositionNum(num + d1 +d2) ; 
                j.setPositionCourante(nc); }
            else {
                this.mettreEnPrison(j); 
            }  
        } 
          
        
         public void jouerPlusieursCoups(){
            for(Joueur j : _joueurs){
                jouerUnCoup(j);
            }   
         }

	public int genererChiffreDés() {
		
            Random rand = new Random () ; 
            int d1 = rand.nextInt(6) ; 
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
                ArrayList<Integer> exaequo = new ArrayList<>();
                String nomPrem = null;
                
                int nbJoueurs=0;
                
                while(nbJoueurs < 2 || nbJoueurs > 6){
                    System.out.print("\nEntrez le nombre de joueur désirant jouer : ");
                    nbJoueurs = scb.nextInt();
                }
                
                /* Init du joueur 0 avec pour nom vide et rang 0 (Bouche trou) */
                Joueur jVide = new Joueur("vide");
                _joueurs.add(0,jVide);
                
                while (nbJoueurs<6) {
                    nbJoueurs++;
                    System.out.println("Joueur " + nbJoueurs);
                    System.out.print("Saisissez votre nom : ");
                    String nom = sca.nextLine();
                    Joueur j = new Joueur(nom);
                    _joueurs.add(j);
                }
                
                while(!fin){
                    
                    for(int j = 0; j<=nbJoueurs; j++){
                        lanceDe.add(j, genererChiffreDés()); //génère les chiffres dans l'arraylist avec les joueurs
                    }
                
                    int max = Collections.max(lanceDe); // 'max' est le chiffre max de l'arraylist
                    int freq = Collections.frequency(lanceDe, max);
                    
                    if(freq == 1){
                        nomPrem = lanceDe.get(max).toString();// nomPrem est le nom du joueur associé au numero 'de'
                        fin = true;
                    } 
                    
                    if(freq > 1){
                        Random rand = new Random();
                        
                        for(int k = 0;k<=freq;k++){
                        exaequo.add(k,max);}
                        
                        int deRand = rand.nextInt(exaequo.size());
                        nomPrem = exaequo.get(deRand).toString();
                        fin = true;
                    }
                } 
                sca.close();
                scb.close();
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
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        
                                        // Ajouts des differents loyers dans l'ArrayList (Les valeurs des loyers sont dans les case 5 à 10 du fichier.)
                                        for(int j = 5; j<=10; j++){
                                            loyers.add(j-5,Integer.parseInt(data.get(i)[j]));
                                        }
                                        
                                        Groupe grTemp = new Groupe(data.get(i)[11],Integer.parseInt(data.get(i)[11]));
                                        
                                        /* Init du carreau               numCase                                     numCase                         nom                           prix         couleur   oyers */
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[4]),grTemp,loyers));
                                }
				else if(caseType.compareTo("G") == 0){
					System.out.println("Gare :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new Gare(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3])));       
				}
				else if(caseType.compareTo("C") == 0){
					System.out.println("Compagnie :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new Compagnie(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3])));  
				}
				else if(caseType.compareTo("CT") == 0){
					System.out.println("Case Tirage :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new CarreauTirage(Integer.parseInt(data.get(i)[1]),data.get(i)[2]));
				}
				else if(caseType.compareTo("CA") == 0){
					System.out.println("Case Argent :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new CarreauArgent(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[3])));
				}
				else if(caseType.compareTo("CM") == 0){
					System.out.println("Case Mouvement :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new CarreauMouvement(Integer.parseInt(data.get(i)[1]),data.get(i)[2]));
				}
				else
					System.err.println("[buildGamePleateau()] : Invalid Data type");
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
        
        
}
