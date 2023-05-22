package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.enums.Langues;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.DuplicatedPseudoException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.MissingArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongLanguageException;

public class AjouterLangue implements InterfaceJoueur {
    @Override
    public JoueurDTO creerJoueur(String pseudo, String prenom, int anneeNaissance, String hobbies, int numLangue) throws MissingArgumentException, DuplicatedPseudoException, WrongArgumentException {
        JoueurDTO joueurDTO = new JoueurDTO();
        switch (numLangue){
            case 0:
                joueurDTO.setLangue(Langues.FRANCAIS);
                break;
            case 1:
                joueurDTO.setLangue(Langues.ENGLISH);
                break;
            case 2:
                joueurDTO.setLangue(Langues.DEUTCH);

                break;
            case 3:
                joueurDTO.setLangue(Langues.ESPANA);
                break;
            case 4:
                joueurDTO.setLangue(Langues.ITALIA);
                break;
        }
        return joueurDTO;
    }
}
