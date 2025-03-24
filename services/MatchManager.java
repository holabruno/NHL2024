package nhl2024.services;

import nhl2024.controleurs.LigueControleur;
import nhl2024.entites.Equipe;
import nhl2024.entites.Match;
import nhl2024.entites.Saison;
import nhl2024.exceptions.ArgumentInvalideException;
import nhl2024.exceptions.EquipeNonExistanteException;
import nhl2024.exceptions.NombreMatchesJouesParSaisonAtteintException;
import nhl2024.exceptions.NullArgumentException;
import nhl2024.exceptions.NombreEquipesEligiblesPourMatchInsuffisantException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class MatchManager {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private ArrayList<Match> matches;

    private static int NOMBRE_MATCHES_MAX_SAISON = 3;
    private static int NOMBRE_MATCHES_MAX_ELIMINATOIRES = 1;

    public MatchManager(){

        this.matches = new ArrayList<>();
    }

    public ArrayList<Equipe> choisirEquipesPourMatch() throws ArgumentInvalideException, EquipeNonExistanteException, NombreEquipesEligiblesPourMatchInsuffisantException {

        ArrayList<Equipe> equipes = new ArrayList<>();
        int nombreMatchesJoues = 0;
        ArrayList<Equipe> listeEquipes = new ArrayList<Equipe>();
        ArrayList<Equipe> equipesEligibles = new ArrayList<Equipe>();

        listeEquipes = LigueControleur.getEquipeManager().getEquipes();

        for (int i = 0; i < listeEquipes.size(); i++) {
            Equipe equipe = listeEquipes.get(i);
            nombreMatchesJoues = equipe.getNombreMatchesJoues();
            if (nombreMatchesJoues < NOMBRE_MATCHES_MAX_SAISON) {
                LigueControleur.getEquipeManager().getEquipe(equipe).incrementerMatchesJoues();
                equipesEligibles.add(equipe);
            }
        }

        // random
        if(equipesEligibles.size() <2) throw new NombreEquipesEligiblesPourMatchInsuffisantException("MatchManager > choisirEquipesPourMatch() : Il n'y a pas assez d'equipes n'ayant pas termine la saison pour creer un match");

        Random rand = new Random();
        Collections.shuffle(equipesEligibles, rand);
        ArrayList<Equipe> equipesSelectionnees = new ArrayList<Equipe>();
        equipesSelectionnees.add(equipesEligibles.get(0));
        equipesSelectionnees.add(equipesEligibles.get(1));
        return equipesSelectionnees;
    }
}
