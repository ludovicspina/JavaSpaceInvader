package objets;

import game.Game;
import game.Handler;
import game.Health;
import objets.GameObject;
import objets.ID;

import java.awt.*;

public class Player extends GameObject{
    private final Handler handler;

    public Player(float x, float y, ID id, Handler handler) {
        super(x, y, id);
        this.handler = handler;
    }

    @Override
    public void tick() {
        x += velX;
        y += velY;
        x = Game.neSorsPasDeLecran((int)this.x, 0, Game.WIDTH - 32);
        y = Game.neSorsPasDeLecran((int)this.y, 0, Game.HEIGHT - 32);


        collision();
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillOval((int)x, (int)y, 32, 32);
    }

    @Override
    public Rectangle getBounds(){
        return new Rectangle((int)x, (int)y, 32, 32);
    }

    public void collision(){
        for(int i = 0; i < handler.objects.size(); i++){
            GameObject tempGo = handler.objects.get(i);
            if(tempGo.getId() == ID.Enemy || tempGo.getId() == ID.FastEnemy || tempGo.getId() == ID.SmartEnemy){
                if(getBounds().intersects(tempGo.getBounds())){
                    Health.HEALTH--;
                }
            }
        }
    }

}
