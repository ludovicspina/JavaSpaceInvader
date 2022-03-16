package game;

import objets.GameObject;
import objets.ID;

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Menu {
    public static String pseudo = "";
    private Handler handler;

    public void tick() {}

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 40);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.setColor(Color.green);
        g.drawString("Space Invader", 320, 60);
        g.setColor(Color.white);
        g.setFont(fnt2);
        g.drawRect(420, 110, 200, 64);
        g.drawString("Jouer", 485, 150);
        g.drawRect(420, 210, 200, 64);
        g.drawString("Help", 490, 250);
        g.drawRect(420, 310, 200, 64);
        g.drawString("Difficulté", 460, 350);
        g.setColor(Color.red);
        g.drawRect(10, 404, 200, 64);
        g.drawString("Quitter", 60, 446);
        g.setColor(Color.white);
        g.drawString("Entre ton pseudo :", 10, 40);
        g.drawString(pseudo, 10, 80);
        Over.menuSave();
        if (Spawn.difficultyLevel == 1) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }
        g.drawRect(1, 1, Game.WIDTH - 2, Game.HEIGHT - 2);
        g.setColor(Color.white);
        g.drawString(Integer.toString(Over.score1), 40, 200);
        g.drawString(Integer.toString(Over.score2), 40, 250);
        g.drawString(Integer.toString(Over.score3), 40, 300);
        g.drawString(": " + Over.pseudo1, 120, 200);
        g.drawString(": " + Over.pseudo2, 120, 250);
        g.drawString(": " + Over.pseudo3, 120, 300);
        g.drawString("Difficulté : ", 10, 120 );
        if (Spawn.difficultyLevel == 1) {
            g.drawString("Facile", 160, 120);
        } else {
            g.drawString("Difficile", 160, 120);
        }

    }


}
