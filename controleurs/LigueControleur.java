package nhl2024.controleurs;

import java.util.ArrayList;

import nhl2024.entites.Entraineur;
import nhl2024.entites.Equipe;
import nhl2024.entites.Gardien;
import nhl2024.entites.Joueur;
import nhl2024.entites.Personne;
import nhl2024.exceptions.*;
import nhl2024.services.EquipeManager;
import nhl2024.services.PersonneManager;

public class LigueControleur {
    //implemente le pattern singleton
    
    private static LigueControleur instance;
    
    protected static final EquipeManager equipeManager = new EquipeManager(); // si protected, pas accessible de main avec Joueur j1 = lnh.personneManager.getJoueurParId(1);
    protected static final PersonneManager personneManager = new PersonneManager();
    
    public static LigueControleur getInstance() {
        if(instance == null){
            instance = new LigueControleur();
        }
        return instance;
    }

    public static EquipeManager getEquipeManager() {
        return equipeManager;
    }

    public static PersonneManager getPersonneManager() {
        return personneManager;
    }

    // Gestion des equipes
    public static void ajouterEquipe(Equipe e) throws NombreEquipeMaxAtteinteException, EquipeExisteDejaException, EquipeNonExistanteException, ArgumentInvalideException{
        equipeManager.ajouterEquipe(e);
    }
    
    public static void fermerEquipe(Equipe e) throws EquipeNonExistanteException{
        equipeManager.fermerEquipe(e);
    }
    
    public static ArrayList<Equipe> getEquipes() {
        return equipeManager.getEquipes();
    }

    /************************************/
    // Gestion des personnes par equipe //
    /************************************/
    public static void echangerPersonneEquipe(Personne p, Equipe equipeSrc, Equipe equipeDest){
        // TODO:
    }
    
    public static void ajouterPersonneEquipe(Personne p, Equipe e) throws BudgetEquipeMaxAtteintException, ArgumentInvalideException, JoueurExisteDejaException, JoueurNonExistantException, EquipeNonExistanteException, NullArgumentException, NombreGardiensMaxAtteintException, NombreJoueursMaxAtteintException {
        Personne personne = personneManager.getPersonne(p);
        System.out.println("LigueControleur.ajouterPersonneEquipe() " + personne); // TODO: fix -> l'entraineur? est null ???
        Equipe equipe = equipeManager.getEquipe(e);
        equipe.ajouterPersonne(p);
    }
    
    public static void congedierPersonneEquipe(Personne p, Equipe e) throws ArgumentInvalideException, EquipeNonExistanteException, JoueurNonExistantException, NullArgumentException {
        Personne personne = personneManager.getPersonne(p);
        Equipe equipe = equipeManager.getEquipe(e);
        equipe.enleverPersonne(p);
    }

    public static ArrayList<Personne> getPersonnelParEquipe(Equipe e) throws ArgumentInvalideException, EquipeNonExistanteException, NullArgumentException {
        if(e == null) throw new ArgumentInvalideException("Vous devez fournir une equipe pour lister les joueurs pour cette equipe");
        Equipe equipe =  equipeManager.getEquipe(e);
        return equipe.getPersonnel();
    }
    
    // Gestion des personnes dans la ligue
    public static void recruterPersonne(Personne p) throws JoueurExisteDejaException {
        personneManager.recruterPersonne(p);
    }

    public ArrayList<Joueur> getJoueurs() {
        return personneManager.getJoueurs();
    } // joueurs dans la ligue

    public ArrayList<Gardien> getGardiens(){
        return personneManager.getGardiens();
    } // gardiens dans la ligue
    
    public ArrayList<Entraineur> getEntraineurs(){
        return personneManager.getEntraineurs();
    } // entraineurs dans la ligue
}
