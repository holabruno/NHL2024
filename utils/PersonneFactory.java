package nhl2024.utils;

import nhl2024.entites.Gardien;
import nhl2024.entites.Joueur;
import nhl2024.entites.Personne;
import nhl2024.entites.Entraineur;

/**
 *
 * @author Bruno Theoret
 */
public class PersonneFactory {
    public static Personne creerPersonne(String type, String prenom, String nom, double salaire, double bonus){
        if(type.equalsIgnoreCase("Joueur")){
            return new Joueur(prenom, nom, salaire);
        } else if(type.equalsIgnoreCase("Gardien")){
            return new Gardien(prenom, nom, salaire);
        } else if(type.equalsIgnoreCase("Entraineur")){
            return new Entraineur(prenom, nom, salaire, bonus);
        }    
        return null;
    }
}
