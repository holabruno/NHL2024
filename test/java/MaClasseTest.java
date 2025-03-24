package nhl2024.test.java;

import nhl2024.controleurs.LigueControleur;
import nhl2024.entites.Equipe;
import nhl2024.entites.Joueur;
import nhl2024.exceptions.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MaClasseTest {

    @Test
    void testAddition() {
        int result = 2 + 3;
        assertEquals(5, result);
    }

    @Test
    void testMultiplication() {
        int result = 2 * 3;
        assertEquals(6, result);
    }

    @Test
    void creerJoueurAJouterALigueEtEquipe() throws JoueurExisteDejaException, ArgumentInvalideException, BudgetEquipeMaxAtteintException, NombreGardiensMaxAtteintException, NullArgumentException, JoueurNonExistantException, EquipeNonExistanteException, NombreJoueursMaxAtteintException, NombreEquipeMaxAtteinteException, EquipeExisteDejaException {
        //LigueControleur lnh = LigueControleur.getInstance();
        Equipe ch = new Equipe("Canadiens", "Montreal");
        Joueur c = new Joueur("Nick", "Suzuki",6000000);
        LigueControleur.recruterPersonne(c);
        LigueControleur.ajouterEquipe(ch);
        LigueControleur.ajouterPersonneEquipe(c, ch);
        assertEquals(c, LigueControleur.getPersonnelParEquipe(ch).get(0)); // getFirst() ne fonctionne pas
    }


}