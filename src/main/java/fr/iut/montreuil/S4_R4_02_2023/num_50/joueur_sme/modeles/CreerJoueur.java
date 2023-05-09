package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.JoueurDTO;

public interface CreerJoueur {
    public JoueurDTO creerJoueur(String pseudo, String prenom, int anneeNaissance, String hobbies, int numLangue);
}
