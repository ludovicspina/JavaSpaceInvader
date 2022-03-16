package game;

import music.MusiqueFond;
import objets.ID;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Objects;


public class MouseInput extends MouseAdapter {
    private Menu Menu;

    public MouseInput(Menu menu) {
        this.Menu = menu;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (Game.gameState == ID.Menu) {
            if (mouseOver(mx, my, 440, 110, 200, 64)) {
                Game.gameState = ID.Game;
                if (Objects.equals(game.Menu.pseudo, "")) {
                    game.Menu.pseudo = "tapamitonpseudo";
                }
            } else if (mouseOver(mx, my, 440, 210, 200, 64)) {
                Game.gameState = ID.Help;
            } else if (mouseOver(mx, my, 440, 310, 200, 64)) {
                Game.gameState = ID.Difficulty;
            } else if (mouseOver(mx, my, 440, 410, 200, 64)) {
                MusiqueFond cry = new MusiqueFond("src/cry.wav");
                try {
                    Thread.sleep(6000);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
                System.exit(0);
            }
        } else if (Game.gameState == ID.Help) {
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                if (KeyInput.isPaused) {
                    Game.gameState = ID.Game;
                } else {
                    Game.gameState = ID.Menu;
                }

            }
        } else if (Game.gameState == ID.Pause) {
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                Game.gameState = ID.Game;
                KeyInput.isPaused = false;
            }
        } else if (Game.gameState == ID.Difficulty) {
            if (mouseOver(mx, my, 210, 150, 200, 64)) {
                Spawn.difficultyLevel = 1;
                Game.gameState = ID.Menu;
            } else if (mouseOver(mx, my, 210, 250, 200, 64)) {
                Spawn.difficultyLevel = 2;
                Game.gameState = ID.Menu;
            }
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        return (mx >= x && mx <= (x + width)) && (my >= y && my <= (y + height));
    }
}
