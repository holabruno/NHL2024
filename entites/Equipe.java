package nhl2024.entites;

import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import nhl2024.exceptions.*;
import nhl2024.utils.*;
/**
 *
 * @author Bruno Theoret
 */
public class Equipe {
    private Integer id;
    private String nom;
    private String ville;
    private double masseSalariale;
    private static final AtomicInteger count = new AtomicInteger(0);
    private int nombreMatchesJoues;

    private  ArrayList<Joueur> joueurs;
    private  ArrayList<Gardien> gardiens;
    private  ArrayList<Entraineur> entraineurs;
    
    private static double BUDGET_MAX_EQUIPE = 30000000;
    private static int GARDIENS_MAX_EQUIPE = 2;
    private static int ENTRAINEUR_MAX_EQUIPE = 2;
    private static int JOUEURS_MAX_EQUIPE = 8;

    public Equipe(String nom, String ville) {
        this.nom = nom;
        this.ville = ville;
        this.masseSalariale = 0;
        this.nombreMatchesJoues = 0;
        this.id = count.incrementAndGet();
        this.joueurs = new ArrayList<Joueur>();
        this.gardiens = new ArrayList<Gardien>();
        this.entraineurs = new ArrayList<Entraineur>();
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public double getMasseSalariale() {
        return masseSalariale;
    }

    public void setMasseSalariale(double masseSalariale) {
        this.masseSalariale = masseSalariale;
    }

    public int getNombreMatchesJoues() {
        return nombreMatchesJoues;
    }

    public void setNombreMatchesJoues(int nombreMatchesJoues) {
        this.nombreMatchesJoues = nombreMatchesJoues;
    }

    public ArrayList<Joueur> getJoueurs() {

        return joueurs;
    }

    public ArrayList<Gardien> getGardiens() {

        return gardiens;
    }

    public void setGardiens(ArrayList<Gardien> gardiens) {
        this.gardiens = gardiens;
    }

    public ArrayList<Entraineur> getEntraineurs() {
        return entraineurs;
    }

    public Integer getId(){
        return this.id;
    }

    @Override
    public String toString() {
        return "Equipe{" + "id=" + id + ", nom=" + nom + ", ville=" + ville + '}';
    }
    
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipe other = (Equipe) obj;
        if (!Objects.equals(this.nom, other.nom)) {
            return false;
        }
        return Objects.equals(this.ville, other.ville);
    }
    
    // fonctions utilitaires (gestion des personnes)
    public void ajouterPersonne(Personne p) throws NullArgumentException, JoueurExisteDejaException, BudgetEquipeMaxAtteintException, NombreGardiensMaxAtteintException, NombreJoueursMaxAtteintException {
        if(p == null) throw new NullArgumentException("Equipe.ajouterPersonne: Veuillez passer un parametre a personne");
        if(p instanceof Joueur){
            Joueur j = (Joueur)p;
            if (joueurs.contains(j)) throw new JoueurExisteDejaException("Le joueur " + j.getNomComplet() + " existe deja dans l'equipe " + getNom());
            if ((this.getMasseSalariale() + j.getSalaire()) > BUDGET_MAX_EQUIPE) throw new BudgetEquipeMaxAtteintException("On ne peut engager " + j.getNomComplet() + "la masse salariale de l'equipe est depassee");
            if(joueurs.size() >= JOUEURS_MAX_EQUIPE) throw new NombreJoueursMaxAtteintException("Vous ne pouvez engager " + j.getNomComplet() + " le nombre maximum de gardiens est deja atteint");
            joueurs.add(j);
            setMasseSalariale(this.masseSalariale + j.getSalaire());
        } else if(p instanceof Gardien){
            Gardien g = (Gardien)p;
            if (gardiens.contains(g)) throw new JoueurExisteDejaException("Le gardien " + g.getNomComplet() + " existe deja dans l'equipe " + getNom());
            if ((getMasseSalariale() + g.getSalaire()) > BUDGET_MAX_EQUIPE) throw new BudgetEquipeMaxAtteintException("On ne peut engager " + g.getNomComplet() + "la masse salariale de l'equipe est depassee");
            if(gardiens.size() >= GARDIENS_MAX_EQUIPE) throw new NombreGardiensMaxAtteintException("Vous ne pouvez engager " + g.getNomComplet() + " le nombre maximum de gardiens est deja atteint");
            gardiens.add(g);
            setMasseSalariale(this.masseSalariale + g.getSalaire());
        } else if(p instanceof Entraineur) {
                Entraineur e = (Entraineur) p;
                if (entraineurs.contains(e)) throw new JoueurExisteDejaException("L'entraineur " + e.getNomComplet() + " existe deja dans l'equipe " + getNom());
                if ((getMasseSalariale() + e.getSalaire()) > BUDGET_MAX_EQUIPE) throw new BudgetEquipeMaxAtteintException("On ne peut engager " + e.getNomComplet() + "la masse salariale de l'equipe est depassee");
                entraineurs.add(e);
                setMasseSalariale(this.masseSalariale + e.getSalaire());
        }
   }
    
    public void enleverPersonne(Personne p) throws NullArgumentException, JoueurNonExistantException {
        if(p == null) throw new NullArgumentException("Equipe.enleverPersonne: Veuillez passer un parametre a personne");
        if(p instanceof Joueur){
            Joueur j = (Joueur)p;
            if(!joueurs.contains(j)) throw new JoueurNonExistantException("Le joueur " + j.getNomComplet() + "n'existe pas dans l'equipe");
            joueurs.remove(j);
        }

    }

    public ArrayList<Personne> getPersonnel() throws NullArgumentException {
        ArrayList<Personne> personnel = new ArrayList<Personne>();
        personnel.addAll(joueurs);
        personnel.addAll(gardiens);
        personnel.addAll(entraineurs);
        return personnel;
    }

    public void incrementerMatchesJoues() {
        this.nombreMatchesJoues += 1;
    }
}
