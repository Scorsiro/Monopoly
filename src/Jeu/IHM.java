package Jeu;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class IHM {
    private Monopoly monop;
    
    /* Couleurs */
    public static final String B_RESET = "\u001B[0m";
    public static final String B_RED = "\u001B[41m";
    public static final String B_GREY = "\u001B[47m";
    public static final String B_GREEN = "\u001B[42m";
    public static final String B_YELLOW = "\u001B[43m";
    public static final String B_BLUE = "\u001B[44m";
    public static final String B_PURPLE = "\u001B[45m";
    public static final String B_CYAN = "\u001B[46m";
	
    public IHM(){
         
    }
    
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
      System.out.print("*                      *"+B_RED+"   P:");affP(22,mono);System.out.print("   "+B_RESET+"*              *"+B_RED+"   P:");affP(24,mono);System.out.print("   "+B_RESET+"*"+B_RED+"   P:");affP(25,mono);System.out.print("   "+B_RESET+"*"+"   P:");affP(26,mono);System.out.print("   "+"*"+B_YELLOW+"   P:");affP(27,mono);System.out.print("   "+B_RESET+"*"+B_YELLOW+"   P:");affP(28,mono);System.out.print("   "+B_RESET+"*"+"   P:");affP(29,mono);System.out.print("   "+"*"+B_YELLOW+"   P:");affP(30,mono);System.out.print("   "+B_RESET+"*                      *"); System.out.println("      Solde : " + mono.getJoueurs().get(2).getCash());
      System.out.print("*  J:");affJ(21,mono);System.out.print("            *"+B_RED+"   J:");affJ(22,mono);System.out.print("   "+B_RESET+"*   J:");affJ(23,mono);System.out.print("   *"+B_RED+"   J:");affJ(24,mono);System.out.print("   "+B_RESET+"*"+B_RED+"   J:");affJ(25,mono);System.out.print("   "+B_RESET+"*   J:");affJ(26,mono);System.out.print("   *"+B_YELLOW+"   J:");affJ(27,mono);System.out.print("   "+B_RESET+"*"+B_YELLOW+"   J:");affJ(28,mono);System.out.print("   "+B_RESET+"*   J:");affJ(29,mono);System.out.print("   *"+B_YELLOW+"   J:");affJ(30,mono);System.out.print("   "+B_RESET+"*   J:");affJ(31,mono);System.out.print("           *"); System.out.println("   Position : " + mono.getJoueurs().get(2).getPositionCourante().getNomCarreau()); 
      System.out.print("**************************************************************************************************************************************************************************************"); System.out.println("**************************");
      System.out.print("* Place       *"+B_GREY+"        "+B_RESET+"*                                                                                                                                      *"+B_GREEN+"        "+B_RESET+"* Avenue de   *");if(mono.getJoueurs().size()>3){System.out.println("   Joueur 3 : " + mono.getJoueurs().get(3).getNomJoueur());} else{System.out.println("");}
      System.out.print("*   Pigalle   *"+B_GREY+"J:");affJ(20,mono);System.out.print(B_RESET+"*                                                                                                                                      *"+B_GREEN+"J:");affJ(32,mono);System.out.print(""+B_RESET+"*    Breteuil *");if(mono.getJoueurs().size()>3){System.out.println("      Solde : " + mono.getJoueurs().get(3).getCash());}else{System.out.println("");}
      System.out.print("*             *"+B_GREY+"P:");affP(20,mono);System.out.print(B_RESET+"*                                                                                                                                      *"+B_GREEN+"P:");affP(32,mono);System.out.print(""+B_RESET+"*             *");if(mono.getJoueurs().size()>3){System.out.println("   Position : " + mono.getJoueurs().get(3).getPositionCourante().getNomCarreau());}else{System.out.println("");} 
      System.out.print("*     200€    *"+B_GREY+"        "+B_RESET+"*                                                                                                                                      *"+B_GREEN+"        "+B_RESET+"*     300€    *");if(mono.getJoueurs().size()>3){System.out.println("**************************");}else{System.out.println("");}
      System.out.print("************************                                                                                                                                      ************************");if(mono.getJoueurs().size()>4){System.out.println("   Joueur 4 : " + mono.getJoueurs().get(4).getNomJoueur());} else{System.out.println("");}
      System.out.print("*  Boulevard  *"+B_GREY+"        "+B_RESET+"*                                                                                                                                      *"+B_GREEN+"        "+B_RESET+"* Avenue      *");if(mono.getJoueurs().size()>4){System.out.println("      Solde : " + mono.getJoueurs().get(4).getCash());}else{System.out.println("");}
      System.out.print("* Saint-Michel*"+B_GREY+"J:");affJ(19,mono);System.out.print(B_RESET+"*                                                                                                                                      *"+B_GREEN+"J:");affJ(33,mono);System.out.print(""+B_RESET+"*      Foch   *");if(mono.getJoueurs().size()>4){System.out.println("   Position : " + mono.getJoueurs().get(4).getPositionCourante().getNomCarreau());}else{System.out.println("");}
      System.out.print("*             *"+B_GREY+"P:");affP(19,mono);System.out.print(B_RESET+"*                                                                                                                                      *"+B_GREEN+"P:");affP(33,mono);System.out.print(""+B_RESET+"*             *");if(mono.getJoueurs().size()>4){System.out.println("**************************");}else{System.out.println("");}
      System.out.print("*     180€    *"+B_GREY+"        "+B_RESET+"*                                                                                                                                      *"+B_GREEN+"        "+B_RESET+"*     300€    *");if(mono.getJoueurs().size()>5){System.out.println("   Joueur 5 : " + mono.getJoueurs().get(5).getNomJoueur());} else{System.out.println("");}
      System.out.print("************************                                                                                                                                      ************************");if(mono.getJoueurs().size()>5){System.out.println("    Solde : " + mono.getJoueurs().get(5).getCash());}else{System.out.println("");}
      System.out.print("*   Caisse    *        *                                                                                                                                      *        * Caisse de   *");if(mono.getJoueurs().size()>5){System.out.println(" Position : " + mono.getJoueurs().get(5).getPositionCourante().getNomCarreau());}else{System.out.println("");}
      System.out.print("*     de      *J:");affJ(18,mono);System.out.print("*                                                                                                                                      *J:");affJ(34,mono);System.out.print("*  Communauté *");if(mono.getJoueurs().size()>5){System.out.println("**************************");}else{System.out.println("");}
      System.out.print("* Communauté  *        *                                                                                                                                      *        *             *");if(mono.getJoueurs().size()>6){System.out.println("   Joueur 6 : " + mono.getJoueurs().get(6).getNomJoueur());} else{System.out.println("");}
      System.out.print("*             *        *                                                                                                                                      *        *             *");if(mono.getJoueurs().size()>6){System.out.println("      Solde : " + mono.getJoueurs().get(6).getCash());}else{System.out.println("");}
      System.out.print("************************                                                                                                                                      ************************");if(mono.getJoueurs().size()>6){System.out.println("   Position : " + mono.getJoueurs().get(6).getPositionCourante().getNomCarreau());}else{System.out.println("");}
      System.out.print("*   Avenue    *"+B_GREY+"        "+B_RESET+"*                                                                                                                                      *"+B_GREEN+"        "+B_RESET+"*Boulevard des*");if(mono.getJoueurs().size()>6){System.out.println("**************************");}else{System.out.println("");}
      System.out.print("*    Mozart   *"+B_GREY+"J:");affJ(17,mono);System.out.print(B_RESET+"*                                                                                                                                      *"+B_GREEN+"J:");affJ(35,mono);System.out.println(""+B_RESET+"*  Capucines  *");
      System.out.print("*             *"+B_GREY+"P:");affP(17,mono);System.out.print(B_RESET+"*                                                                                                                                      *"+B_GREEN+"P:");affP(35,mono);System.out.println(""+B_RESET+"*             *");
    System.out.println("*     180€    *"+B_GREY+"        "+B_RESET+"*                                                                                                                                      *"+B_GREEN+"        "+B_RESET+"*     320€    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*   Gare de   *        *                                                                                                                                      *        *     Gare    *");
      System.out.print("*     Lyon    *J:");affJ(16,mono);System.out.print("*                                                                                                                                      *J:");affJ(36,mono);System.out.println("*Saint-Lazaire*");
      System.out.print("*             *P:");affP(16,mono);System.out.print("*                                                                                                                                      *P:");affP(36,mono);System.out.println("*             *");
    System.out.println("*     200€    *        *                                                                                                                                      *        *     200€    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*  Rue de     *        *                                                                                                                                      *        *    Chance   *");
      System.out.print("*   Paradis   *J:");affJ(15,mono);System.out.print("*                                                                                                                                      *J:");affJ(37,mono);System.out.println("*       ?     *");
      System.out.print("*             *P:");affP(15,mono);System.out.println("*                                                                                                                                      *        *             *");
    System.out.println("*     160€    *        *                                                                                                                                      *        *             *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*  Avenue de  *        *                                                                                                                                      *"+B_BLUE+"        "+B_RESET+"*  Avenue des *");
      System.out.print("*   Neuilly   *J:");affJ(14,mono);System.out.print("*                                                                                                                                      *"+B_BLUE+"J:");affJ(38,mono);System.out.println(""+B_RESET+"*Champs-Elysée*");
      System.out.print("*             *P:");affP(14,mono);System.out.print("*                                                                                                                                      *"+B_BLUE+"P:");affP(38,mono);System.out.println(""+B_RESET+"*             *");
    System.out.println("*     140€    *        *                                                                                                                                      *"+B_BLUE+"        "+B_RESET+"*     350€    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("* Compagnie de*        *                                                                                                                                      *        *   Taxe de   *");
      System.out.print("* distribution*J:");affJ(13,mono);System.out.print("*                                                                                                                                      *J:");affJ(39,mono);System.out.println("*    luxe     *");
      System.out.print("*d'électricité*P:");affP(13,mono);System.out.println("*                                                                                                                                      *        *             *");
    System.out.println("*     150€    *        *                                                                                                                                      *        *     100€    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("* Boulevard de*        *                                                                                                                                      *"+B_BLUE+"        "+B_RESET+"*  Rue de la  *");
      System.out.print("* la Villette *J:");affJ(12,mono);System.out.print("*                                                                                                                                      *"+B_BLUE+"J:");affJ(40,mono);System.out.println(""+B_RESET+"*     Paix    *");
      System.out.print("*             *P:");affP(12,mono);System.out.print("*                                                                                                                                      *"+B_BLUE+"P:");affP(40,mono);System.out.println(""+B_RESET+"*             *");
    System.out.println("*     140€    *        *                                                                                                                                      *"+B_BLUE+"        "+B_RESET+"*     400€    *");
    System.out.println("**************************************************************************************************************************************************************************************");
      System.out.print("*   J:");affJ(11,mono);System.out.print("  *        *"+B_CYAN+"   J:");affJ(10,mono);System.out.print("   "+B_RESET+"*"+B_CYAN+"   J:");affJ(9,mono);System.out.print("   "+B_RESET+"*   J:");affJ(8,mono);System.out.print("   *"+B_CYAN+"   J:");affJ(7,mono);System.out.print("   "+B_RESET+"*   J:");affJ(6,mono);System.out.print("   *   J:");affJ(5,mono);System.out.print("   *"+B_PURPLE+"   J:");affJ(4,mono);System.out.print("   "+B_RESET+"*   J:");affJ(3,mono);System.out.print("   *"+B_PURPLE+"   J:");affJ(2,mono);System.out.print("   "+B_RESET+"* J:");affJ(1,mono);System.out.println("             *");
      System.out.print("*             *        *"+B_CYAN+"   P:");affP(10,mono);System.out.print("   "+B_RESET+"*"+B_CYAN+"   P:");affP(9,mono);System.out.print("   "+B_RESET+"*              *"+B_CYAN+"   P:");affP(7,mono);System.out.print("   "+B_RESET+"*"+"   P:");affP(6,mono);System.out.print("   "+"*              *"+B_PURPLE+"   P:");affP(4,mono);System.out.print("   "+B_RESET+"*              *"+B_PURPLE+"   P:");affP(2,mono);System.out.println("   "+B_RESET+"*                      *");
    System.out.println("*   S         * En     ****************************************************************************************************************************************  D                   *");
    System.out.println("*   i         *  Prison*    Avenue    *    Rue de    *              *    Rue de    *     Gare     *  Impôts sur  *     Rue      *   Caisse de  * Boulevard de *    E                 *");
    System.out.println("*   m         ********** la Republique*  Courcelles  *              *   Vaugirard  * Montparnasse *  le revenu   *   Lecourbe   *   communauté *  Belleville  *      P               *");
    System.out.println("*   p                  *              *              *    CHANCE    *              *              *              *              *              *              *        A             *");
    System.out.println("*   l                  *              *              *              *              *              *              *              *              *              *          R           *");
    System.out.println("*   e                  *     120€     *      100€    *       ?      *     100€     *     200€     *     200€     *      60€     *              *      60€     *            T         *");
    System.out.println("*      Visite          *              *              *              *              *              *              *              *              *              *                      *");
    System.out.println("**************************************************************************************************************************************************************************************");
    //Joueur c = ((CarreauPropriete)mono.getCarreaux().get(2)).getProprietaire().;
    
    }
    
    //affiche les numéros des joueurs présents sur la case numCase
    private void affJ(int numCase, Monopoly mono){
        int nbJoueur = 0;
        for(int i = 1; i<mono.getJoueurs().size(); i++){
            if(numCase == mono.getJoueurs().get(i).getPositionCourante().getNumero()){
                System.out.print(i);
                nbJoueur++;
            }
        }
        for(int j = 0; j < 6-nbJoueur;j++){
                System.out.print(" ");
            }
    }
    
    //affiche le numéro du joueur proprietaire du Carreau de numéro de case numCase
    private void affP(int numCase, Monopoly mono){
        boolean trouve = false;
        for(int i = 1; i<mono.getJoueurs().size(); i++){
           if(((CarreauPropriete)mono.getCarreaux().get(numCase)).getProprietaire() == mono.getJoueurs().get(i)){
               System.out.print(i);
               trouve = true;
           } 
        }
        System.out.print("     ");
        if(!trouve){
           System.out.print(" "); 
        }
    }
    
    public void afficheArriveeCase(int d1, int d2, Carreau anCase, Carreau ncCase, Joueur j){
        System.out.println("\n\nTour du joueur " + j.getNomJoueur());
        System.out.println("Valeur du premier dé : " + d1 +
                         "\n Valeur du second dé : " + d2);
        System.out.println("Ancienne position : " + anCase.getNomCarreau() +
                         "\nNouvelle position : " + ncCase.getNomCarreau()+"\n\n");
        delay(5);
    }
    
    public void affichePrison(){
        System.out.println("Vous êtes en prison.");
    }
    
    public void afficheGagnant(Joueur j){
        System.out.println("*****************");
          System.out.print("*  *         *  *");                       
          System.out.print("*        *      *");                       
          System.out.print("*     *         *         LE GAGNANT EST" + j.getNomJoueur() + '.');
          System.out.print("*    0     *    *");                        
          System.out.print("*  --#--        *");                        
          System.out.print("*   /\\          *");                        
          System.out.print("*  /  \\         *");                        
        System.out.println("*****************");   
    }
    
    public int getAchatRep () {
        Scanner scc = new Scanner (System.in) ; 
        System.out.print ("Voulez vous acheter la propriétée ? : \t") ; 
        System.out.println ("Entrer '1. oui' | '2. non' : ") ;
        int rep = 0;
      
        
        rep = scc.nextInt(); 
        
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
        int rep = 0; 
        
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
    
   
    
    public void affichePasAcheter () {
    
        System.out.println("OK, Vous ne voulez pas acheter cette propriété!");
    
    }
    
    public void affichePeutPasAcheter () {
    
        System.out.println("Vous ne pouvez pas acheter cette propriété, elle a déjà un propriétaire !");
    
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
    
   public int afficheCadreChoix(){
       
        Scanner sc = new Scanner (System.in) ;
        int rep = 0;
        
        while(rep < 1 || rep > 3){
      
        System.out.println("========================================================") ;
        System.out.println("= 1 - Acheter | 2 - Construire | 3 - Passez au suivant =") ;
        System.out.println("========================================================") ;
        System.out.println("=             Quel est votre choix ?                   =") ;
        System.out.println("========================================================") ;
        
        rep = sc.nextInt() ;   
        
        }
        
        return rep;
       

       
   }
   
   public void afficheNFois(int n, String s){
       for (int i = 1;i<=n;i++){
           System.out.print(s);
       }
   }
   
   public void afficheCarteProprieteAC(ProprieteAConstruire p){
       
       int n = p.getNomCarreau().length();
       
       System.out.print("***");afficheNFois(n+8,"*");System.out.println("*");
       //System.out.print("*  ");afficheNFois(n," ");System.out.println("  *");
       System.out.println("*     "+p.getNomCarreau()+"     *");
       //System.out.print("*");afficheNFois(n," ");System.out.println("*");
      // System.out.print("*");afficheNFois(n," ");System.out.println("*");
       System.out.print("***");afficheNFois(n+8,"*");System.out.println("*");
       System.out.print("*  ");afficheNFois(n+8," ");System.out.println("*");
       System.out.print("*  Proprio : "+p.getProprietaire().getNomJoueur());afficheNFois(n+8-(10+p.getProprietaire().getNomJoueur().length()), " ");System.out.println("*");
       System.out.print("*  Maisons : "+p.getNbmaison());afficheNFois(n+8-11, " ");System.out.println("*");
       System.out.print("*  Hotel : "); if (p.getHotel()){System.out.print("1");} else System.out.print("0");afficheNFois(n+8-9, " ");System.out.println("*");
       System.out.print("*  ");afficheNFois(n+8," ");System.out.println("*");
       System.out.print("***");afficheNFois(n+8,"*");System.out.println("*");
       
   }
}
