package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.JoueurDTO;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.StatsJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceStats;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.JoueurNotFoundException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.MissingArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.StatsNotFoundException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongStatsException;

import java.util.ArrayList;

public class AjouterStatsMock implements InterfaceStats {
    JoueurDTO joueurDTO = new JoueurDTO();
    @Override
    public void addStats(String pseudo, StatsJoueur s) throws MissingArgumentException, WrongStatsException, JoueurNotFoundException {
        joueurDTO.setPseudo(pseudo);
        joueurDTO.addStats(s);
    }

    @Override
    public ArrayList<StatsJoueur> getStats(String pseudo, int idStat) throws MissingArgumentException, JoueurNotFoundException, StatsNotFoundException {
        return joueurDTO.getAllStats().stream().filter(statsJoueur -> statsJoueur.getIdStat() == idStat).collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
    }

    @Override
    public ArrayList<StatsJoueur> getAllStats(String pseudo) throws MissingArgumentException, JoueurNotFoundException, StatsNotFoundException {
        return joueurDTO.getAllStats();
    }
}
