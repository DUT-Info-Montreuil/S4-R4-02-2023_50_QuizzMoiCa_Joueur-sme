package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.impl;

import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto.StatsJoueur;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock.AjouterStatsMock;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock.MissingArgumentStatsMock;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock.NotFoundPseudoMock;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.mock.WrongStatsMock;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.modeles.InterfaceStats;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.JoueurNotFoundException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.MissingArgumentException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.StatsNotFoundException;
import fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.utils.exceptions.WrongStatsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class TestStats {
    InterfaceStats statsService;
    @BeforeEach
    public void init(){
        //statsService = new blabla;
    }

    @Test
    public void testAddStats() throws MissingArgumentException, WrongStatsException, JoueurNotFoundException, StatsNotFoundException {
        statsService = new AjouterStatsMock();
        ArrayList<StatsJoueur> stats = new ArrayList<>();
        stats.add(new StatsJoueur(1, 1, "00:00:00", "00:00:00"));
        statsService.addStats("pseudo1", stats.get(0));
        Assertions.assertEquals(stats, statsService.getAllStats("pseudo1"));
        Assertions.assertEquals(stats, statsService.getStats("pseudo1", 1));

        statsService = new NotFoundPseudoMock();
        Assertions.assertThrows(JoueurNotFoundException.class, () -> statsService.addStats("pseudo2", stats.get(0)));
        Assertions.assertThrows(JoueurNotFoundException.class, () -> statsService.getStats("pseudo2", 1));
        Assertions.assertThrows(JoueurNotFoundException.class, () -> statsService.getAllStats("pseudo2"));

        statsService = new WrongStatsMock();
        Assertions.assertThrows(WrongStatsException.class, () -> statsService.addStats("pseudo1", new StatsJoueur(-1, 1, "00:00:00", "00:00:00")));
        Assertions.assertThrows(WrongStatsException.class, () -> statsService.addStats("pseudo1", new StatsJoueur(1, -1, "00:00:00", "00:00:00")));
        Assertions.assertThrows(WrongStatsException.class, () -> statsService.addStats("pseudo1", new StatsJoueur(1, 1, null, "00:00:00")));
        Assertions.assertThrows(WrongStatsException.class, () -> statsService.addStats("pseudo1", new StatsJoueur(1, 1, "00:00:00", null)));
        Assertions.assertThrows(StatsNotFoundException.class, () -> statsService.getStats("pseudo1", 1));
        Assertions.assertThrows(StatsNotFoundException.class, () -> statsService.getAllStats("pseudo2"));

        statsService = new MissingArgumentStatsMock();
        Assertions.assertThrows(MissingArgumentException.class, () -> statsService.addStats("pseudo1", null));
        Assertions.assertThrows(MissingArgumentException.class, () -> statsService.addStats(null, new StatsJoueur()));
        Assertions.assertThrows(MissingArgumentException.class, () -> statsService.getAllStats(null));
        Assertions.assertThrows(MissingArgumentException.class, () -> statsService.getStats(null, 1));
        //Assertions.assertThrows(MissingArgumentException.class, () -> statsService.getStats("pseudo1", null));
    }
}
