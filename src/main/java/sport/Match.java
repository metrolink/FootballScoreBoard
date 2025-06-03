package sport;

public class Match {
    private String homeTeam;
    private int homeScore;
    private String awayTeam;
    private int awayScore;

    public Match(){

    }

    public Match(String home, String away){
        this.homeTeam = home;
        this.homeScore = 0;
        this.awayTeam = away;
        this.awayScore = 0;
    }

    public Match(String hTeam, int hScore, String aTeam, int aScore){
        this.homeTeam = hTeam;
        this.homeScore = hScore;
        this.awayTeam = aTeam;
        this.awayScore = aScore;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public void setHomeScore(int homeScore) {
        this.homeScore = homeScore;
    }

    public void setAwayScore(int awayScore) {
        this.awayScore = awayScore;
    }


}
