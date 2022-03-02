package game;

import objets.*;

import java.awt.*;
import java.util.Random;

public class Spawn {
    private Handler handler;
    private Health health;
    private int keepScore = -1;
    private Random r;
    private boolean isBossSpawned = false;
    private BossEnnemy bob = null;

    public Spawn(Handler handler, Health health) {
        r = new Random();
        this.handler = handler;
        this.health = health;
    }

    public void tick() {
        if (keepScore == -1) {
            handler.add(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
            handler.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
        }
        keepScore++;
        if (keepScore >= 100) {
            keepScore = 0;
            health.setLevel(health.getLevel() + 1);

            if (health.getLevel() > 1) { //&& health.getLevel() < 10
                if (!isBossSpawned) {
                    bob = new BossEnnemy(Game.WIDTH / 2, Game.HEIGHT - 40, ID.Enemy);
                    handler.objects.add(bob);
                    isBossSpawned = true;
                }
                handler.objects.add(new ProjBossEnnemy(bob.getX(), bob.getY(), ID.Enemy));

            }


        }
        handler.tick();
        health.tick();
    }

    public void render(Graphics g) {
        handler.render(g);
        health.render(g);
    }
}
