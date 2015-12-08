package Jeu;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class Monopoly {
	private final int _nbMaisons = 32;
	private final int _nbHotels = 12;
        private ArrayList<Joueur> _joueurs;
        private HashMap<Integer, Carreau> _carreaux;
        private IHM _IHM;
        
        /* Constructor */
        public Monopoly(String dataFilename){
		buildGamePlateau(dataFilename);
	}
        
	public void jouerUnCoup(Joueur j) {
		
	}

	private void lancerDésAvancer() {
		
	}

	/*public int calculArRest() {
		
	
	}

	public int genererChiffreDés() {
		
	}

	public Carreau calculPositionNum(int num) {
		
	}*/

	public void mettreEnPrison(Joueur j) {
		
	}
        
        /***************************** Init Game Plateau *****************************/
        private void buildGamePlateau(String dataFilename)
	{           
		try{
			ArrayList<String[]> data = readDataFile(dataFilename, ",");
			/* Creation of mutiples objects */

                        
			for(int i=0; i<data.size(); ++i){
				String caseType = data.get(i)[0];
				if(caseType.compareTo("P") == 0){
					System.out.println("Propriété :\t" + data.get(i)[2] + "\t@ case " + data.get(i)[1]);
                                        // IL MANQUE LES DIFFERENTS LOYERS
                                        _carreaux.put(Integer.parseInt(data.get(i)[1]),new ProprieteAConstruire(Integer.parseInt(data.get(i)[1]),data.get(i)[2],Integer.parseInt(data.get(i)[5]),data.get(i)[5],Integer.parseInt(data.get(i)[11])));
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
        
        
        
}
