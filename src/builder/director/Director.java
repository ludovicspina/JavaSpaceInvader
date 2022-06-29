package builder.director;

import builder.builders.Builder;
import game.Game;

import java.util.Random;

public class Director {
    public void constructBasicEnemy(Builder builder){
        builder.setVelX(3);
        builder.setVelY(3);
        builder.setX(new Random().nextInt(Game.WIDTH - 16));
        builder.setY(new Random().nextInt(Game.WIDTH - 16));
    }
    public void constructFastEnemy(Builder builder){
        builder.setVelX(10);
        builder.setVelY(10);
        builder.setX(new Random().nextInt(Game.WIDTH - 16));
        builder.setY(new Random().nextInt(Game.WIDTH - 16));
    }
    public void constructBossEnemy(Builder builder){
        builder.setVelX(2);
        builder.setVelY(0);
        builder.setX(5);
        builder.setY(5);
    }
}
