package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.impl;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock.*;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.enums.Langues;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestJoueur {

    @Test
    public void TesterAnnéeNaissance() throws DuplicatedPseudoException, MissingArgumentException, WrongArgumentException {
        JoueurDTO joueurAttendu = new JoueurDTO();
        joueurAttendu.setAnneeNaissance(2000);
        AjouterAnnee ajouterAnnee = new AjouterAnnee();
        Assertions.assertEquals(joueurAttendu.getAnneeNaissance(), ajouterAnnee.creerJoueur("pseudo", "prenom", 2000, "hobbies", 1).getAnneeNaissance());

        WrongAnnee wrongAnnee = new WrongAnnee();
        Assertions.assertThrows(WrongAnneesException.class, () -> {
            wrongAnnee.creerJoueur("pseudo", "prenom", 2022, "hobbies", 1);
        });

    }

    @Test
    public void TestLangue() throws DuplicatedPseudoException, MissingArgumentException, WrongArgumentException {
        JoueurDTO JoueurAttendu = new JoueurDTO();
        JoueurAttendu.setLangue(Langues.FRANCAIS);
        AjouterLangue ajouterLangue = new AjouterLangue();
        Assertions.assertEquals(JoueurAttendu.getLangue(), ajouterLangue.creerJoueur("pseudo", "prenom", 2000, "hobbies", 0).getLangue());

        WrongLangue wrongLangue = new WrongLangue();

        Assertions.assertThrows(WrongLanguageException.class, () -> {
            wrongLangue.creerJoueur("pseudo", "prenom", 2000, "hobbies", 6);
        });


    }


    @Test
    public void TestHobbies() throws DuplicatedPseudoException, MissingArgumentException, WrongArgumentException {
        JoueurDTO JoueurAttendu = new JoueurDTO();
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("hobbie1");
        hobbies.add("hobbie2");
        JoueurAttendu.setHobbies(hobbies);
        AjouterHobbies ajouterHobbies = new AjouterHobbies();
        Assertions.assertEquals(JoueurAttendu.getHobbies(), ajouterHobbies.creerJoueur("pseudo", "prenom", 2000, "hobbie1,hobbie2", 1).getHobbies());

        WrongHobbies wrongHobbies = new WrongHobbies();
        Assertions.assertThrows(WrongListeHobbiesException.class, () -> {
            wrongHobbies.creerJoueur("pseudo", "prenom", 2000, null, 4);
        });

        Assertions.assertThrows(WrongListeHobbiesException.class , () ->{
            wrongHobbies.creerJoueur("pseudo", "prenom", 2000, "hobbie1,   ,hobbie2", 4);
        });


    }


    @Test
    public  void TestDuplicatePseaudo() throws DuplicatedPseudoException, MissingArgumentException, WrongArgumentException {
        JoueurDTO JoueurAttendu = new JoueurDTO();
        JoueurAttendu.setPseudo("pseudo");
        AjouterPseudo ajouterPseudo = new AjouterPseudo();
        Assertions.assertEquals(JoueurAttendu.getPseudo(), ajouterPseudo.creerJoueur("pseudo", "prenom", 2000, "hobbies", 1).getPseudo());

        WrongPseudo wrongPseudo = new WrongPseudo();

        Assertions.assertThrows(DuplicatedPseudoException.class, () -> {
            wrongPseudo.creerJoueur("pseudo", "prenom", 2000, "hobbies", 1);
        });


    }


    @Test
    public void TestPrenom() throws DuplicatedPseudoException, MissingArgumentException, WrongArgumentException {
        JoueurDTO JoueurAttendu = new JoueurDTO();
        JoueurAttendu.setPrenom("prenom");
        AjouterPrenom ajouterPrenom = new AjouterPrenom();
        Assertions.assertEquals(JoueurAttendu.getPrenom(), ajouterPrenom.creerJoueur("pseudo", "prenom", 2000, "hobbies", 1).getPrenom());

        WrongPrenom wrongPrenom = new WrongPrenom();

        Assertions.assertThrows(WrongArgumentException.class, () -> {
            wrongPrenom.creerJoueur("pseudo", " ", 2000, "hobbies", 1);
        });

    }


}
