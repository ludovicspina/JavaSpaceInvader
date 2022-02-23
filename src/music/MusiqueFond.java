package music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusiqueFond {
    public MusiqueFond() {

        File s = new File("C:\\Users\\Ludovic\\Desktop\\spaceinvader\\src\\kalinka.wav");
        AudioInputStream audioIn = null;
        try {
            audioIn = AudioSystem.getAudioInputStream(s);
        } catch (UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        }
        Clip clip = null;
        try {
            clip = AudioSystem.getClip();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
        try {
            clip.open(audioIn);
        } catch (LineUnavailableException | IOException e) {
            e.printStackTrace();
        }
        clip.start();
    }
}
