import java.awt.image.BufferedImage ;
import java.awt.*;  
import javax.imageio.*;
import java.io.*; 


public class EndScreen
{
  private BufferedImage ES = null; 
  private Main A;
  private int StopMonsters = 0;
  
  public EndScreen(Main A) 
  {   
    try 
    {    
      ES = ImageIO.read(new File("EndScreen.png"));
    }
    catch (IOException e) { }
    
    this.A = A;
  }
  
  public void paint(Graphics2D g, int EndScreen, int EndScreen2, int score)
  {
    if(EndScreen == 1)
    {
      StopMonsters = 1;
      g.drawImage(ES, 0, 0, null);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Impact", Font.PLAIN, 100));
      g.drawString("Final Score: " + Integer.toString(score), 260, 510);
    }
  }
  public int getStopMonsters()
  {
    return StopMonsters;
  }
  
}