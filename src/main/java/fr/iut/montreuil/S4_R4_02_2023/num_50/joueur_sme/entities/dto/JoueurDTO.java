package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.enums.Langues;

import java.util.Arrays;
import java.util.List;

public class JoueurDTO {
    private String pseudo;
    private String prenom;
    private int anneeNaissance;
    private List<String> hobbies;
    private Langues langue;
    private int score;

    public JoueurDTO(){

    }

    public JoueurDTO(String pseudo, String prenom, int anneeNaissance, List<String> hobbies, Langues langue, int score) {
        this.pseudo = pseudo;
        this.prenom = prenom;
        this.anneeNaissance = anneeNaissance;
        this.hobbies = hobbies;
        this.langue = langue;
        this.score = score;
    }

    public String getPseudo() {
        return pseudo;
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public void setHobbies(List<String> hobbies) {

        this.hobbies = hobbies;
    }

    public Langues getLangue() {
        return langue;
    }

    public void setLangue(Langues langue) {
        this.langue = langue;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
