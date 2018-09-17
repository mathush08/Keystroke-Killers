import java.awt.image.BufferedImage ;
import java.awt.*;  
import javax.imageio.*;
import java.io.*; 
import java.awt.event.KeyEvent;

public class UserInteraction
{
  private BufferedImage UI = null; 
  private Main A;
  private boolean Character = false;
  private int x = 598;
  private int xa = 0;
  private String userL;
  private String[] words;
  private int i = 0;
  private int j = 0;
  private int score = 0;
  private int stopScore = 0;
  
  
  public UserInteraction(Main A, String[] words) 
  {   
    try 
    {    
      UI= ImageIO.read(new File("MrQuertyAsdf.png"));
    }
    catch (IOException e) { }
    
    this.A = A;
    
    this.words = words;
  }
  
  public void paint(Graphics2D g, int stopScore)
  {
    if(Character)
      g.drawImage(UI, x, 580, null);
    
    this.stopScore = stopScore;
  }
  
  public void move()
  {            
    x += xa;
  }
  
  public void keyReleased(KeyEvent e) 
  {
    xa = 0;
  }
  
  public int sendCorrect()
  {
    return j;
  }
  
  public int sendWordP()
  {
    return i;
  }
  
  public int sendScore()
  {
    return score;
  }

  public void letterCheck (String letter)
  {
    //System.out.println(letter);
    
    
    
    if ((letter.charAt(0) == words[i].charAt(j)) && stopScore == 0)
    {
      //System.out.println(j + " letter correct");
      j++;   
    }   
    
    if ((j == words[i].length()) && stopScore == 0)
    {
      SoundClipTest.MonsterShoot();
      score += j;
      i++;
      j = 0; 
    }
    
  }
  
  public void keyPressed(KeyEvent e) 
  {
    {
      if (e.getKeyCode() == KeyEvent.VK_1)
      Character = true;
      userL = (KeyEvent.getKeyText(e.getKeyCode())).toLowerCase();
      
      if ((userL.charAt(0) >= 'a') && (userL.charAt(0) <= 'z'))
      {
        letterCheck(userL);
        userL = "";
      }
      
      
      
      //System.out.println("keyPressed=" + (KeyEvent.getKeyText(e.getKeyCode())).toLowerCase());
      /*if (e.getKeyCode() == KeyEvent.VK_LEFT)
       xa = -10;
       if (e.getKeyCode() == KeyEvent.VK_RIGHT)
       xa = 10;*/
    }
  }
}