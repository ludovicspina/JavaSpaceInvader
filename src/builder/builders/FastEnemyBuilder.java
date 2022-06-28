package builder.builders;

import builder.enemies.BasicEnemy;
import builder.enemies.FastEnemy;
import game.Game;
import objets.GameObject;
import objets.ID;

import java.awt.*;
import java.util.Random;

public class FastEnemyBuilder implements Builder {
    private float x;
    private float y;
    Random r = new Random();

    @Override
    public void setVelX(float x) { this.x = x; }

    @Override
    public void setVelY(float y) { this.y = y; }

    public FastEnemy getResult() {
        return new builder.enemies.FastEnemy(r.nextInt(Game.WIDTH - 16), r.nextInt(Game.HEIGHT - 16), ID.FastEnemy, x, y);
    }
}
