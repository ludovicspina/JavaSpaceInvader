package game;

import java.awt.*;
import java.io.*;
import java.util.Arrays;

public class Over {

    private Handler handler;
    private static int[] scoreList;
    private static String[] pseudoList;
    private static Health health;
    public static int score1;
    public static int score2;
    public static int score3;
    public static String pseudo1;
    public static String pseudo2;
    public static String pseudo3;

    public Over(Health health) {
        Over.health = health;
    }

    public void tick() {
    }

    public void render(Graphics g) {
        Font fnt = new Font("arial", Font.BOLD, 100);
        Font fnt2 = new Font("arial", Font.BOLD, 30);
        g.setFont(fnt);
        g.setColor(Color.white);
        g.drawString("Perdou", 140, Game.HEIGHT / 3);
        g.setFont(fnt2);
        g.drawString(Integer.toString(score1), 160, 250);
        g.drawString(Integer.toString(score2), 160, 300);
        g.drawString(Integer.toString(score3), 160, 350);
        g.drawString(pseudo1, 230, 250);
        g.drawString(pseudo2, 230, 300);
        g.drawString(pseudo3, 230, 350);
        if (Spawn.difficultyLevel == 1) {
            g.setColor(Color.blue);
        } else {
            g.setColor(Color.red);
        }
        g.drawRect(1, 1, Game.WIDTH - 2, Game.HEIGHT - 2);
        g.setColor(Color.white);
    }

    public static void read() {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("score.csv"));
            String row;
            int[] lesScores = new int[0];
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                lesScores = new int[data.length];
                for (int i = 0; i < data.length; i++) {
                    lesScores[i] = Integer.parseInt(data[i]);
                }
            }
            csvReader.close();
            scoreList = lesScores;
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void save() {
        try {
            read();
            int[] lesScores = scoreList;
            lesScores[2] = lesScores[1];
            lesScores[1] = lesScores[0];
            lesScores[0] = health.getScore() + 1;
            FileWriter csvWriter = new FileWriter("score.csv");
            for (int i = 0; i < 3; i++) {
                csvWriter.append(String.valueOf(lesScores[i])).append(",");
            }
            score1 = lesScores[0];
            score2 = lesScores[1];
            score3 = lesScores[2];
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void pseudoRead() {
        try {
            BufferedReader csvReader = new BufferedReader(new FileReader("pseudo.csv"));
            String row;
            String[] lesPseudos = new String[0];
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                lesPseudos = new String[data.length];
                for (int i = 0; i < data.length; i++) {
                    lesPseudos[i] = data[i];
                }
            }
            csvReader.close();
            pseudoList = lesPseudos;
        } catch (IOException e) {
            System.out.println(e);
        }

    }

    public static void pseudoSave() {
        try {
            pseudoRead();
            String[] lesPseudos = pseudoList;
            lesPseudos[2] = lesPseudos[1];
            lesPseudos[1] = lesPseudos[0];
            lesPseudos[0] = Menu.pseudo;
            FileWriter csvWriter = new FileWriter("pseudo.csv");
            for (int i = 0; i < 3; i++) {
                csvWriter.append(String.valueOf(lesPseudos[i])).append(",");
            }
            pseudo1 = lesPseudos[0];
            pseudo2 = lesPseudos[1];
            pseudo3 = lesPseudos[2];
            csvWriter.flush();
            csvWriter.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void menuSave() {
        pseudoRead();
        String[] lesPseudos = pseudoList;
        pseudo1 = lesPseudos[0];
        pseudo2 = lesPseudos[1];
        pseudo3 = lesPseudos[2];

        read();
        int[] lesScores = scoreList;
        score1 = lesScores[0];
        score2 = lesScores[1];
        score3 = lesScores[2];
    }


}
