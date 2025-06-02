package sport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Vector;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    @Test
    @DisplayName("Start a new match and put it in the scoreboard")
    void startMatch() {
        ScoreBoard board = new ScoreBoard();
        board.startMatch("Mexico", "Canada");
        assertEquals(0, board.matches.get(0).homeScore);
        assertEquals(0, board.matches.get(0).awayScore);
    }

    @Test
    @DisplayName("Update score")
    void updateScore() {
        ScoreBoard board = new ScoreBoard();
        board.startMatch("Mexico", "Canada");
        board.updateScore(2,1,0);
        assertEquals(2, board.matches.get(0).homeScore);
        assertEquals(1, board.matches.get(0).awayScore);
    }

    @Test
    @DisplayName("remove match from scoreboard")
    void finishMatch() {
        ScoreBoard board = new ScoreBoard();
        board.startMatch("Mexico", "Canada");
        board.startMatch("Spain", "Brazil");
        Match secondMatch = board.matches.get(1);
        board.finishMatch(0);
        assertEquals(secondMatch,board.matches.get(0));

    }

    @Test
    @DisplayName("Display matches")
    void summary() {
        ScoreBoard board = new ScoreBoard();
        board.startMatch("Mexico", "Canada");
        board.startMatch("Spain", "Brazil");
        board.startMatch("Germany", "France");
        board.startMatch("Uruguay", "Italy");
        board.startMatch("Argentina", "Australia");

        board.updateScore(0,5,0);
        board.updateScore(10,2,1);
        board.updateScore(2,2,2);
        board.updateScore(6,6,3);
        board.updateScore(3,1,4);

        Vector<String> listOfMatches = new Vector<String>();
        listOfMatches.add("Uruguay 6 - Italy 6");
        listOfMatches.add("Spain 10 - Brazil 2");
        listOfMatches.add("Mexico 0 - Canada 5");
        listOfMatches.add("Argentina 3 - Australia 1");
        listOfMatches.add("Germany 2 - France 2");

        assertEquals(listOfMatches, board.summary());


    }
}