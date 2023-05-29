package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.StatsJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.*;

import java.util.ArrayList;

public interface InterfaceStats {

    public void addStats(String pseudo , StatsJoueur s) throws MissingArgumentException, WrongStatsException, JoueurNotFoundException;

    public ArrayList<StatsJoueur> getStats(String pseudo , int idStat) throws MissingArgumentException, JoueurNotFoundException, StatsNotFoundException;

    public ArrayList<StatsJoueur> getAllStats(String pseudo) throws MissingArgumentException, JoueurNotFoundException, StatsNotFoundException;

}
