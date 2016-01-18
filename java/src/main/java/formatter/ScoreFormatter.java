package formatter;

public class ScoreFormatter {

    private static final String VICTORY_SECOND_PLAYER = "Win for player2";
    private static final String VICTORY_FIRST_PLAYER = "Win for player1";
    private static final String ADVANTAGE_SECOND_PLAYER = "Advantage player2";
    private static final String ADVANTAGE_FIRST_PLAYER = "Advantage player1";
    private static final String DEUCE = "Deuce";
    private static final String THIRTY_ALL = "Thirty-All";
    private static final String FIFTEEN_ALL = "Fifteen-All";
    private static final String LOVE_ALL = "Love-All";

    public String formatTie(int score) {
        String formattedScore = "";
        switch (score) {
        case 0:
            formattedScore = LOVE_ALL;
            break;
        case 1:
            formattedScore = FIFTEEN_ALL;
            break;
        case 2:
            formattedScore = THIRTY_ALL;
            break;
        default:
            formattedScore = DEUCE;
            break; 
        }
        return formattedScore;
    }

    public String formatWinOrAdvantage(int firstPlayerScore, int secondPlayerScore) {
        String formattedScore = "";
        int scoreDifference = firstPlayerScore - secondPlayerScore;

        if (scoreDifference == 1)
            formattedScore = ADVANTAGE_FIRST_PLAYER;

        if (scoreDifference == -1)
            formattedScore = ADVANTAGE_SECOND_PLAYER;

        if (scoreDifference >= 2)
            formattedScore = VICTORY_FIRST_PLAYER;

        if (scoreDifference <= -2)
            formattedScore = VICTORY_SECOND_PLAYER;

        return formattedScore;
    }
}