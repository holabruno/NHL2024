package nhl2024.seed;

import java.util.logging.Level;
import java.util.logging.Logger;
import nhl2024.controleurs.LigueControleur;
import nhl2024.entites.Equipe;
import nhl2024.exceptions.EquipeExisteDejaException;
import nhl2024.exceptions.EquipeNonExistanteException;
import nhl2024.exceptions.NombreEquipeMaxAtteinteException;
import nhl2024.exceptions.ArgumentInvalideException;
/**
 *
 * @author Bruno Theoret
 */
public class CreerConcessions {
    
    public static void equipe(LigueControleur lc) {
        Equipe ch = new Equipe("Canadiens", "Montreal");
        Equipe mda = new Equipe("Mighty Ducks", "Anaheim");
        Equipe rwd = new Equipe("Red Wings", "Detroit");
        Equipe avc = new Equipe("Avalanche", "Colorado");
        Equipe bb = new Equipe("Bruins", "Boston");
        

        try {
                lc.ajouterEquipe(ch);
                lc.ajouterEquipe(mda);
                lc.ajouterEquipe(rwd);
                lc.ajouterEquipe(avc);
                lc.ajouterEquipe(bb);
        } catch (NombreEquipeMaxAtteinteException ex) {
            System.out.println(ex.getMessage());
        } catch (EquipeExisteDejaException ex) {
            System.out.println(ex.getMessage());
        } catch (EquipeNonExistanteException ex) {
            System.out.println(ex.getMessage());
        } catch(ArgumentInvalideException ex){
            System.out.println(ex.getMessage());
        }
        
        
    }    
}
