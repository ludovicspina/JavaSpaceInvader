package game;

import builder.builders.BasicEnemyBuilder;
import builder.builders.BossEnemyBuilder;
import builder.builders.FastEnemyBuilder;
import builder.director.Director;
import objets.*;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Spawn {
    private Handler handler;
    private Health health;
    private int keepScore = -1;
    private Random r;
    private boolean isBossSpawned = false;
    private BossEnemy bob = null;
    private BossEnemy alfred = null;

    Director director;
    BasicEnemyBuilder basicEnemyBuilder;
    FastEnemyBuilder fastEnemyBuilder;
    BossEnemyBuilder bossEnemyBuilder;
    builder.enemies.BossEnemy bo;
    public static int difficultyLevel = 1;

    public Spawn(Handler handler, Health health) {
        r = new Random();
        this.handler = handler;
        this.health = health;
        director = new Director();
        basicEnemyBuilder = new BasicEnemyBuilder();
        fastEnemyBuilder = new FastEnemyBuilder();
        bossEnemyBuilder = new BossEnemyBuilder();
        director.constructBasicEnemy(basicEnemyBuilder);
        director.constructFastEnemy(fastEnemyBuilder);
        director.constructBossEnemy(bossEnemyBuilder);
    }

    public void tick() {

        if (keepScore == -1) {
            handler.add(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, handler));
        }
        keepScore++;

        if (Health.HEALTH <= 0) {
            Game.gameState = ID.Over;
            Over.save();
            Over.pseudoSave();
        }

        // basic enemy : handler.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
        // smart enemy : handler.add(new SmartEnemy(50, 50, ID.SmartEnemy, handler));


        if (keepScore >= 100) {
            keepScore = 0;
            health.setLevel(health.getLevel() + 1);

            if (difficultyLevel == 1) {
                if (health.getLevel() >= 1) {
                    // handler.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(basicEnemyBuilder.getResult());
                }

                if (health.getLevel() > 5) {
                    handler.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                }

                if (health.getLevel() >= 10) {
                    if (!isBossSpawned) {
                        bo = bossEnemyBuilder.getResult();
                        handler.objects.add(bo);
                        isBossSpawned = true;
                    }
                    handler.add(new builder.enemies.BasicEnemy(bo.getX(), bo.getY(), ID.Enemy, 5, 5));
                }

            }

            if (difficultyLevel == 2) {
                if (health.getLevel() >= 1) {
                    // handler.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    // handler.add(new BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy));
                    handler.objects.add(basicEnemyBuilder.getResult());
                    handler.objects.add(fastEnemyBuilder.getResult());
                }

                if (health.getLevel() > 5) {
                    handler.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                    handler.add(new SmartEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.SmartEnemy, handler));
                }

                if (health.getLevel() >= 10) {
                    if (!isBossSpawned) {
                        bo = bossEnemyBuilder.getResult();
                        handler.objects.add(bo);
                        isBossSpawned = true;
                    }
                    handler.add(new builder.enemies.BasicEnemy(bo.getX(), bo.getY(), ID.Enemy, 1, 5));
                }
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
