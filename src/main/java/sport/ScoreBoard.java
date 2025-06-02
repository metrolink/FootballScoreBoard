package sport;

import java.util.Vector;

public class ScoreBoard {
    Vector<Match> matches = new Vector<Match>();

    void startMatch(String home, String away) {
        Match game = new Match(home,away);
        matches.add(game);
    }

    Match updateScore(int home, int away, int matchNumber) {
        Match updateMatch = matches.get(matchNumber);
        updateMatch.updateScore(home,away);
        return updateMatch;
    }

    void finishMatch(int matchNumber) {
        Match finishedMatch = matches.get(matchNumber);
        matches.remove(finishedMatch);
    }

    Vector<String> summary() {
        Vector<Match> sortedMatches = matchSort(matches);
        Vector<String> listOfResults = new Vector<String>();
        for (Match m : sortedMatches) {
            String result = m.homeTeam + " " + m.homeScore + " - " + m.awayTeam + " " + m.awayScore;
            listOfResults.add(result);
        }
        return listOfResults;
    }

    private Vector<Match> matchSort(Vector<Match> listOfMatches) {
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
        sortByStartTime(listOfMatches);
        return listOfMatches;
    }

    private Vector<Match> sortByStartTime(Vector<Match> matchList){
        Vector<Match> originalList = matchList;
        //Bubble sort
        int matchLength = matchList.size();
        for(int i = 0; i < matchLength - 1; i++){
            Match compareFirst = matchList.get(i);
            Match compareSecond = matchList.get(i+1);
            int totalScoreFirst = compareFirst.homeScore + compareFirst.awayScore;
            int totalScoreSecond = compareSecond.homeScore + compareSecond.awayScore;
            if (    totalScoreFirst == totalScoreSecond &&
                    originalList.indexOf(compareFirst) < originalList.indexOf(compareSecond)) {
                Match temp = matchList.get(i);
                matchList.setElementAt(matchList.get(i + 1),i);
                matchList.setElementAt(temp, i+1);
            }
        }
        return matchList;
    }
}

