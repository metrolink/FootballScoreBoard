# Live Football World Cup Score Board

## Scoreboard:
### Functions:
* void startMatch(String home, String away)
  * Creates an instance of a Match and adds it to the scoreboard.
* Match updateScore(int home, int away, int matchNumber)
  * Updates the score for the selected match. It only accepts a pair of absolute scores
* void finishMatch(int matchNumber)
  * This removes the selected match from the scoreboard
* Vector< String > summary()
  * Creates a list of matches in progress and their score, ordered by their total score.

## Match
### Constructors:
* Match()
  * empty constructor for matches
* Match(String home, String away)
  * Creates a match object with specified home and away teams. It is assumed that the score is 0-0
* Match(String hTeam, int hScore, String aTeam, int aScore)
  * Creates a match object with the specified home and away team, and with the specified score for each team
### Functions: 
* String getHomeTeam()
  * gets home team
* int getHomeScore()
  * gets home score
* getAwayTeam()
  * gets away team
* getAwayScore()
  * gets away score
* setHomeScore(int homeScore)
  * sets home score
* setAwayScore(int awayScore)
  * sets away score

## Assumptions and discussion
I am adding an additional parameter to both updateScore and finishMatch to specify which match needs to be updated. 
This is because I assume that the scoreboard has ownership of the functions, according to the assignment, and needs to know which match it needs to change.

I also assume that the match list is not long enough for the sort time (O(n^2)) to become a problem. And for a simple solution, bubble sort is good enough.

