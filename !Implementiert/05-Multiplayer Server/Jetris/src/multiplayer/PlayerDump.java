package multiplayer;

import java.io.Serializable;

/**
 * Created by chris on 07.04.16.
 */
public class PlayerDump implements Serializable {
    protected String name;
    protected int score;
    protected int level;

    public PlayerDump(String name) {
        this.name = name;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getLevel() {
        return level;
    }

    //setters
    public void setName(String name) {
        this.name = name;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //override
    @Override
    public String toString() {
        return "Player: " + name + ", Score: " + score + ", Level: " + level;
    }
}
