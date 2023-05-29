package fr.iut.montreuil.S4_R4_02_2023.num_50.joueur_sme.entities.dto;

public class StatsJoueur {
        int idStat ;
        int nbGoodAnswer;
        String timePlayed;

        String averageTimePerQuestion;

        public StatsJoueur(int idStat, int nbGoodAnswer, String timePlayed, String averageTimePerQuestion) {
            this.idStat = idStat;
            this.nbGoodAnswer = nbGoodAnswer;
            this.timePlayed = timePlayed;
            this.averageTimePerQuestion = averageTimePerQuestion;
        }

        public StatsJoueur() {

        }

        public int getIdStat() {
                return idStat;
        }

        public int getNbGoodAnswer() {
                return nbGoodAnswer;
        }

        public String getTimePlayed() {
                return timePlayed;
        }

        public String getAverageTimePerQuestion() {
                return averageTimePerQuestion;
        }
}
