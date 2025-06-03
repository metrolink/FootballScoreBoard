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
        Vector<Match> currentMatches = matches;
        Vector<Match> sortedMatches = matchSort(currentMatches);
        Vector<String> listOfResults = new Vector<String>();
        for (Match m : sortedMatches) {
            String result = m.homeTeam + " " + m.homeScore + " - " + m.awayTeam + " " + m.awayScore;
            listOfResults.add(result);
        }
        return listOfResults;
    }

    private Vector<Match> matchSort(Vector<Match> listOfMatches) {
        Vector<Match> preOrderedList = listOfMatches;
        //Bubble sort
        int matchLength = listOfMatches.size();
        for (int i = 0; i < matchLength - 1; i++) {
            for (int j = 0; j < matchLength - i - 1; j++) {
                Match compareFirst = listOfMatches.get(j);
                Match compareSecond = listOfMatches.get(j+1);
                int totalScoreFirst = compareFirst.homeScore + compareFirst.awayScore;
                int totalScoreSecond = compareSecond.homeScore + compareSecond.awayScore;
                if (totalScoreFirst <= totalScoreSecond) {
                    listOfMatches.setElementAt(compareSecond,j);
                    listOfMatches.setElementAt(compareFirst, j+1);
                }
            }
        }

        sortFirst(listOfMatches, preOrderedList);
        return listOfMatches;
    }

    private Vector<Match> sortFirst(Vector<Match> matchList, Vector<Match> originalList){
            Match compareFirst = matchList.get(0);
            Match compareSecond = matchList.get(1);
            int totalScoreFirst = compareFirst.homeScore + compareFirst.awayScore;
            int totalScoreSecond = compareSecond.homeScore + compareSecond.awayScore;
            if (    totalScoreFirst == totalScoreSecond &&
                    originalList.indexOf(compareFirst) < originalList.indexOf(compareSecond)) {
                matchList.setElementAt(compareSecond,0);
                matchList.setElementAt(compareFirst, 1);
            }
        return matchList;
    }
}

