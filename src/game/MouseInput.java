package game;

import music.MusiqueFond;
import objets.ID;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class MouseInput extends MouseAdapter {
    private Menu Menu;

    public MouseInput(Menu menu) {
        this.Menu = menu;
    }

    public void mousePressed(MouseEvent e) {
        int mx = e.getX();
        int my = e.getY();
        if (mouseOver(mx, my, 210, 150, 200, 64)) {
            Game.gameState = ID.Game;
        } else if (mouseOver(mx, my, 210, 250, 200, 64)) {
            System.out.println("Info");
        } else if (mouseOver(mx, my, 210, 350, 200, 64)) {
            MusiqueFond cry = new MusiqueFond("src/cry.wav");
            try {
                Thread.sleep(6000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            System.exit(0);
        }
    }

    private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
        return (mx >= x && mx <= (x + width)) && (my >= y && my <= (y + height));
    }
}
