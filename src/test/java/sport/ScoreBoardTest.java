package sport;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ScoreBoardTest {

    @Test
    @DisplayName("Start a new match and put it in the scoreboard")
    void startMatch() {
        ScoreBoard board = new ScoreBoard();
        board.StartMatch("Mexico", "Canada");
        assertEquals(0, board.Matches.get(0).homeScore);
        assertEquals(0, board.Matches.get(0).awayScore);
    }

    @Test
    void updateScore() {
        ScoreBoard board = new ScoreBoard();
        board.StartMatch("Mexico", "Canada");
        board.UpdateScore(2,1,0);
        assertEquals(2, board.Matches.get(0).homeScore);
        assertEquals(1, board.Matches.get(0).awayScore);
    }

    @Test
    void finishMatch() {
        ScoreBoard board = new ScoreBoard();
        board.StartMatch("Mexico", "Canada");
        board.StartMatch("Spain", "Brazil");
        board.FinishMatch(0);
        assertEquals("Spain",board.Matches.get(0).homeTeam);

    }

    @Test
    void summary() {
    }
}