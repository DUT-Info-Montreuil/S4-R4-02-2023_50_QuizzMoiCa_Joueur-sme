package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.impl;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock.*;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.enums.Langues;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class TestJoueur {

    InterfaceJoueur joueurService;

    @BeforeEach
    public void inti(){
        joueurService = new JoueurSI();
    }

    @Test
    public void TesterAnnéeNaissance() throws DuplicatedPseudoException, MissingArgumentException, WrongArgumentException {
        JoueurDTO joueurAttendu = new JoueurDTO();
        joueurAttendu.setAnneeNaissance(2000);

        //joueurService = new AjouterAnneeMock();

        Assertions.assertEquals(joueurAttendu.getAnneeNaissance(), joueurService.creerJoueur("pseudo1", "prenom1", 2000, "hobbies", 1).getAnneeNaissance());

        //joueurService = new WrongAnneeMock();

        Assertions.assertThrows(WrongAnneesException.class, () -> {
            joueurService.creerJoueur("pseudo2", "prenom2", 2022, "hobbies", 1);
        });

    }

    @Test
    public void TestLangue() throws DuplicatedPseudoException, MissingArgumentException, WrongArgumentException {
        JoueurDTO JoueurAttendu = new JoueurDTO();
        JoueurAttendu.setLangue(Langues.FRANCAIS);

        //joueurService= new AjouterLangueMock();

        Assertions.assertEquals(JoueurAttendu.getLangue(), joueurService.creerJoueur("pseudo3", "prenom3", 2000, "hobbies", 0).getLangue());

        //joueurService = new WrongLangueMock();

        Assertions.assertThrows(WrongLanguageException.class, () -> {
            joueurService.creerJoueur("pseudo4", "prenom4", 2000, "hobbies", 6);
        });


    }


    @Test
    public void TestHobbies() throws DuplicatedPseudoException, MissingArgumentException, WrongArgumentException {
        JoueurDTO JoueurAttendu = new JoueurDTO();
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("hobbie1");
        hobbies.add("hobbie2");
        JoueurAttendu.setHobbies(hobbies);
        //joueurService = new AjouterHobbiesMock();
        Assertions.assertEquals(JoueurAttendu.getHobbies(), joueurService.creerJoueur("pseudo5", "prenom5", 2000, "hobbie1,hobbie2", 1).getHobbies());

        //joueurService = new WrongHobbiesMock();
        Assertions.assertThrows(MissingArgumentException.class, () -> {
            joueurService.creerJoueur("pseudo6", "prenom6", 2000, null, 4);
        });

        Assertions.assertThrows(WrongListeHobbiesException.class , () ->{
            joueurService.creerJoueur("pseudo7", "prenom7", 2000, "hobbie1,   ,hobbie2", 4);
        });


    }


    @Test
    public  void TestDuplicatePseaudo() throws DuplicatedPseudoException, MissingArgumentException, WrongArgumentException {
        JoueurDTO JoueurAttendu = new JoueurDTO();
        JoueurAttendu.setPseudo("pseudo");
        //joueurService = new AjouterPseudoMock();
        Assertions.assertEquals(JoueurAttendu.getPseudo(), joueurService.creerJoueur("pseudo", "prenom8", 2000, "hobbies", 1).getPseudo());

        //joueurService = new WrongPseudoMock();

        Assertions.assertThrows(DuplicatedPseudoException.class, () -> {
            joueurService.creerJoueur("pseudo", "prenom9", 2000, "hobbies", 1);
        });


    }


    @Test
    public void TestPrenom() throws DuplicatedPseudoException, MissingArgumentException, WrongArgumentException {
        JoueurDTO JoueurAttendu = new JoueurDTO();
        JoueurAttendu.setPrenom("prenom10");
        //joueurService = new AjouterPrenomMock();
        Assertions.assertEquals(JoueurAttendu.getPrenom(), joueurService.creerJoueur("pseudo10", "prenom10", 2000, "hobbies", 1).getPrenom());

        //joueurService = new WrongPrenomMock();

        Assertions.assertThrows(MissingArgumentException.class, () -> {
            joueurService.creerJoueur("pseudo11", " ", 2000, "hobbies", 1);
        });

    }


}
