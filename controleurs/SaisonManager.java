package nhl2024.controleurs;

import nhl2024.services.MatchManager;

public class SaisonManager {
    //implemente le pattern singleton

    private static SaisonManager instance;

    protected MatchManager matchManager = new MatchManager();

    public static SaisonManager getInstance() {
        if (instance == null) {
            instance = new SaisonManager();
        }
        return instance;
    }

    public MatchManager getMatchManager() {

        return matchManager;
    }

    /********************/
   /* fonctions metier */
   /********************/


}
