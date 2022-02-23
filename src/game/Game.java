package game;

import music.MusiqueFond;
import objets.*;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Boolean running = false;
    private Thread thread;
    private Spawn spawn;
    private Menu menu;
    public static ID gameState = ID.Menu ;
    private Random r;


    public Game() {
        new Window(WIDTH, HEIGHT, "Space Invaders BYOB", this);
        setFocusable(true);
        Handler handler = new Handler();
        Health health = new Health();
        menu = new Menu();
        this.addKeyListener(new KeyInput(handler));
        spawn = new Spawn(handler, health);
        // handler.add(new Player(WIDTH / 2 - 32, HEIGHT / 2 - 32, ID.Player, handler));

        // handler.add(new BasicEnemy(WIDTH / 2 - 32, HEIGHT / 10 - 32, ID.Enemy));
        //handler.add(new FastEnemy(WIDTH / 2 - 32, HEIGHT / 10 - 32, ID.FastEnemy));
        //handler.add(new SmartEnemy(WIDTH / 2 - 32, HEIGHT / 10 - 32, ID.SmartEnemy, handler));


    }

    public static int neSorsPasDeLecran(int var, int min, int max) {
        if (var >= max) {
            return var = max;
        } else if (var <= min) {
            return var = min;
        } else {
            return var;
        }
    }

    public static boolean neSorsPasSalo(int var, int min, int max) {
        if (var >= max) {
            return true;
        } else return var <= min;
    }

    @Override
    public void run() {
        MusiqueFond musiqueFond = new MusiqueFond();

        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while (running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                tick();
                delta--;
            }
            if (running)
                render();
            frames++;
            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                System.out.println("FPS : " + frames);
                frames = 0;
            }
        }
        stop();
    }

    private void tick() {
        if (spawn != null && gameState == ID.Game)
            spawn.tick();
    }

    private void render() {
        BufferStrategy bs = this.getBufferStrategy();
        if (bs == null) {
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.black);
        g.fillRect(0, 0, WIDTH, HEIGHT);
        if (spawn != null && gameState == ID.Game) {
            spawn.render(g);
        } else if (gameState == ID.Menu)
        {
            menu.render(g);
        }
        g.dispose();
        bs.show();
    }

    public synchronized void start() {
        thread = new Thread(this);
        thread.start();
        running = true;
    }

    public synchronized void stop() {
        try {
            thread.join();
            running = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Game();
    }

}
