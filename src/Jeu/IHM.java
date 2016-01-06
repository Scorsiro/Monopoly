package Jeu;

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
	
    public void affichagePlateau(){
    this.espacement();
    System.out.println("**************************************************************************************************************************************************************************************");
    System.out.println("*                      *    Avenue    *              *   Boulevard  *    Avenue    *     Gare     *   Faubourg   *   Place de   * Compagnie de *    Rue la    *                      *");
    System.out.println("*                      *   Matignon   *              *  Malesherbes * Henri-Martin *    du Nord   *Saint-Honnoré *   la Bourse  * distribution *    fayette   *  Allez               *");
    System.out.println("*      Parc            *              *    CHANCE    *              *              *              *              *              *              *              *                      *");
    System.out.println("*                      *              *              *              *              *              *              *              *              *              *      en              *");
    System.out.println("*                      *     PRIX     *       ?      *     PRIX     *     PRIX     *     PRIX     *     PRIX     *     PRIX     *     PRIX     *     PRIX     *                      *");
    System.out.println("*           Gratuit    *              *              *              *              *              *              *              *              *              *         Prison       *");
    System.out.println("*                      ****************************************************************************************************************************************                      *");
    System.out.println("*                      *  M:0    H:0  *              *  M:0    H:0  *  M:0    H:0  *              *  M:0    H:0  *  M:0    H:0  *              *  M:0    H:0  *                      *");
    System.out.println("*                      *  J:3         *              *              *              *              *              *              *              *              *                      *");  
    System.out.println("**************************************************************************************************************************************************************************************");
    System.out.println("* Place       * M:0    *                                                                                                                                      * M:0    * Avenue de   *");
    System.out.println("*   Pigalle   * H:0    *                                                                                                                                      * H:0    *    Breteuil *");
    System.out.println("*             *J:123456*                                                                                                                                      *j:123456*             *");
    System.out.println("*   PRIX      *        *                                                                                                                                      *        *     PRIX    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*  Boulevard  *        *                                                                                                                                      *        * Avenue      *");
    System.out.println("* Saint-Michel*        *                                                                                                                                      *        *      Foch   *");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     PRIX    *        *                                                                                                                                      *        *     PRIX    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*   Caisse    *        *                                                                                                                                      *        * Caisse de   *");
    System.out.println("*     de      *        *                                                                                                                                      *        *  Communauté *");
    System.out.println("* Communauté  *        *                                                                                                                                      *        *             *");
    System.out.println("*     PRIX    *        *                                                                                                                                      *        *             *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*   Avenue    *        *                                                                                                                                      *        *Boulevard des*");
    System.out.println("*    Mozart   *        *                                                                                                                                      *        *  Capucines  *");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     PRIX    *        *                                                                                                                                      *        *     PRIX    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*   Gare de   *        *                                                                                                                                      *        *     Gare    *");
    System.out.println("*     Lyon    *        *                                                                                                                                      *        *Saint-Lazaire*");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     PRIX    *        *                                                                                                                                      *        *     PRIX    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*  Rue de     *        *                                                                                                                                      *        *    Chance   *");
    System.out.println("*   Paradis   *        *                                                                                                                                      *        *       ?     *");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     PRIX    *        *                                                                                                                                      *        *             *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("*  Avenue de  *        *                                                                                                                                      *        *  Avenue des *");
    System.out.println("*   Neuilly   *        *                                                                                                                                      *        *Champs-Elysée*");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     PRIX    *        *                                                                                                                                      *        *     PRIX    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("* Compagnie de*        *                                                                                                                                      *        *   Taxe de   *");
    System.out.println("* distribution*        *                                                                                                                                      *        *    luxe     *");
    System.out.println("*d'électricité*        *                                                                                                                                      *        *             *");
    System.out.println("*     PRIX    *        *                                                                                                                                      *        *     PRIX    *");
    System.out.println("************************                                                                                                                                      ************************");
    System.out.println("* Boulevard de*        *                                                                                                                                      *        *  Rue de la  *");
    System.out.println("* la Villette *        *                                                                                                                                      *        *     Paix    *");
    System.out.println("*             *        *                                                                                                                                      *        *             *");
    System.out.println("*     PRIX    *        *                                                                                                                                      *        *     PRIX    *");
    System.out.println("**************************************************************************************************************************************************************************************");
    System.out.println("*j:123456     *j:123456*              *              *              *              *              *              *              *              *              *                      *");
    System.out.println("*             *        *              *              *              *              *              *              *              *              *              *                      *");
    System.out.println("*   S         * En     ****************************************************************************************************************************************  D                   *");
    System.out.println("*   i         *  Prison*    Avenue    *    Rue de    *              *    Rue de    *     Gare     *  Impôts sur  *     Rue      *   Caisse de  * Boulevard de *    E                 *");
    System.out.println("*   m         ********** la Republique*  Courcelles  *              *   Vaugirard  * Montparnasse *  le revenu   *   Lecourbe   *   communauté *  Belleville  *      P               *");
    System.out.println("*   p                  *              *              *    CHANCE    *              *              *              *              *              *              *        A             *");
    System.out.println("*   l                  *              *              *              *              *              *              *              *              *              *          R           *");
    System.out.println("*   e                  *     PRIX     *      PRIX    *       ?      *     PRIX     *     PRIX     *     PRIX     *     PRIX     *              *     PRIX     *            T         *");
    System.out.println("*      Visite          *              *              *              *              *              *              *              *              *              *                      *");
    System.out.println("**************************************************************************************************************************************************************************************");
    }
    
    public void afficheArriveeCase(int d1, int d2, Carreau nvCase, Carreau anCase, Joueur j){
        System.out.println("Tour du joueur " + j.getNomJoueur());
        System.out.println("Valeur du premier dé : " + d1 +
                           " Valeur du second dé : " + d2);
        System.out.println("Ancienne position : " + anCase.getNomCarreau() +
                           "Nouvelle position : " + nvCase.getNomCarreau());
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
        
                while(rep!="oui"|| rep!= "non"   ){
              
                System.out.println ("Veuillez entrer 'oui'ou 'non'") ;
                rep = sc.nextLine() ;
                }
                return rep ;
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
}