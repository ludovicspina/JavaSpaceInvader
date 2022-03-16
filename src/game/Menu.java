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
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Menu", 450, 60);
        g.setFont(fnt2);
        g.drawRect(440, 110, 200, 64);
        g.drawString("Play", 500, 150);
        g.drawRect(440, 210, 200, 64);
        g.drawString("Help", 500, 250);
        g.drawRect(440, 310, 200, 64);
        g.drawString("Difficulty", 500, 350);
        g.drawRect(440, 410, 200, 64);
        g.drawString("Exit", 500, 450);
        g.drawString("Tape ton pseudo maintenant", 10, 40);
        g.drawString(pseudo, 10, 70);
        Over.menuSave();
        g.drawString(Integer.toString(Over.score1), 60, 200);
        g.drawString(Integer.toString(Over.score2), 60, 250);
        g.drawString(Integer.toString(Over.score3), 60, 300);
        g.drawString(Over.pseudo1, 140, 200);
        g.drawString(Over.pseudo2, 140, 250);
        g.drawString(Over.pseudo3, 140, 300);
        g.drawString("dificulté : ", 10, 120 );
        if (Spawn.difficultyLevel == 1) {
            g.drawString("facile", 150, 120);
        } else {
            g.drawString("difficile", 150, 120);
        }

    }


}
