package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.DuplicatedPseudoException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.MissingArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongArgumentException;

import java.util.ArrayList;

public class AjouterHobbiesMock implements InterfaceJoueur {
    @Override
    public JoueurDTO creerJoueur(String pseudo, String prenom, int anneeNaissance, String hobbies, int numLangue) throws MissingArgumentException, DuplicatedPseudoException, WrongArgumentException {
        ArrayList<String> hobbiesArray  = new ArrayList<String>();
        String[] hobbiesArrayString = hobbies.split(",");
        for (int i = 0; i < hobbiesArrayString.length; i++) {
            hobbiesArray.add(hobbiesArrayString[i]);
        }

        JoueurDTO joueurDTO = new JoueurDTO();
        joueurDTO.setHobbies(hobbiesArray);
        return joueurDTO ;
    }
}
