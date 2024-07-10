import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Sound { //class to make sound 

    public static void playFlapSound() {
        playSound("C:\\Users\\Amany Zayed\\Desktop\\FLlappyBird.java\\src\\mixkit-double-little-bird-chirp-21.wav");
    }

    public static void playGameOverSound() {
        playSound("C:\\Users\\Amany Zayed\\Desktop\\FLlappyBird.java\\src\\mixkit-retro-arcade-lose-2027.wav");
    }

    private static void playSound(String soundFileName) {
        try {
            File soundFile = new File(soundFileName);
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            Clip clip = AudioSystem.getClip();
            clip.open(audioIn);
            clip.start();
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
}
