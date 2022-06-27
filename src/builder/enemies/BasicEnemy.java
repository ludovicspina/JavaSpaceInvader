package builder.enemies;

import game.Game;
import objets.GameObject;
import objets.ID;

import java.awt.*;

public class BasicEnemy extends GameObject {

    public BasicEnemy(float x, float y, ID id, float velociteX, float velociteY){
        super(x, y , id);
        velX = velociteX;
        velY = velociteY;
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
        g.setColor(Color.red);
        g.fillRect((int)x, (int)y, 16, 16);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 16, 16);
    }

}
