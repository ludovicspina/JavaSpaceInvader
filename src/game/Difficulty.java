package game;

import java.awt.*;

public class Difficulty {
    private Handler handler;

    public void tick() {
    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Facile", 280, 190);
        g.drawRect(210, 250, 200, 64);
        g.drawString("Difficile", 280, 290);
    }
}
