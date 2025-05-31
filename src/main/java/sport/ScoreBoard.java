package sport;

import java.util.Vector;
import sport.Match;

public class ScoreBoard {
    Vector<Match> matches = new Vector<Match>();

    void StartMatch(String home, String away){
        Match game = new Match();
        game.homeScore = 0;
        game.homeTeam = home;
        game.awayScore = 0;
        game.awayTeam = away;
        matches.add(game);
    }
    void UpdateScore(int home, int away, int match){
        Match updatingMatch = matches.get(match);
        updatingMatch.homeScore = home;
        updatingMatch.awayScore = away;
    }
    void FinishMatch(int match){}
    void Summary(){
    }
}
