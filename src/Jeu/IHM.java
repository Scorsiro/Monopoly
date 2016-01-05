package Jeu;

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
                try{TimeUnit.SECONDS.sleep(1);}
                catch(InterruptedException a){}
                
                /* On vide le buffer */
                choix =0;
                sc.nextLine();
                }
            
            System.out.println("\n");

            if((choix <= 2) && (choix >= 1)){
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
    System.out.println("**************************************************************************************************************************************************************************");
    System.out.println("*                *    Avenue    *              *   Boulevard  *    Avenue    *     Gare     *   Faubourg   *   Place de   * Compagnie de *    Rue la    *                *");
    System.out.println("* Parc           *   Matignon   *              *  Malesherbes * Henri-Martin *    du Nord   *Saint-Honnoré *   la Bourse  * distribution *    fayette   *  Allez         *");
    System.out.println("*                *              *    CHANCE    *              *              *              *              *              *              *              *                *");
    System.out.println("*                *              *              *              *              *              *              *              *              *              *      en        *");
    System.out.println("*      Gratuit   *     PRIX     *       ?      *     PRIX     *     PRIX     *     PRIX     *     PRIX     *     PRIX     *     PRIX     *     PRIX     *                *");
    System.out.println("*                *              *              *              *              *              *              *              *              *              *         Prison *");
    System.out.println("*                ****************************************************************************************************************************************                *");
    System.out.println("*                *  M:0    H:0  *              *  M:0    H:0  *  M:0    H:0  *              *  M:0    H:0  *  M:0    H:0  *              *  M:0    H:0  *                *");
    System.out.println("*                *  J:3         *              *              *              *              *              *              *              *              *                *");  
    System.out.println("**************************************************************************************************************************************************************************");
    System.out.println("* Place    * M:0 *                                                                                                                                      *                *");
    System.out.println("*   Pigalle* H:0 *                                                                                                                                                       *");
    System.out.println("*          *J:   *                                                                                                                                                       *");
    System.out.println("******************");
    System.out.println("*          * M:0 *");
    System.out.println("**************************************************************************************************************************************************************************");
    System.out.println("*      *         *              *              *              *              *              *              *              *              *              *                *");
    System.out.println("*      *         *              *              *              *              *              *              *              *              *              *                *");
    System.out.println("*   S  * En      ****************************************************************************************************************************************  D             *");
    System.out.println("*   i  *  Prison *    Avenue    *    Rue de    *              *    Rue de    *     Gare     *  Impôts sur  *     Rue      *   Caisse de  * Boulevard de *    E           *");
    System.out.println("*   m  *********** la Republique*  Courcelles  *              *   Vaugirard  * Montparnasse *  le revenu   *   Lecourbe   *   communauté *  Belleville  *      P         *");
    System.out.println("*   p            *              *              *    CHANCE    *              *              *              *              *              *              *        A       *");
    System.out.println("*   l            *              *              *              *              *              *              *              *              *              *          R     *");
    System.out.println("*   e            *     PRIX     **     PRIX    *       ?      *     PRIX     *     PRIX     *     PRIX     *     PRIX     *              *     PRIX     *            T   *");
    System.out.println("*      Visite    *              *              *              *              *              *              *              *              *              *                *");
    System.out.println("**************************************************************************************************************************************************************************");
    }
    
    /********************* Utilitaire *********************/
    
    private void espacement(){
        for(int i = 0; i<=25; i++){
            System.out.println("\n");
        }
    }
    
    
}