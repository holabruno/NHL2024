package nhl2024;

import nhl2024.controleurs.LigueControleur;
import nhl2024.controleurs.SaisonManager;
import nhl2024.entites.Equipe;
import nhl2024.entites.Gardien;
import nhl2024.entites.Joueur;
import nhl2024.exceptions.*;
import nhl2024.seed.*;

import java.util.ArrayList;


/**
 *
 * @author Bruno Theoret
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ArgumentInvalideException, EquipeNonExistanteException, NullArgumentException, JoueurNonExistantException {
       LigueControleur lnh = LigueControleur.getInstance();

        SaisonManager smc = SaisonManager.getInstance();

       //Creation des joueurs, entraineurs, gardiens et equipes dans la ligue

        CreerPersonnes.joueur();
        CreerPersonnes.gardien();
        CreerPersonnes.entraineur(lnh);
        CreerConcessions.equipe(lnh);
       
       //Construire les equipes

        // Joueurs des Canadiens
       Joueur j1 = LigueControleur.getPersonneManager().getJoueurParId(1); // TODO: pourquoi ca fonctionne plutot que lnh.getPersonneManager() ?
       Joueur j2 = LigueControleur.getPersonneManager().getJoueurParId(2);
       Joueur j3 = LigueControleur.getPersonneManager().getJoueurParId(3);
       Joueur j4 = LigueControleur.getPersonneManager().getJoueurParId(4);
       Joueur j5 = LigueControleur.getPersonneManager().getJoueurParId(5);
       Gardien g1 = LigueControleur.getPersonneManager().getGardienParId(1);

       Equipe e1 = LigueControleur.getEquipeManager().getEquipeParNom("Canadiens");
       Equipe e2 = LigueControleur.getEquipeManager().getEquipeParId(2);
       
       try{
            LigueControleur.ajouterPersonneEquipe(j1, e1);
            LigueControleur.ajouterPersonneEquipe(j2, e1);
            LigueControleur.ajouterPersonneEquipe(j3, e1);
            LigueControleur.ajouterPersonneEquipe(j4, e1);
            LigueControleur.ajouterPersonneEquipe(j5, e1);
            LigueControleur.ajouterPersonneEquipe(g1, e1);

       } catch(BudgetEquipeMaxAtteintException ex){
           System.out.println(ex.getMessage());
       } catch(JoueurExisteDejaException ex){
           System.out.println(ex.getMessage());
       } catch(JoueurNonExistantException ex){
           System.out.println(ex.getMessage());
       } catch(EquipeNonExistanteException ex){
           System.out.println(ex.getMessage());
       } catch(ArgumentInvalideException ex){
           System.out.println(ex.getMessage());
       } catch(NullArgumentException ex){
           System.out.println(ex.getMessage());
       } catch(NombreGardiensMaxAtteintException ex){
           System.out.println(ex.getMessage());
       } catch(NombreJoueursMaxAtteintException ex){
           System.out.println(ex.getMessage());
       }


       System.out.println("\n###Liste des equipes, joueurs et entraineurs dans la LNH:");
       try{
            nhl2024.utils.helper.imprimerListe(lnh.getEquipes(), false);
            nhl2024.utils.helper.imprimerListe(lnh.getJoueurs(), false);
            nhl2024.utils.helper.imprimerListe(lnh.getGardiens(), false);
            nhl2024.utils.helper.imprimerListe(lnh.getEntraineurs(), false);

       } catch (NullArgumentException ex){
           System.out.println(ex.getMessage());
       }

       //lnh.fermerEquipe(e2);
       System.out.println("\nCanadiens AVANT de congedier joueur j5");
       nhl2024.utils.helper.imprimerListe(lnh.getPersonnelParEquipe(e1), false);
       lnh.congedierPersonneEquipe(j5, e1);

       j1.getStatistiquesOffensives().setButs(2);
       j1.getStatistiquesOffensives().setPasses(3);
       j1.getStatistiquesDefensives().setInterceptions(1);
       g1.getStatsGardien().setArrets(5);
       System.out.println("\nCanadiens APRES de congedier joueur j5 (avec statistiques joueurs)");
       nhl2024.utils.helper.imprimerListe(lnh.getPersonnelParEquipe(e1), true);

       System.out.println("\nSimuler un match...");
       ArrayList<Equipe> equipesMatch = new ArrayList<Equipe>();
        try {
           equipesMatch = smc.getMatchManager().choisirEquipesPourMatch();
       } catch(NombreEquipesEligiblesPourMatchInsuffisantException ex) {
           System.out.println(ex.getMessage());
       }

       nhl2024.utils.helper.imprimerListe(equipesMatch, false);

    }
}
