
package nhl2024.entites;

import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Bruno Theoret
 */
public class Personne {
    protected String prenom;
    protected String nom;

    public Personne(String prenom, String nom) {
        this.prenom = prenom;
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public String getNomComplet(){
        return getPrenom() + " " + getNom();
    }
    
    @Override
    public String toString() {
        return "Personne{"  + "prenom=" + prenom + ",nom=" + nom + '}';
    }
                    
                    
}
