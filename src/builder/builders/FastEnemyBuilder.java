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
    private float velocityX;
    private float velocityY;
    Random r = new Random();

    @Override
    public void setVelX(float velX) { this.velocityX = velX; }

    @Override
    public void setVelY(float velY) { this.velocityY = velY; }

    @Override
    public void setX(float x){ this.x = x; }

    @Override
    public void setY(float y){ this.y = y; }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getVelocityX() {
        return velocityX;
    }

    public float getVelocityY() {
        return velocityY;
    }

    public FastEnemy getResult() {
        return new builder.enemies.FastEnemy(this.getX(), this.getY(), ID.FastEnemy, this.getVelocityX(), this.getVelocityY());
    }
}
