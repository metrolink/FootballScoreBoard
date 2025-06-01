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
    Match UpdateScore(int home, int away, int matchNumber){
        Match updatedMatch = matches.get(matchNumber);
        updatedMatch.homeScore = home;
        updatedMatch.awayScore = away;
        return updatedMatch;
    }
    void FinishMatch(int matchNumber){
        Match finishedMatch = matches.get(matchNumber);
        matches.remove(finishedMatch);
    }
    Vector<String> Summary(){
        Vector<Match> sortedMatches = matchSort(matches);
        Vector<String> listOfResults = new Vector<String>();
        for (Match m : sortedMatches){
            String result = m.homeTeam + " " + m.homeScore + " - " + m.awayTeam + " " + m.awayScore;
            listOfResults.add(result);
        }
        return listOfResults;
    }

    Vector<Match> matchSort(Vector<Match> listOfMatches){

        int matchLength = listOfMatches.size();

        for (int i = 0; i < matchLength -1; i++){
            int minPos = i;

            for (int j = i+1; j < matchLength; j++){
                int totalScoreFirst = listOfMatches.get(j).homeScore + listOfMatches.get(j).awayScore;
                int totalScoreSecond = listOfMatches.get(minPos).homeScore + listOfMatches.get(minPos).awayScore;
                if(totalScoreFirst > totalScoreSecond){
                    minPos = j;
                }


            }

            Match temp = listOfMatches.get(i);
            listOfMatches.set(i, listOfMatches.get(minPos));
            listOfMatches.set(minPos,temp);
        }
        return listOfMatches;
    }
}
