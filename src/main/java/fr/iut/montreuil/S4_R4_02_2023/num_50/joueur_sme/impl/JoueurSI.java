package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.impl;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.StatsJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceStats;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.enums.Langues;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.*;

import java.util.ArrayList;
import java.util.List;

public class JoueurSI implements InterfaceJoueur , InterfaceStats {
    List<JoueurDTO> joueurDTOS = new ArrayList<>();

    public List<JoueurDTO> getJoueurDTOS() {
        return joueurDTOS;
    }


    @Override
    public JoueurDTO creerJoueur(String pseudo, String prenom, int anneeNaissance, String hobbies, int numLangue) throws MissingArgumentException, WrongArgumentException, DuplicatedPseudoException {
        if(pseudo == null || pseudo.trim().length() < 1){
            throw new MissingArgumentException("empty pseudo");
        }
        else if (prenom == null || prenom.trim().length() < 1){
            throw new MissingArgumentException("empty prenom");
        }
        else if(hobbies == null || hobbies.trim().length() < 1){
            throw new MissingArgumentException("empty hobbies");
        }
        if (joueurDTOS == null || !joueurDTOS.isEmpty()){

            List<String> pseudoList = joueurDTOS.stream().map(JoueurDTO::getPseudo).toList();
            if(pseudoList.contains(pseudo)){
                throw new DuplicatedPseudoException("pseudo already exists");
            }
        }


        try{
            if(anneeNaissance<1900 || anneeNaissance>2021){
                throw new WrongAnneesException("anneeNaissance must be between 1900 and 2021");
            }
        }catch (NumberFormatException e){
            throw new WrongAnneesException("anneeNaissance must be an integer");
        }
        List<String> hobbiesList = List.of(hobbies.split(","));


        if(hobbiesList.size()<1){
            throw new WrongListeHobbiesException("hobbies must be at least 1");
        }
        else {
            for (String hobby : hobbiesList) {
                if(hobby.trim().length() < 1){
                    throw new WrongListeHobbiesException("hobbies contains one empty hobby");
                }
            }
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

    @Override
    public void addStats(String pseudo, StatsJoueur s) throws MissingArgumentException, WrongStatsException, JoueurNotFoundException {
        if (joueurDTOS == null || joueurDTOS.isEmpty()){
            throw new JoueurNotFoundException("pseudo not found");
        }
        if(!joueurDTOS.stream().map(JoueurDTO::getPseudo).toList().contains(pseudo)){
            throw new JoueurNotFoundException("pseudo not found");
        }

        if (s == null){
            throw new MissingArgumentException("empty stats");
        }

        /*
         int idStat ;
        int nbGoodAnswer;
        String timePlayed;

        String averageTimePerQuestion;

        here are all the stats element in the stats object
        all of theme need to be positiv and not null


         */

        if(s.getIdStat() < 0) {
            throw new WrongStatsException("idStat must be positive");
        }
        if(s.getNbGoodAnswer() < 0) {
            throw new WrongStatsException("nbGoodAnswer must be positive");
        }
        if(s.getTimePlayed() == null || s.getTimePlayed().trim().length() < 1) {
            throw new WrongStatsException("timePlayed must not be empty");
        }
        if(s.getAverageTimePerQuestion() == null || s.getAverageTimePerQuestion().trim().length() < 1) {
            throw new WrongStatsException("averageTimePerQuestion must not be empty");
        }

        JoueurDTO joueurDTO = joueurDTOS.stream().filter(joueurDTO1 -> joueurDTO1.getPseudo().equals(pseudo)).findFirst().get();

        joueurDTO.addStats(s);


    }

    @Override
    public ArrayList<StatsJoueur> getStats(String pseudo, int idStat) throws MissingArgumentException, JoueurNotFoundException, StatsNotFoundException {
        if (joueurDTOS == null || joueurDTOS.isEmpty()){
            throw new JoueurNotFoundException("pseudo not found");
        }
        if(!joueurDTOS.stream().map(JoueurDTO::getPseudo).toList().contains(pseudo)){
            throw new JoueurNotFoundException("pseudo not found");
        }

        JoueurDTO joueurDTO = joueurDTOS.stream().filter(joueurDTO1 -> joueurDTO1.getPseudo().equals(pseudo)).findFirst().get();

        if(joueurDTO.getAllStats() == null || joueurDTO.getAllStats().isEmpty()){
            throw new StatsNotFoundException("stats not found");
        }


        ArrayList<StatsJoueur> statsJoueurs = joueurDTO.getAllStats().stream().filter(statsJoueur -> statsJoueur.getIdStat() == idStat).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        return statsJoueurs;


    }

    @Override
    public ArrayList<StatsJoueur> getAllStats(String pseudo) throws MissingArgumentException, JoueurNotFoundException, StatsNotFoundException {
        if (joueurDTOS == null || joueurDTOS.isEmpty()){
            throw new JoueurNotFoundException("pseudo not found");
        }
        if(!joueurDTOS.stream().map(JoueurDTO::getPseudo).toList().contains(pseudo)){
            throw new JoueurNotFoundException("pseudo not found");
        }

        JoueurDTO joueurDTO = joueurDTOS.stream().filter(joueurDTO1 -> joueurDTO1.getPseudo().equals(pseudo)).findFirst().get();

        if(joueurDTO.getAllStats() == null || joueurDTO.getAllStats().isEmpty()){
            throw new StatsNotFoundException("stats not found");
        }


        ArrayList<StatsJoueur> statsJoueurs = joueurDTO.getAllStats();

        return statsJoueurs;
    }


}
