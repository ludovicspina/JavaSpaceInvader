package game;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import objets.GameObject;
import objets.ID;


public class KeyInput extends KeyAdapter {
    private final Handler handler;
    private final boolean[] keyDown = new boolean[4];
    public static boolean isPaused = false;
    private Pause pause;

    public KeyInput(Handler handler) {
        this.handler = handler;
        keyDown[0] = false;
        keyDown[1] = false;
        keyDown[2] = false;
        keyDown[3] = false;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.Player) {

                if (key == KeyEvent.VK_Z) {
                    tempObject.setVelY(-5);
                    keyDown[0] = true;
                }
                if (key == KeyEvent.VK_S) {
                    tempObject.setVelY(5);
                    keyDown[1] = true;
                }
                if (key == KeyEvent.VK_Q) {
                    tempObject.setVelX(-5);
                    keyDown[2] = true;
                }
                if (key == KeyEvent.VK_D) {
                    tempObject.setVelX(5);
                    keyDown[3] = true;
                }
            }
        }

        if (key == KeyEvent.VK_ESCAPE) {
            System.exit(0);
        }

        if (key == KeyEvent.VK_P && (Game.gameState == ID.Game || Game.gameState == ID.Pause)) {
            pause = new Pause();
            if (!isPaused) {
                isPaused = true;
                Game.gameState = ID.Pause;
            } else {
                isPaused = false;
                Game.gameState = ID.Game;
            }
        }

    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
        for (int i = 0; i < handler.objects.size(); i++) {
            GameObject tempObject = handler.objects.get(i);
            if (tempObject.getId() == ID.Player) {
                if (key == KeyEvent.VK_Z) keyDown[0] = false;
                if (key == KeyEvent.VK_S) keyDown[1] = false;
                if (key == KeyEvent.VK_Q) keyDown[2] = false;
                if (key == KeyEvent.VK_D) keyDown[3] = false;
                if (!keyDown[0] && !keyDown[1]) tempObject.setVelY(0);
                if (!keyDown[2] && !keyDown[3]) tempObject.setVelX(0);
            }
        }
    }
}