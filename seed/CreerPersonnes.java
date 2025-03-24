package nhl2024.seed;

import nhl2024.controleurs.LigueControleur;
import nhl2024.entites.Gardien;
import nhl2024.entites.Joueur;
import nhl2024.entites.Personne;
import nhl2024.exceptions.JoueurExisteDejaException;
import nhl2024.utils.PersonneFactory;

/**
 *
 * @author Bruno Theoret
 */
public class CreerPersonnes {
    
    public static void gardien(){
        Personne g1 = PersonneFactory.creerPersonne("Gardien", "Samuel", "Montambeault", 1500000, 0);
        
        try{
            LigueControleur.recruterPersonne(g1);
        } catch (JoueurExisteDejaException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void joueur(){

        // Joueurs du Canadien
        Personne c = PersonneFactory.creerPersonne("Joueur", "Nick", "Suzuki", 6000000, 0);
        //Personne c2 = PersonneFactory.creerPersonne("Joueur", "Nick", "Suzuki", 6000000, 0); // l'objet est cree avec un id=2
                        
        Personne ad = PersonneFactory.creerPersonne("Joueur", "Josh", "Anderson", 5500000, 0);
        Personne ag = PersonneFactory.creerPersonne("Joueur", "Cole", "Caufield", 7000000, 0);
        Personne d1 = PersonneFactory.creerPersonne("Joueur", "Mike", "Matheson", 4875000, 0);
        Personne d2 = PersonneFactory.creerPersonne("Joueur", "David", "Savard", 3500000, 0);
        try{
            LigueControleur.recruterPersonne(c);
            LigueControleur.recruterPersonne(ad);
            //LigueControleur.recruterPersonne(c2); // va throw exception parce que Nick Suzuki existe
            LigueControleur.recruterPersonne(ag);
            LigueControleur.recruterPersonne(d1);
            LigueControleur.recruterPersonne(d2);

          } catch (JoueurExisteDejaException e){
                System.out.println(e.getMessage());
          }
     }
    
    public static void entraineur(LigueControleur lnh){
         Personne e1 = PersonneFactory.creerPersonne("Entraineur", "Jacques", "Lemaire", 2000000, 50000);
         Personne e2 = PersonneFactory.creerPersonne("Entraineur", "Jacques", "Demers", 3500000, 0);
         try {
             LigueControleur.recruterPersonne(e1);
             LigueControleur.recruterPersonne(e2);
         } catch (JoueurExisteDejaException e){
             System.out.println(e.getMessage());
         }
    }
}