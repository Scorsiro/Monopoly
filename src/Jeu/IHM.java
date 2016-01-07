package Jeu;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class IHM {
    private Monopoly monop;
	
    public IHM(){
         
    }
    
    /********************* Affichage *********************/
    
    public int affichageMenu(){
        boolean erreur = true;
        int choix = 0;
        Scanner sc = new Scanner(System.in);
       
        while(erreur == true){
        
        // Pour nettoyer la console entre chaque input
        this.espacement();
            
        System.out.println("************************************************************************");
        System.out.println("*        *     *   ****   *   *  ****   ****   ****  *    *   *        *");
        System.out.println("*        * * * *  *    *  **  * *    *  *   * *    * *     * *         *");
        System.out.println("*        *  *  *  *    *  * * * *    *  ****  *    * *      *          *");
        System.out.println("*        *     *  *    *  *  ** *    *  *     *    * *      *          *");
        System.out.println("*        *     *   ****   *   *  ****   *      ****  ****   *          *");
        System.out.println("*                                                                      *");
        System.out.println("************************************************************************");
        System.out.println("*                                                                      *");
        System.out.println("*                    1.        Jouer                                   *");
        System.out.println("*                                                                      *");
        System.out.println("*                    2.       Quitter                                  *");
        System.out.println("*                                                                      *");
        System.out.println("************************************************************************");
        System.out.println("*            Par Tom Munier, Victor Carratala, Thafsouth Adli,         *");
        System.out.println("*                           Jordan Prudhomme                           *");
        System.out.println("*                                                                      *");
        System.out.println("*                      En Hommage à Axel Mondorio                      *");
        System.out.println("************************************************************************");
          System.out.print("* Votre choix : ");
        /* Rien à mettre dans options pour l'instant, mais des petits paramètres fun pourraient être implémenté avec le temps.*/
        
        //Empêche le programme de planter si jamais on entre autre chose qu'un Int
            try{choix = sc.nextInt();}
            catch(InputMismatchException e){
                System.out.println("Mauvaise entrée, veuillez recommencer.");
                
                /*Délais pour laisser le temps à l'utilisateur de lire les messages d'erreurs */
                this.delay(1);
                
                /* On vide le buffer */
                choix =0;
                sc.nextLine();
                }
            
            System.out.println("\n");

            if((choix <= 3) && (choix >= 1)){
                erreur = false;
            } else{
                System.out.println("");
            }  
        }    
        //sc.close();
        return choix;
    }
	
    public void affichagePlateau(Monopoly mono){
    System.out.println("**************************************************************************************************************************************************************************************");
    System.out.println("*                      *    Avenue    *              *   Boulevard  *    Avenue    *     Gare     *   Faubourg   *   Place de   * Compagnie de *    Rue la    *                      *");
      System.out.print("*                      *   Matignon   *              *  Malesherbes * Henri-Martin *    du Nord   *Saint-Honnoré *   la Bourse  * distribution *    fayette   *  Allez               *"); System.out.println("**************************");
      System.out.print("*      Parc            *              *    CHANCE    *              *              *              *              *              *              *              *                      *"); System.out.println("   Joueur 1 : " + mono.getJoueurs().get(1).getNomJoueur());
      System.out.print("*                      *              *              *              *              *              *              *              *              *              *      en              *"); System.out.println("      Solde : " + mono.getJoueurs().get(1).getCash());
      System.out.print("*                      *     220€     *       ?      *     220€     *     240€     *     200€     *     260€     *     260€     *     150€     *     280€     *                      *"); System.out.println("   Position : " + mono.getJoueurs().get(1).getPositionCourante().getNomCarreau());
      System.out.print("*           Gratuit    *              *              *              *              *              *              *              *              *              *         Prison       *"); System.out.println("**************************");
      System.out.print("*                      ****************************************************************************************************************************************                      *"); System.out.println("   Joueur 2 : " + mono.getJoueurs().get(2).getNomJoueur());
      System.out.print("*                      *  M:0    H:0  *              *  M:0    H:0  *  M:0    H:0  *              *  M:0    H:0  *  M:0    H:0  *              *  M:0    H:0  *                      *"); System.out.println("      Solde : " + mono.getJoueurs().get(2).getCash());
      System.out.print("*                      *J:323232  P:  *              *              *              *              *              *              *              *              *                      *"); System.out.println("   Position : " + mono.getJoueurs().get(2).getPositionCourante().getNomCarreau()); 
      System.out.print("**************************************************************************************************************************************************************************************"); System.out.println("**************************");
      System.out.print("* Place       * M:0    *                                                                                                                                      * M:0    * Avenue de   *");if(mono.getJoueurs().size()>3){System.out.println("   Joueur 3 : " + mono.getJoueurs().get(3).getNomJoueur());} else{System.out.println("");}
      System.out.print("*   Pigalle   * H:0    *                                                                                                                                      * H:0    *    Breteuil *");if(mono.getJoueurs().size()>3){System.out.println("      Solde : " + mono.getJoueurs().get(3).getCash());}else{System.out.println("");}
      System.out.print("*             *J:123456*                                                                                                                                      *j:123456*             *");if(mono.getJoueurs().size()>3){System.out.println("   Position : " + mono.getJoueurs().get(3).getPositionCourante().getNomCarreau());}else{System.out.println("");} 
      System.out.print("*     200€    *        *                                                                                                                                      *        *     300€    *");if(mono.getJoueurs().size()>3){System.out.println("**************************");}else{System.out.println("");}
      System.out.print("************************                                                                                                                                      ************************");if(mono.getJoueurs().size()>4){System.out.println("   Joueur 4 : " + mono.getJoueurs().get(4).getNomJoueur());} else{System.out.println("");}
      System.out.print("*  Boulevard  *        *                                                                                                                                      *        * Avenue      *");if(mono.getJoueurs().size()>4){System.out.println("      Solde : " + mono.getJoueurs().get(4).getCash());}else{System.out.println("");}
      System.out.print("* Saint-Michel*        *                                                                                                                                      *        *      Foch   *");if(mono.getJoueurs().size()>4){System.out.println("   Position : " + mono.getJoueurs().get(4).getPositionCourante().getNomCarreau());}else{System.out.println("");}
      System.out.print("*             *        *                                                                                                                                      *        *             *");if(mono.getJoueurs().size()>4){System.out.println("**************************");}else{System.out.println("");}
      System.out.print("*     180€    *        *                                                                                                                                      *        *     300€    *");if(mono.getJoueurs().size()>5){System.out.println("   Joueur 5 : " + mono.getJoueurs().get(5).getNomJoueur());} else{System.out.println("");}
      System.out.print("************************                                                                                                                                      ************************");if(mono.getJoueurs().size()>5){System.out.println("    Solde : " + mono.getJoueurs().get(5).getCash());}else{System.out.println("");}
      System.out.print("*   Caisse    *        *                                                                                                                                      *        * Caisse de   *");if(mono.getJoueurs().size()>5){System.out.println(" Position : " + mono.getJoueurs().get(5).getPositionCourante().getNomCarreau());}else{System.out.println("");}
      System.out.print("*     de      *        *                                                                                                                                      *        *  Communauté *");if(mono.getJoueurs().size()>5){System.out.println("**************************");}else{System.out.println("");}
      System.out.print("* Communauté  *        *                                                                                                                                      *        *             *");if(mono.getJoueurs().size()>6){System.out.println("   Joueur 6 : " + mono.getJoueurs().get(6).getNomJoueur());} else{System.out.println("");}
      System.out.print("*             *        *                                                                                                                                      *        *             *");if(mono.getJoueurs().size()>6){System.out.println("      Solde : " + mono.getJoueurs().get(6).getCash());}else{System.out.println("");}
      System.out.print("************************                                                                                                                                      ************************");if(mono.getJoueurs().size()>6){System.out.println("   Position : " + mono.getJoueurs().get(6).getPositionCourante().getNomCarreau());}else{System.out.println("");}
      System.out.print("*   Avenue    *        *                                                                                                                                      *        *Boulevard des*");if(mono.getJoueurs().size()>6){System.out.println("**************************");}else{System.out.println("");}
    System.out.println("*    Mozart   *        *                                                                                                                                      *        *  Capucines  *");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     180€    *        *                                                                                                                                      *        *     320€    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*   Gare de   *        *                                                                                                                                      *        *     Gare    *");
    System.out.println("*     Lyon    *        *                                                                                                                                      *        *Saint-Lazaire*");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     200€    *        *                                                                                                                                      *        *     200€    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*  Rue de     *        *                                                                                                                                      *        *    Chance   *");
    System.out.println("*   Paradis   *        *                                                                                                                                      *        *       ?     *");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     160€    *        *                                                                                                                                      *        *             *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*  Avenue de  *        *                                                                                                                                      *        *  Avenue des *");
    System.out.println("*   Neuilly   *        *                                                                                                                                      *        *Champs-Elysée*");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     140€    *        *                                                                                                                                      *        *     350€    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("* Compagnie de*        *                                                                                                                                      *        *   Taxe de   *");
    System.out.println("* distribution*        *                                                                                                                                      *        *    luxe     *");
    System.out.println("*d'électricité*        *                                                                                                                                      *        *             *");
    System.out.println("*     150€    *        *                                                                                                                                      *        *     100€    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("* Boulevard de*        *                                                                                                                                      *        *  Rue de la  *");
    System.out.println("* la Villette *        *                                                                                                                                      *        *     Paix    *");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     140€    *        *                                                                                                                                      *        *     400€    *");
    System.out.println("**************************************************************************************************************************************************************************************");
    System.out.println("*j:123456     *j:123456*              *              *              *              *              *              *              *              *              *                      *");
    System.out.println("*             *        *              *              *              *              *              *              *              *              *              *                      *");
    System.out.println("*   S         * En     ****************************************************************************************************************************************  D                   *");
    System.out.println("*   i         *  Prison*    Avenue    *    Rue de    *              *    Rue de    *     Gare     *  Impôts sur  *     Rue      *   Caisse de  * Boulevard de *    E                 *");
    System.out.println("*   m         ********** la Republique*  Courcelles  *              *   Vaugirard  * Montparnasse *  le revenu   *   Lecourbe   *   communauté *  Belleville  *      P               *");
    System.out.println("*   p                  *              *              *    CHANCE    *              *              *              *              *              *              *        A             *");
    System.out.println("*   l                  *              *              *              *              *              *              *              *              *              *          R           *");
    System.out.println("*   e                  *     120€     *      100€    *       ?      *     100€     *     200€     *     200€     *      60€     *              *      60€     *            T         *");
    System.out.println("*      Visite          *              *              *              *              *              *              *              *              *              *                      *");
    System.out.println("**************************************************************************************************************************************************************************************");
    
    
    }
    
    
    
    public void afficheArriveeCase(int d1, int d2, Carreau anCase, Carreau ncCase, Joueur j){
        System.out.println("\n\nTour du joueur " + j.getNomJoueur());
        System.out.println("Valeur du premier dé : " + d1 +
                         "\n Valeur du second dé : " + d2);
        System.out.println("Ancienne position : " + anCase.getNomCarreau() +
                         "\nNouvelle position : " + ncCase.getNomCarreau()+"\n\n");
    }
    
    public void affichePrison(){
        System.out.println("Vous êtes en prison.");
    }
    
    public String getAchatRep () {
        Scanner scc = new Scanner (System.in) ; 
        System.out.print ("Voulez vous acheter la propriétée ? : \t") ; 
        System.out.println ("Entrer 'oui'/ 'non' : ") ;
        String rep = null;
      
        rep = scc.next() ; 
        
            /*while("oui".equals(rep) || "non".equals(rep)   ){
              
                System.out.print ("Veuillez entrer 'oui'ou 'non': \t") ; 
                rep = scc.next() ;
            }*/
        return rep ; 
    }
    
    public void affichePeutPasPayer (){
    
        System.out.println ("Vous n'avez pas assez d'argent pour acheter la propriété") ; 
    }
    
    public void afficheCalculLoyer (int Ar, int montant ,String nomP) {
    
        System.out.println ("********************************************") ; 
        System.out.println ("************ Paiement du loyer *************") ; 
        System.out.println ("********************************************") ; 
      
        System.out.println("Le propriétaire est : " + nomP);
        System.out.println("Montant à payer " + montant );
        System.out.println ("Argent restant aprés paiement  :" + Ar) ; 
    }
    
    public String getLibRep () {
                Scanner sc = new Scanner (System.in) ;
                System.out.println ("Voulez vous utiliser votre carte libération") ;
                System.out.println ("Entrer 'oui'/ 'non'") ;
      
                String rep = sc.nextLine() ;
        
                while(rep.equals("oui")|| rep.equals("non")  ){
              
                System.out.println ("Veuillez entrer 'oui'ou 'non'") ;
                rep = sc.nextLine() ;
                }
                return rep ;
    }
    
    public void afficheTour(String nomJoueur){
        System.out.println("C'est au tour de " + nomJoueur + '.');
    }
    /********************* Utilitaire *********************/
    
    private void espacement(){
        for(int i = 0; i<=25; i++){
            System.out.println("\n");
        }
    } 
    
    private void delay(int temps){
        try{TimeUnit.SECONDS.sleep(temps);}
        catch(InterruptedException a){}
    }
    
    
    public void afficheP (){
    
            
        System.out.println("****************************************************************");
        System.out.println("************ Les propriétés ou vous pouvez construire **********");
        System.out.println("****************************************************************");
     }
    
    
    
    public void afficheConstruire (ProprieteAConstruire p) {

        //affichage des propriété Puis le joueur va choisir ou il  veut construire 
        System.out.println ("le numéro de la propriété : "+ p.getNumero() +"Le nom de la propriete : " + p.getNomCarreau() + "|Groupe : " + p.getGroupePropriete()+ "|Prix : " + p.getPrix()) ;  
     
    }
    
    public int getConstruireRep () {
        
        System.out.println("Parmis les proprietés : choisissez une propriété où vous voulez construire : Entrez son numéro !!") ; 
        Scanner sc = new Scanner(System.in) ; 
        int rep = sc.nextInt(); 
        
        /*while(rep!= p.getNumero()){
              
                System.out.println ("Mauvaise entrez, veuillez recommencer ! ") ;
                rep = sc.nextInt();
                }*/
        try{rep = sc.nextInt();}
            
            catch(InputMismatchException e){
                System.out.println("Mauvaise entrée, veuillez recommencer.");
        }
          return rep ;
    }

    public void affichePeutPasConstruire (){
    
        System.out.println ("Warning : y a pas de proprietés où vous pouvez construire !! " ) ; 
    }
    
    public void afficheCarte (Carte c){
    
        System.out.println ("Vous avez tirer la carte " + c.getNom() + c.getType()) ; 
    }
    
    public void affichePasAcheter () {
    
        System.out.println("Ok,vous ne voulez pas acheter cette propriété! On passe au tour suivant ");
    
    }
    
    public void afficheNbJoueur () {
            
        System.out.print("\nEntrez le nombre de joueur désirant jouer : ");
            
    }
    
    public String entrerNbJoueur (int nbJoueurs) {
    
        System.out.println("Joueur " + nbJoueurs);
        System.out.print("Saisissez votre nom : ");
        Scanner sc = new Scanner (System.in) ; 
        String nom = sc.next() ; 
        
        return nom;
    }
    
    public void affichePremJ (String nomPrem ) {
    
        System.out.println("\nLe joueurs qui commence est " + nomPrem +".\n\n");
    }
    
    public void afficheDes (int j , int des ) {
    
     System.out.println("Joueur "+ j + " fait un " + des + ".");
    
    }
    
    public void errorNotFound () {
    
        System.err.println("[buildGamePlateau()] : File is not found!");
    }
    
    public void errorReading () {
    
        System.err.println("[buildGamePlateau()] : Error while reading file!");
    }
    
   /* public void afficheMauvaiseEntree () {
    
        System.out.println("Veuillez entrer 'oui'ou 'non': \t");
    
    }*/
    
}