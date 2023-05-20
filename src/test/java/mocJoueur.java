import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.enums.Langues;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.*;

import java.util.List;

public class mocJoueur {

    private String pseudo;
    private String prenom;
    private int anneeNaissance;
    private List<String> hobbies;
    private Langues langue;
    private int score;


    public mocJoueur(){

    }

    public static void  wrongAnnee() throws WrongAnneesException {
        throw new WrongAnneesException("L'année de naissance doit être comprise entre 1900 et 2020");
    }

    //make a static fonction for each custom error witch return the error object

    public static void duplicatePsuedo() throws DuplicatedPseudoException {
        throw new DuplicatedPseudoException("Le pseudo est déjà utilisé");
    }

    public static void missingArgument() throws MissingArgumentException {
        throw new MissingArgumentException("Il manque un argument");
    }

    public static void wrongArgument() throws WrongArgumentException {
        throw new WrongArgumentException("L'argument est incorrect");
    }

    public static void wrongLangue() throws WrongLanguageException {
        throw new WrongLanguageException("La langue est incorrect");
    }

    public static void wrongHobbies() throws WrongListeHobbiesException {
        throw new WrongListeHobbiesException("Les hobbies sont incorrects");
    }

    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }

    public void setHobbies(List<String> hobbies) {
        this.hobbies = hobbies;
    }

    public void setLangue(Langues langue) {
        this.langue = langue;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getPseudo() {
        return pseudo;
    }

    public String getPrenom() {
        return prenom;
    }

    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public Langues getLangue() {
        return langue;
    }

    public int getScore() {
        return score;
    }
}
