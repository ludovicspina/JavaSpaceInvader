package game;

import java.awt.*;

public class Health {
    public static int HEALTH = 100;
    private int greenValue = 200;
    private int redValue = 0;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    private int score = 0;
    private int level = 0;
    public void tick(){

        HEALTH = Game.neSorsPasDeLecran(HEALTH, 0, 100);
        greenValue = Game.neSorsPasDeLecran(greenValue, 0, 255);
        greenValue = HEALTH * 2;
        redValue = 200 - HEALTH * 2;

        score += 1;

    }
    public void render(Graphics g){
        g.setColor(Color.gray);
        g.fillRect(15, 15, 200, 32);
        g.setColor(new Color(redValue, greenValue, 0));
        g.fillRect(15, 15, HEALTH*2, 32);
        g.drawRect(15, 50, 75, 30);
        g.drawString("Score : " + score, 20, 65);
        g.drawString("Level : " + level, 20, 75);


    }
}
