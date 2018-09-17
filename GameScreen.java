import java.awt.image.BufferedImage ;
import java.awt.*;  
import javax.imageio.*;
import java.io.*; 
import java.awt.event.KeyEvent;

public class GameScreen
{
  private BufferedImage GS = null; 
  private Main A;
  private boolean Start = false;
  
  public GameScreen(Main A) 
  {   
    try 
    {    
      GS = ImageIO.read(new File("GameScreen.png"));
    }
    catch (IOException e) { }
    
    this.A = A;
  }
  
  public void paint(Graphics2D g, int score)
  {
    if(Start)
    {
      g.drawImage(GS, 0, 0, null);
      g.setColor(Color.WHITE);
      g.setFont(new Font("Impact", Font.PLAIN, 40));
      g.drawString(Integer.toString(score), 1160, 680);
    }
  }
  
  public int Start()
  {
    if(Start = true)
      return 1;
    else 
      return 0;
  }
  
  public void keyReleased(KeyEvent e) 
  {
  }
  
  public void keyPressed(KeyEvent e) 
  {
    {
      if (e.getKeyCode() == KeyEvent.VK_1)
      Start = true;
    }
  }
}