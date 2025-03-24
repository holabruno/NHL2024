package nhl2024.utils;

import java.util.List;

import nhl2024.entites.*;
import nhl2024.exceptions.NullArgumentException;

/**
 *
 * @author Bruno Theoret
 */
public class helper {
    
    public static void imprimerListe(List<?> liste, boolean blnImprimerStats) throws NullArgumentException{
        if(liste == null) throw new NullArgumentException("La liste est vide");

        if(!blnImprimerStats){
            for( Object item: liste){
                System.out.println(item);
            }
        } else { // imprimer les statistiques avec le joueur
            for (Object item : liste) {
                System.out.println(item);

                if (item instanceof Joueur) {
                    Joueur joueur = (Joueur) item;

                   StatistiquesOffensives offensiveStats = joueur.getStatistiquesOffensives();
                    if (offensiveStats != null &&
                            (offensiveStats.getButs() != 0 || offensiveStats.getPasses() != 0 || offensiveStats.getPoints() != 0 || offensiveStats.getTirs() != 0)) {
                        System.out.println("  " + offensiveStats);
                    }

                    StatistiquesDefensives defensiveStats = joueur.getStatistiquesDefensives();
                    if (defensiveStats != null &&
                            (defensiveStats.getPlusMoins() != 0 || defensiveStats.getBlocs() != 0 || defensiveStats.getInterceptions() != 0)) {
                        System.out.println("  " + defensiveStats);
                    }

                }
                if (item instanceof Gardien) {
                    Gardien gardien = (Gardien) item;

                    StatistiquesGardien statsGardien = gardien.getStatsGardien();
                    if (statsGardien != null &&
                            (statsGardien.getArrets() != 0 || statsGardien.getButsEncaisses() != 0 || statsGardien.getMoyenneButsAlloues() != 0 || statsGardien.getBlanchissage() != 0)) {
                        System.out.println("  " + statsGardien);
                    }
                }
            } // end for
        } // end else (imprimer stats joueur)
    }
}
