package builder.builders;

import builder.enemies.BasicEnemy;
import game.Game;
import objets.GameObject;
import objets.ID;

import java.awt.*;
import java.util.Random;

public class BasicEnemyBuilder implements Builder {
    private float x;
    private float y;
    Random r = new Random();

    @Override
    public void setVelX(float x) { this.x = x; }

    @Override
    public void setVelY(float y) { this.y = y; }

    public BasicEnemy getResult() {
        return new builder.enemies.BasicEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.Enemy, x, y);
    }
}
