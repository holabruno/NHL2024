package nhl2024.services;

import java.util.ArrayList;
import nhl2024.entites.Entraineur;
import nhl2024.entites.Gardien;
import nhl2024.entites.Joueur;
import nhl2024.entites.Personne;
import nhl2024.exceptions.ArgumentInvalideException;
import nhl2024.exceptions.JoueurExisteDejaException;
import nhl2024.exceptions.JoueurNonExistantException;

/**
 *
 * @author Bruno Theoret
 */
public class PersonneManager {
    
    private final int NB_MAX_JOUEURS = 24; // 6 joueurs maximum par equipe
    private final int NB_MAX_GARDIENS = 8;
    private static ArrayList<Joueur> joueurs; // les joueurs dans la ligue (maximum 4 equipes)
    private static ArrayList<Gardien> gardiens; // les gardiens dans la ligue
    private static ArrayList<Entraineur> entraineurs; // les entraineurs dans la ligue
    
    public PersonneManager() {
        this.joueurs = new ArrayList<Joueur>();
        this.gardiens = new ArrayList<Gardien>();
        this.entraineurs = new ArrayList<Entraineur>();
    }
    
    // Gestion des joueurs et entraineurs dans la ligue
    public void recruterPersonne(Personne p) throws JoueurExisteDejaException{
        if(p instanceof Joueur){
            if(joueurs.indexOf((Joueur)p) >= 0) throw new JoueurExisteDejaException("Le joueur " + p.getNomComplet() + " existe deja dans la ligue"); 
            joueurs.add((Joueur)p);
        } else if(p instanceof Gardien){
            if(gardiens.indexOf((Gardien)p) >= 0) throw new JoueurExisteDejaException("Le gardien " + p.getNomComplet() + " existe deja dans la ligue"); 
            gardiens.add((Gardien)p);
        } else if(p instanceof Entraineur){
            if(entraineurs.indexOf((Entraineur)p) >= 0) throw new JoueurExisteDejaException("L'entraineur " + p.getNomComplet() + " existe deja dans la ligue");
            entraineurs.add((Entraineur)p);
        }
    }
    
    public ArrayList<Joueur> getJoueurs(){
        return joueurs;
    }
    public ArrayList<Gardien> getGardiens(){
        return gardiens;
    }
    public ArrayList<Entraineur> getEntraineurs(){
        return entraineurs;
    }
    
    public Personne getPersonne(Personne p) throws ArgumentInvalideException, JoueurNonExistantException {
        if(p == null) throw new ArgumentInvalideException("Vous devez fournir un joueur, gardien ou entraineur");
        
        if(p instanceof Joueur){
            Joueur j = (Joueur)p;
            if(!joueurs.contains(j)) throw new JoueurNonExistantException("Le joueur " + j.getNomComplet() + " n'est pas dans la ligue");
            return joueurs.get(joueurs.indexOf(j));
        } else if(p instanceof Gardien) {
            Gardien g = (Gardien)p;
            if(!gardiens.contains(g)) throw new JoueurNonExistantException("Le gardien " + g.getNomComplet() + " n'est pas dans la ligue");
        } else if(p instanceof Entraineur) {
            Entraineur e = (Entraineur)p;
            if(entraineurs.indexOf(e) == -1) throw new JoueurNonExistantException("L'entraineur " + e.getNomComplet() + " n'est pas dans la ligue");
        }  else {
            return null;
        }
        return null;
    }
    
    public Joueur getJoueurParId(Integer id) throws ArgumentInvalideException {
        if(id == null) throw new ArgumentInvalideException("Le id doit etre fourni en parametre");
        
      for(Joueur j : joueurs){
           if(j.getId() == id){
               return j;
           }
       }
       return null;
    }

    public Gardien getGardienParId(Integer id) throws ArgumentInvalideException {
        if(id == null) throw new ArgumentInvalideException("Le id doit etre fourni en parametre");

        for(Gardien g : gardiens){
            if(g.getId() == id){
                return g;
            }
        }
        return null;
    }

    public Entraineur getEntraineurParId(Integer id) throws ArgumentInvalideException {
        if(id == null) throw new ArgumentInvalideException("Le id doit etre fourni en parametre");

        for(Entraineur e : entraineurs){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }
}
