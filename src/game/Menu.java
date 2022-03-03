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

    private Handler handler;

    public void tick() {}

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 50);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Menu", 245, 60);
        g.setFont(fnt2);
        g.drawRect(210, 150, 200, 64);
        g.drawString("Play", 280, 190);
        g.drawRect(210, 250, 200, 64);
        g.drawString("Help", 280, 290);
        g.drawRect(210, 350, 200, 64);
        g.drawString("Difficulty", 280, 390);
        g.drawRect(210, 450, 200, 64);
        g.drawString("Exit", 280, 490);
    }


}
