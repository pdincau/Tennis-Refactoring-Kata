import formatter.ScoreFormatter;


public class TennisGame1 implements TennisGame {

    private Player firstPlayer;
    private Player secondPlayer;
    private ScoreFormatter scoreFormatter;

    public TennisGame1(String firstPlayerName, String secondPlayerName) {
        this(new Player(firstPlayerName), new Player(secondPlayerName), new ScoreFormatter());
    }

    public TennisGame1(Player firstPlayer, Player secondPlayer, ScoreFormatter scoreFormatter) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.scoreFormatter = scoreFormatter;
    }

    public void wonPoint(String name) {
        if (firstPlayer.hasName(name)) {
            firstPlayer.score();
        }
        if (secondPlayer.hasName(name)) {
            secondPlayer.score();
        }
    }

    public String getScore() {
        if (isTie()) {
            return scoreFormatter.formatTie(firstPlayer.getScore());
        }
        if (isWonOrInAdvantage()) {
            return scoreFormatter.formatWinOrAdvantage(firstPlayer.getScore(), secondPlayer.getScore());
        } else {
            String score = "";
            int tempScore=0;
            for (int i=1; i<3; i++)
            {
                if (i==1) tempScore = firstPlayer.getScore();
                else { score+="-"; tempScore = secondPlayer.getScore();}
                switch(tempScore)
                {
                    case 0:
                        score+="Love";
                        break;
                    case 1:
                        score+="Fifteen";
                        break;
                    case 2:
                        score+="Thirty";
                        break;
                    case 3:
                        score+="Forty";
                        break;
                }
            }
            return score;
        }
    }

    private boolean isTie() {
        return firstPlayer.hasSameScoreOf(secondPlayer);
    }

    private boolean isWonOrInAdvantage() {
        return firstPlayer.getScore() >= 4 || secondPlayer.getScore() >= 4;
    }
}
