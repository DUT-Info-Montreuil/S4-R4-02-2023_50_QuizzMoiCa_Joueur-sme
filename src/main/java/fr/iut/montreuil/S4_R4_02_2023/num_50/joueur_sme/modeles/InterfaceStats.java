package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.StatsJoueur;

import java.util.ArrayList;

public interface InterfaceStats {

    public void addStats(String pseudo , StatsJoueur s);

    public ArrayList<StatsJoueur> getStats(String pseudo);

}
