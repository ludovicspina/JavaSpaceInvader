package objets;

import game.Game;

import java.awt.*;

public class FastEnemy extends GameObject{
    public FastEnemy(float x, float y, ID id){
        super(x, y, id);
        velX = 10;
        velY = 10;
    }

    @Override
    public void tick(){
        x += velX;
        y += velY;
        if(Game.neSorsPasSalo((int)x, 0, Game.WIDTH - 16)){
            velX *= -1;
        }
        if(Game.neSorsPasSalo((int)y, 0, Game.HEIGHT - 16)){
            velY *= -1;
        }
    }
    @Override
    public void render(Graphics g) {
        g.setColor(Color.black);
        g.fillRect((int)x, (int)y, 16, 16);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }
}
