
public class TennisGame1 implements TennisGame {

    private Player firstPlayer;
    private Player secondPlayer;

    public TennisGame1(String firstPlayerName, String secondPlayerName) {
        this.firstPlayer = new Player(firstPlayerName);
        this.secondPlayer = new Player(secondPlayerName);
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
            score = formatTieScore(firstPlayer.getScore());
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

    private String formatTieScore(int score) {
        String formattedScore = "";
        switch (score)
        {
            case 0:
                formattedScore = "Love-All";
                break;
            case 1:
                formattedScore = "Fifteen-All";
                break;
            case 2:
                formattedScore = "Thirty-All";
                break;
            default:
                formattedScore = "Deuce";
                break; 
        }
        return formattedScore;
    }
}
