package sport;

import java.util.Vector;
import sport.Match;

public class ScoreBoard {
    Vector<Match> matches = new Vector<Match>();

    void StartMatch(String home, String away) {
        Match game = new Match(home,away);
        matches.add(game);
    }

    Match UpdateScore(int home, int away, int matchNumber) {
        Match updateMatch = matches.get(matchNumber);
        updateMatch.updateScore(home,away);
        return updateMatch;
    }

    void FinishMatch(int matchNumber) {
        Match finishedMatch = matches.get(matchNumber);
        matches.remove(finishedMatch);
    }

    Vector<String> Summary() {
        Vector<Match> sortedMatches = matchSort(matches);
        Vector<String> listOfResults = new Vector<String>();
        for (Match m : sortedMatches) {
            String result = m.homeTeam + " " + m.homeScore + " - " + m.awayTeam + " " + m.awayScore;
            listOfResults.add(result);
        }
        return listOfResults;
    }

    Vector<Match> matchSort(Vector<Match> listOfMatches) {
        Vector<Match> originalList = listOfMatches;
        //Bubble sort
        int matchLength = listOfMatches.size();
        for (int i = 0; i < matchLength - 1; i++) {
            for (int j = 0; j < matchLength - i - 1; j++) {
                Match compareFirst = listOfMatches.get(j);
                Match compareSecond = listOfMatches.get(j+1);
                int totalScoreFirst = compareFirst.homeScore + compareFirst.awayScore;
                int totalScoreSecond = compareSecond.homeScore + compareSecond.awayScore;
                if (totalScoreFirst < totalScoreSecond) {
                    Match temp = listOfMatches.get(j);
                    listOfMatches.setElementAt(listOfMatches.get(j + 1),j);
                    listOfMatches.setElementAt(temp, j+1);
                }
            }
        }
        for(int i = 0; i < matchLength - 1; i++){
            Match compareFirst = listOfMatches.get(i);
            Match compareSecond = listOfMatches.get(i+1);
            int totalScoreFirst = compareFirst.homeScore + compareFirst.awayScore;
            int totalScoreSecond = compareSecond.homeScore + compareSecond.awayScore;
            if (totalScoreFirst == totalScoreSecond) {
                Match temp = listOfMatches.get(i);
                listOfMatches.setElementAt(listOfMatches.get(i + 1),i);
                listOfMatches.setElementAt(temp, i+1);
            }
        }
        return listOfMatches;
    }
}