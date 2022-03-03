package game;

import music.MusiqueFond;
import objets.*;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {

    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    private Boolean running = false;
    public static Thread thread;
    private Spawn spawn;
    private Menu menu;
    private Pause pose;
    private Help help;
    private Over over;
    private Difficulty difficulty;
    public static ID gameState = ID.Menu;
    private Random r;

    public Game() {
        new Window(WIDTH, HEIGHT, "Space Invaders BYOB", this);
        setFocusable(true);
        Handler handler = new Handler();
        Health health = new Health();
        menu = new Menu();
        this.addKeyListener(new KeyInput(handler));
        this.addMouseListener(new MouseInput(menu));
        spawn = new Spawn(handler, health);
        pose = new Pause();
        help = new Help();
        over = new Over(health);
        difficulty = new Difficulty();
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
        MusiqueFond musiqueFond = new MusiqueFond("src/rasputin.wav");

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

        if (gameState == ID.Pause) {
            pose.tick();
        }

        if (gameState == ID.Help) {
            help.tick();
        }

        if (gameState == ID.Over) {
            over.tick();
        }

        if (gameState == ID.Difficulty) {
            difficulty.tick();
        }
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
        } else if (gameState == ID.Menu) {
            menu.render(g);
        } else if (gameState == ID.Pause) {
            pose.render(g);
        } else if (gameState == ID.Help) {
            help.render(g);
        }else if (gameState == ID.Over) {
            over.render(g);
        }else if (gameState == ID.Difficulty) {
            difficulty.render(g);
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
