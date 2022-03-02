package game;

import java.awt.*;

public class Pause {

    private Handler handler;

    public void tick() {}

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 50);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("PAUSE", 245, 60);
    }
}
