package nhl2024.entites;

import java.time.LocalDate;

public class Match {
    private Equipe equipeVisiteurs;
    private Equipe equipeMaison;
    private LocalDate date;
    private int butsVisiteurs;
    private int butsMaison;

    private boolean estMatchEliminatoire;

    public Match(LocalDate date, Equipe equipeMaison, Equipe equipeVisiteurs, boolean estMatchEliminatoire) {
        this.equipeVisiteurs = equipeVisiteurs;
        this.equipeMaison = equipeMaison;
        this.butsVisiteurs = 0;
        this.butsMaison = 0;
        this.estMatchEliminatoire = estMatchEliminatoire;
    }
}
