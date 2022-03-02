package objets;

import game.Game;

import java.awt.*;

public class ProjBossEnnemy extends GameObject {
    public ProjBossEnnemy(float x, float y, ID id) {
        super(x, y, id);
        velX = 0;
        velY = -6;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect((int) x, (int) y, 6, 6);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle((int) x, (int) y, 16, 16);
    }
}
