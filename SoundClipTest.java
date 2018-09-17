import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import javax.swing.*;

//Citation: http://stackoverflow.com/questions/6045384/playing-mp3-and-wav-in-java

class SoundClipTest {
  
  public static void SoundClipPlay() {
    try {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Mega_Hyper_Ultrastorm.wav").getAbsoluteFile());
      Clip clip = AudioSystem.getClip();
      clip.open(audioInputStream);
      clip.start();
      clip.loop(Clip.LOOP_CONTINUOUSLY);
    } catch(Exception ex) {
      System.out.println("Error with playing sound.");
      ex.printStackTrace();
    }
  }
  
  public static void MonsterShoot() {
    try {
      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File("Laser_Cannon.wav").getAbsoluteFile());
      Clip clip2 = AudioSystem.getClip();
      clip2.open(audioInputStream);
      clip2.start();
      //clip.loop(Clip.LOOP_CONTINUOUSLY);
    } catch(Exception ex) {
      System.out.println("Error with playing sound.");
      ex.printStackTrace();
    }
  }
}