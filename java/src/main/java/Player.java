
public class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public boolean hasName(String name) {
        return getName().equals(name);
    }

    public int getScore() {
        return score;
    }

    public void score() {
        score += 1;
    }

    public boolean hasSameScoreOf(Player otherPlayer) {
        return getScore() == otherPlayer.getScore();
    }

}
