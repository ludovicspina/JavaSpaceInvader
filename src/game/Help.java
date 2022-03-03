package game;

import java.awt.*;

public class Help {
    private Handler handler;

    public void tick() {}

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        Font fnt3 = new Font("arial", Font.BOLD, 16);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("HELP", 245, 60);
        g.setFont(fnt3);
        g.drawRect(16, 16, Game.WIDTH - 32, Game.HEIGHT - 32);
        g.drawString("Pour jouer il faut utiliser ZQSD connard", 160, 130 );
        g.setFont(fnt2);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Retour", 260, 190);

    }
}
