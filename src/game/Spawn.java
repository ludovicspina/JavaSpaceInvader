package game;

import objets.*;

import java.awt.*;
import java.util.Random;

public class Spawn {
    private Handler handler;
    private Health health;
    private int keepScore = -1;
    private Random r;

    public Spawn(Handler handler, Health health){
        r = new Random();
        this.handler = handler;
        this.health = health;
    }

    public void tick(){
        if(keepScore == -1){
            handler.add(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
            handler.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
        }
        keepScore++;
        if(keepScore >= 100){
            keepScore = 0;
            health.setLevel(health.getLevel() + 1);

            if(health.getLevel() <= 5){
                handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
            }
            if(health.getLevel() == 6){
                handler.clearEnemies();
                handler.objects.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));

            }
            if(health.getLevel() > 6 && health.getLevel() < 15){ //&& health.getLevel() < 10
                handler.objects.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
            }
            if(health.getLevel() > 15){
                handler.objects.add(new FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy));
            }
            /**if(health.getLevel() == 10){
                handler.clearEnemies();
            }**/

        }
        handler.tick();
        health.tick();
    }
    public void render(Graphics g){
        handler.render(g);
        health.render(g);
    }
}
