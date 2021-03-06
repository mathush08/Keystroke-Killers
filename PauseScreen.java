import java.awt.image.BufferedImage ;
import java.awt.*;  
import javax.imageio.*;
import java.io.*; 
import java.awt.event.KeyEvent;


public class PauseScreen
{
  private BufferedImage PS = null; 
  private Main A;
  private int Pause = 0;
  
  public PauseScreen(Main A) 
  {   
    try 
    {    
      PS = ImageIO.read(new File("PauseScreen.png"));
    }
    catch (IOException e) { }
    
    this.A = A;
  }
  
  public void paint(Graphics2D g, int FixPause)
  {
    if(Pause % 2 != 0 && FixPause == 1)
    { 
      g.drawImage(PS, 0, 0, null);
    }
  }
  
  public void keyReleased(KeyEvent e) 
  {
    // if (e.getKeyCode() != KeyEvent.VK_3)
    // Pause += 2;
  }
  
  public void keyPressed(KeyEvent e) 
  {
    if (e.getKeyCode() == KeyEvent.VK_3)
      Pause += 1;
  }
  
  /*public boolean Pause()
   {
   boolean Pauseb = false;
   if(Pause % 2 != 0)
   Pauseb = true;
   else
   Pauseb = true;
   return Pauseb;
   }*/
  
}