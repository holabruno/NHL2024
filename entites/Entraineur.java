package nhl2024.entites;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author Bruno Theoret
 */
public class Entraineur extends Personne {
    private Integer id; // utiliser integer parce que int ne peut etre assigne null
    private double salaire;
    private double bonus;
    private static final AtomicInteger count = new AtomicInteger(0);
    
    public Entraineur(String prenom, String nom, double salaire, double bonus) {
        super(prenom, nom);
        this.salaire = salaire;
        this.id = count.incrementAndGet();
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }
    
    public Integer getId(){
        return this.id;
    }
    
    @Override
    public String toString() {
        return "Entraineur{" + "id=" + id + " " + super.toString() + "salaire=" + salaire + '}';
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Entraineur joueur = (Entraineur) o;
        return Double.compare(joueur.salaire, salaire) == 0 && 
               Objects.equals(getPrenom(), joueur.getPrenom()) && 
               Objects.equals(getNom(), joueur.getNom()) &&
               Objects.equals(getBonus(), joueur.getBonus());
    }
    
}
