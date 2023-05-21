package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.DuplicatedPseudoException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.MissingArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongArgumentException;

import java.util.ArrayList;

public class AjouterPseudo implements InterfaceJoueur {

    ArrayList<JoueurDTO> allJoueur = new ArrayList<JoueurDTO>();

    @Override
    public JoueurDTO creerJoueur(String pseudo, String prenom, int anneeNaissance, String hobbies, int numLangue) throws MissingArgumentException, DuplicatedPseudoException, WrongArgumentException {
        if (pseudo == null || pseudo.isEmpty()) {
            throw new MissingArgumentException("Le pseudo est manquant");
        }
        if (pseudo.length() < 3 || pseudo.length() > 20) {
            throw new WrongArgumentException("Le pseudo doit contenir entre 3 et 20 caractères");
        }

        for (JoueurDTO joueurDTO :allJoueur) {
            if (joueurDTO.getPseudo().equals(pseudo)) {
                throw new DuplicatedPseudoException("Le pseudo est déjà utilisé");
            }
        }

        if(pseudo.trim().length() <= 1 ){
            throw new WrongArgumentException("Le pseudo ne peut pas être vide");
        }


        JoueurDTO joueurDTO = new JoueurDTO();
        joueurDTO.setPseudo(pseudo);
        allJoueur.add(joueurDTO);
        return joueurDTO;
    }
}
