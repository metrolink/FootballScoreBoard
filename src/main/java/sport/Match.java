package sport;

public class Match {
    String homeTeam;
    int homeScore;
    String awayTeam;
    int awayScore;

    public Match(){

    }

    public Match(String home, String away){
        homeTeam = home;
        homeScore = 0;
        awayTeam = away;
        awayScore = 0;
    }

    public Match(String hTeam, int hScore, String aTeam, int aScore){
        homeTeam = hTeam;
        homeScore = hScore;
        awayTeam = aTeam;
        awayScore = aScore;
    }

    void updateScore(int home, int away){
        homeScore = home;
        awayScore = away;
    }
}
