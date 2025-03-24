package nhl2024.services;

import java.util.ArrayList;
import nhl2024.entites.Equipe;
import nhl2024.exceptions.EquipeExisteDejaException;
import nhl2024.exceptions.EquipeNonExistanteException;
import nhl2024.exceptions.NombreEquipeMaxAtteinteException;
import nhl2024.exceptions.ArgumentInvalideException;

/**
 *
 * @author Bruno Theoret
 */
public class EquipeManager {
    
    private final int NB_MAX_EQUIPES = 3;
    
    private ArrayList<Equipe> equipes;
    
    public EquipeManager(){

        this.equipes = new ArrayList<>();
    }
    
    public void ajouterEquipe(Equipe e) throws NombreEquipeMaxAtteinteException, EquipeExisteDejaException, EquipeNonExistanteException {
        if(equipes.size() > NB_MAX_EQUIPES) throw new NombreEquipeMaxAtteinteException("Impossible d'ajouter l'equipe " + e.getNom() + ", nombre d'equipes maximal atteint.");
        
        if(equipes.indexOf(e) > 0) throw new EquipeExisteDejaException("L'equipe " + e.getNom() + " existe deja dans la ligue");
        
        equipes.add(e);
    }
    
    public void fermerEquipe(Equipe e) throws EquipeNonExistanteException {
        if(!equipes.contains(e)) throw new EquipeNonExistanteException("L'equipe " + e.getNom() + " n'existe pas dans la ligue");
        equipes.remove(e);
    }
    
    public  Equipe getEquipe(Equipe e) throws ArgumentInvalideException, EquipeNonExistanteException {
        //if(e ==  null) throw new ArgumentInvalideException("L'equipe doit etre fournie en parametre");
        if(equipes.indexOf(e) < 0) throw new EquipeNonExistanteException("L'equipe n'existe pas");
        
        return e;
    }
    
    public Equipe getEquipeParId(Integer id) throws ArgumentInvalideException{
        if(id == null) throw new ArgumentInvalideException("Le id doit etre fourni en parametre");
        
        for( Equipe e : equipes){
            if(e.getId() == id){
                return e;
            }
        }
        return null;
    }

    public Equipe getEquipeParNom(String nom) throws ArgumentInvalideException, EquipeNonExistanteException {
        if(nom == null) throw new ArgumentInvalideException("Le nom doit etre fourni en parametre");

        for( Equipe e : equipes){
            if(e.getNom().equalsIgnoreCase(nom)){
                return e;
            } else {
                throw new EquipeNonExistanteException("Aucun resultat d'equipe retourne pour le nom: " + nom);
            }
        }
        return null;
    }
    
    public ArrayList<Equipe> getEquipes(){
        return this.equipes;
    }
    
  
}
