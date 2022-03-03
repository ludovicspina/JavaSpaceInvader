package game;

import java.awt.*;
import java.io.*;
import java.util.Arrays;

public class Over {

    private Handler handler;
    private static int[] scoreList;
    private static Health health;
    private static int score1;
    private static int score2;
    private static int score3;

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
        g.drawString("CHEH", Game.WIDTH / 4, Game.HEIGHT / 3);
        g.setFont(fnt2);
        g.drawString(Integer.toString(score1), 260, 250);
        g.drawString(Integer.toString(score2), 260, 300);
        g.drawString(Integer.toString(score3), 260, 350);
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


}
