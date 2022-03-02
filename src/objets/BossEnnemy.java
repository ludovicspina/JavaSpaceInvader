package objets;

import game.Game;

import java.awt.*;

public class BossEnnemy extends GameObject {
    public BossEnnemy(float x, float y, ID id){
        super(x, y, id);
        velX = 3;
        velY = 0;
    }

    @Override
    public void tick(){
        x += velX;
        y += velY;
        if(Game.neSorsPasSalo((int)x, 0, Game.WIDTH - 40)){
            velX *= -1;
        }
        if(Game.neSorsPasSalo((int)y, 0, Game.HEIGHT - 40)){
            velY *= -1;
        }
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.pink);
        g.fillRect((int)x, (int)y, 40, 40);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }


}
