import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.enums.Langues;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


public class TestJoueurDTO  {

    //test de la classe JoueurDTO

    @Test
    public void testAddJoueurDTO(){

        mocJoueur mocJoueur = new mocJoueur();
        mocJoueur.setPseudo("pseudo");
        mocJoueur.setPrenom("prenom");
        mocJoueur.setAnneeNaissance(2000);
        ArrayList<String> hobbies = new ArrayList<String>();
        hobbies.add("hobby1");
        mocJoueur.setHobbies(hobbies);
        mocJoueur.setLangue(Langues.FRANCAIS);
        mocJoueur.setScore(0);

        Assertions.assertEquals("pseudo", mocJoueur.getPseudo());
        Assertions.assertEquals("prenom", mocJoueur.getPrenom());
        Assertions.assertEquals(2000, mocJoueur.getAnneeNaissance());
        Assertions.assertEquals(hobbies, mocJoueur.getHobbies());
        Assertions.assertEquals(Langues.FRANCAIS, mocJoueur.getLangue());
        Assertions.assertEquals(0, mocJoueur.getScore());


    }

    @Test
    public void testmissingWrongYearsJoueurDTO(){

        Assertions.assertThrows(WrongAnneesException.class, mocJoueur::wrongAnnee);

    }

    @Test
    public void testmissingPseudoJoueurDTO(){

        Assertions.assertThrows(MissingArgumentException.class, mocJoueur::missingArgument);

    }

    @Test

    public void testDuplicatePseudo(){

        Assertions.assertThrows(DuplicatedPseudoException.class, mocJoueur::duplicatePsuedo);

    }

    @Test
    public void testWrongArgument(){

        Assertions.assertThrows(WrongArgumentException.class, mocJoueur::wrongArgument);

    }

    @Test
    public void wrongLangue(){

        Assertions.assertThrows(WrongLanguageException.class, mocJoueur::wrongLangue);

    }
    @Test
    public void wrongHobbies(){

        Assertions.assertThrows(WrongListeHobbiesException.class, mocJoueur::wrongHobbies);

    }


}
