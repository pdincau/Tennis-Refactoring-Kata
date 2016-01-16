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
        String score = "";
        int tempScore=0;
        if (firstPlayer.hasSameScoreOf(secondPlayer)) {
            score = scoreFormatter.formatTie(firstPlayer.getScore());
        }
        else if (firstPlayer.getScore()>=4 || secondPlayer.getScore()>=4)
        {
            int minusResult = firstPlayer.getScore()-secondPlayer.getScore();
            if (minusResult==1) score ="Advantage player1";
            else if (minusResult ==-1) score ="Advantage player2";
            else if (minusResult>=2) score = "Win for player1";
            else score ="Win for player2";
        }
        else
        {
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
        }
        return score;
    }
}
