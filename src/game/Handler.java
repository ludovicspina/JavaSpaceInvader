package game;

import objets.GameObject;
import objets.ID;
import objets.Player;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    public LinkedList<GameObject> objects = new LinkedList<GameObject>();
    public void tick(){
        for (GameObject go : objects) {
            go.tick();
        }
    }
    public void render(Graphics g){
        for (GameObject go : objects) {
            go.render(g);
        }
    }
    public void add(GameObject go){
        objects.add(go);
    }
    public void remove(GameObject go){
        objects.remove(go);
    }

    public void clearEnemies(){
     objects.clear();
     objects.add(new Player(Game.WIDTH / 2 - 32, Game.HEIGHT / 2 - 32, ID.Player, this));
    }
}
