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
        board.StartMatch("Mexico", "Canada");
        assertEquals(0, board.matches.get(0).homeScore);
        assertEquals(0, board.matches.get(0).awayScore);
    }

    @Test
    @DisplayName("Update score")
    void updateScore() {
        ScoreBoard board = new ScoreBoard();
        board.StartMatch("Mexico", "Canada");
        board.UpdateScore(2,1,0);
        assertEquals(2, board.matches.get(0).homeScore);
        assertEquals(1, board.matches.get(0).awayScore);
    }

    @Test
    @DisplayName("remove match from scoreboard")
    void finishMatch() {
        ScoreBoard board = new ScoreBoard();
        board.StartMatch("Mexico", "Canada");
        board.StartMatch("Spain", "Brazil");
        Match secondMatch = board.matches.get(1);
        board.FinishMatch(0);
        assertEquals(secondMatch,board.matches.get(0));

    }

    @Test
    @DisplayName("Display matches")
    void summary() {
        ScoreBoard board = new ScoreBoard();
        board.StartMatch("Mexico", "Canada");
        board.StartMatch("Spain", "Brazil");
        board.StartMatch("Germany", "France");
        board.StartMatch("Uruguay", "Italy");
        board.StartMatch("Argentina", "Australia");

        board.UpdateScore(0,5,0);
        board.UpdateScore(10,2,1);
        board.UpdateScore(2,2,2);
        board.UpdateScore(6,6,3);
        board.UpdateScore(3,1,4);

        board.Summary();

        Vector<String> listOfMatches = new Vector<String>();
        listOfMatches.add("Uruguay 6 - Italy 6");
        listOfMatches.add("Spain 10 - Brazil 2");
        listOfMatches.add("Mexico 0 - Canada 5");
        listOfMatches.add("Argentina 3 - Australia 1");
        listOfMatches.add("Germany 2 - France 2");

        assertEquals(listOfMatches, board.Summary());


    }
}