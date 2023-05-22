package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.DuplicatedPseudoException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.MissingArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongLanguageException;

public class WrongLangue implements InterfaceJoueur {
    @Override
    public JoueurDTO creerJoueur(String pseudo, String prenom, int anneeNaissance, String hobbies, int numLangue) throws MissingArgumentException, DuplicatedPseudoException, WrongArgumentException {
        throw new WrongLanguageException("wrong Langue");
    }
}
