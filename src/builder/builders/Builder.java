package builder.builders;

import objets.GameObject;
import objets.ID;

public interface Builder {
    void setVelX(float velX);

    void setVelY(float velY);

    void setX(float x);

    void setY(float y);
}