package game;

import java.awt.*;

public class Help {
    private Handler handler;

    public void tick() {}

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        Font fnt3 = new Font("arial", Font.BOLD, 25);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("HELP", 245, 60);
        g.setFont(fnt3);
        g.drawString("Utilisez Z Q S D pour vous déplacer", 100, 100 );
        g.drawString("et P pour mettre pause", 170, 130 );
        g.setFont(fnt2);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Retour", 260, 190);
        if (Spawn.difficultyLevel == 1) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }
        g.drawRect(1, 1, Game.WIDTH - 2, Game.HEIGHT - 2);
        g.setColor(Color.white);

    }
}
