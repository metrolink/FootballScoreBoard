package sport;

import java.util.Vector;
import sport.Match;

public class ScoreBoard {
    Vector<Match> Matches = new Vector<Match>();

    void StartMatch(String home, String away){
        Match game = new Match();
        game.homeScore = 0;
        game.homeTeam = home;
        game.awayScore = 0;
        game.awayTeam = away;
        Matches.add(game);
    }
    void UpdateScore(int home, int away, int match){
    }
    void FinishMatch(int match){}
    void Summary(){
    }
}
