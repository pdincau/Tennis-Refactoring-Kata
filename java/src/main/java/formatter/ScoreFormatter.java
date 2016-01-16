package formatter;

public class ScoreFormatter {

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
}