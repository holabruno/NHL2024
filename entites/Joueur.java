package nhl2024.entites;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Bruno Theoret
 */
public class Joueur extends Personne {

    private Integer id; // utiliser integer parce que int ne peut etre assigne null
    private double salaire;

    protected StatistiquesOffensives statsOffensives;
    protected StatistiquesDefensives statsDefensives;
    protected StatistiquesOffensives statsOffensivesSaison;
    protected StatistiquesDefensives statsDefensivesSaison;

    private static final AtomicInteger count = new AtomicInteger(0);
    
    public Joueur(String prenom, String nom, double salaire) {
        super(prenom, nom);
        this.salaire = salaire;
        this.id = count.incrementAndGet();
        this.statsDefensives = new StatistiquesDefensives(0,0,0);
        this.statsOffensives = new StatistiquesOffensives(0,0,0, 0);
        this.statsDefensivesSaison = new StatistiquesDefensives(0,0,0);
        this.statsOffensivesSaison = new StatistiquesOffensives(0,0,0, 0);

    }



    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Integer getId(){
        return this.id;
    }

    public StatistiquesOffensives getStatistiquesOffensives() {
        return statsOffensives;
    }

    public void setStatistiquesOffensives(StatistiquesOffensives statistiquesOffensives) {
        this.statsOffensives = statistiquesOffensives;
    }

    public StatistiquesDefensives getStatistiquesDefensives() {
        return statsDefensives;
    }

    public void setStatistiquesDefensives(StatistiquesDefensives statistiquesDefensives) {
        this.statsDefensives = statistiquesDefensives;
    }

    @Override
    public String toString() {
        return "Joueur{" + "id=" + id + " " + super.toString() + "salaire=" + salaire + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Joueur joueur = (Joueur) o;
        return Double.compare(joueur.salaire, salaire) == 0 && 
               Objects.equals(getPrenom(), joueur.getPrenom()) && 
               Objects.equals(getNom(), joueur.getNom());
    }
}
