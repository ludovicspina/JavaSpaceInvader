package builder.director;

import builder.builders.Builder;

public class Director {
    public void constructBasicEnemy(Builder builder){
        builder.setVelX(3);
        builder.setVelY(3);
    }
    public void constructFastEnemy(Builder builder){
        builder.setVelX(10);
        builder.setVelY(10);
    }
}
