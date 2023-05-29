package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.StatsJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceStats;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.JoueurNotFoundException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.MissingArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.StatsNotFoundException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongStatsException;

import java.util.ArrayList;

public class MissingArgumentStatsMock implements InterfaceStats {
    @Override
    public void addStats(String pseudo, StatsJoueur s) throws MissingArgumentException, WrongStatsException, JoueurNotFoundException {
        throw new MissingArgumentException("Missing argument");
    }

    @Override
    public ArrayList<StatsJoueur> getStats(String pseudo, int idStat) throws MissingArgumentException, JoueurNotFoundException, StatsNotFoundException {
        throw new MissingArgumentException("Missing argument");
    }

    @Override
    public ArrayList<StatsJoueur> getAllStats(String pseudo) throws MissingArgumentException, JoueurNotFoundException, StatsNotFoundException {
        throw new MissingArgumentException("Missing argument");
    }
}
