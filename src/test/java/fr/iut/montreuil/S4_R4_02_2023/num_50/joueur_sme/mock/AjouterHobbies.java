package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.DuplicatedPseudoException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.MissingArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongListeHobbiesException;

import java.util.ArrayList;

public class AjouterHobbies implements InterfaceJoueur {
    @Override
    public JoueurDTO creerJoueur(String pseudo, String prenom, int anneeNaissance, String hobbies, int numLangue) throws MissingArgumentException, DuplicatedPseudoException, WrongArgumentException {

        if(hobbies == null){
            throw new WrongListeHobbiesException("les hobbies ne doivent pas etre null");
        }
        //split hobbies into the hobbiesArray as a ArrayList
        ArrayList<String> hobbiesArray  = new ArrayList<String>();
        String[] hobbiesArrayString = hobbies.split(",");
        for (int i = 0; i < hobbiesArrayString.length; i++) {
            hobbiesArray.add(hobbiesArrayString[i].trim());
        }

        for (int i = 0; i < hobbiesArray.size(); i++) {
            System.out.println(hobbiesArray.get(i) + " " + i);
        }
        if (hobbiesArray.size() < 1) {
            throw new WrongListeHobbiesException("les hobbies ne doivent pas etre null");
        }
        for (String hobby : hobbiesArray) {
            if (hobby.length() < 1) {
                throw new WrongListeHobbiesException("les hobbies ne doivent pas etre null");
            }
        }
        JoueurDTO joueurDTO = new JoueurDTO();
        joueurDTO.setHobbies(hobbiesArray);
        return joueurDTO ;
    }
}
