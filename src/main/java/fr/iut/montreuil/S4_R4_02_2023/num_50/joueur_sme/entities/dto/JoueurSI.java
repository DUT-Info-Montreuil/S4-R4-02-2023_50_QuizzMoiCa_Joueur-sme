package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.enums.Langues;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.*;

import java.util.List;

public class JoueurSI implements InterfaceJoueur {
    List<JoueurDTO> joueurDTOS;

    public List<JoueurDTO> getJoueurDTOS() {
        return joueurDTOS;
    }


    @Override
    public JoueurDTO creerJoueur(String pseudo, String prenom, int anneeNaissance, String hobbies, int numLangue) throws MissingArgumentException, WrongArgumentException, DuplicatedPseudoException {
        if(pseudo.equals("")){
            throw new MissingArgumentException("empty pseudo");
        }
        else if(prenom.equals("")){
            throw new MissingArgumentException("empty prenom");
        }
        else if(hobbies.equals("")){
            throw new MissingArgumentException("empty hobbies");
        }
        List<String> pseudoList = joueurDTOS.stream().map(JoueurDTO::getPseudo).toList();
        if(pseudoList.contains(pseudo)){
            throw new DuplicatedPseudoException("pseudo already exists");
        }
        try{
            if(anneeNaissance<1900 || anneeNaissance>2021){
                throw new WrongAnneesException("anneeNaissance must be between 1900 and 2021");
            }
        }catch (NumberFormatException e){
            throw new WrongAnneesException("anneeNaissance must be an integer");
        }
        List<String> hobbiesList = List.of(hobbies.split(","));

        if(hobbiesList.size()<3){
            throw new WrongListeHobbiesException("hobbies must be at least 3");
        }
        else if(hobbiesList.contains("")){
            throw new WrongListeHobbiesException("hobbies must not be empty");
        }
        try {
            if (numLangue < 0 || numLangue > 4) {
                throw new WrongLanguageException("numLangue must be between 0 and 4");
            }
        }catch (NumberFormatException e){
            throw new WrongAnneesException("numLangue must be an integer");
        }

        JoueurDTO joueurDTO = new JoueurDTO(pseudo, prenom, anneeNaissance, hobbiesList, Langues.values()[numLangue], 0);
        joueurDTOS.add(joueurDTO);
        return joueurDTO;
    }
}
