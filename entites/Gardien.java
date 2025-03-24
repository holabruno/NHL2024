package nhl2024.entites;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Bruno Theoret
 */
public class Gardien extends Personne{
    
    private static final AtomicInteger count = new AtomicInteger(0);
    Integer id;
    private double salaire;

    protected StatistiquesGardien statsGardien;

    public Gardien(String prenom, String nom, double salaire) {
        super(prenom, nom);
        this.salaire = salaire;
        this.id = count.incrementAndGet();
        this.statsGardien = new StatistiquesGardien(0,0,0,0,0, 0);
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public Integer getId() {
        return id;
    }

    public StatistiquesGardien getStatsGardien() {
        return statsGardien;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gardien gardien = (Gardien) o;
        return Double.compare(gardien.salaire, salaire) == 0 &&
                Objects.equals(getPrenom(), gardien.getPrenom()) &&
                Objects.equals(getNom(), gardien.getNom());
    }

    @Override
    public String toString() {
        return "Gardien{" + "id: " + this.id + " " + super.toString() + "salaire=" + salaire + '}';
    }
}
