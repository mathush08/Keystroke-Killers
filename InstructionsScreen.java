import java.awt.image.BufferedImage ;
import java.awt.*;  
import javax.imageio.*;
import java.io.*; 
import java.awt.event.KeyEvent;


public class InstructionsScreen
{
  private BufferedImage IS = null; 
  private Main A;
  private int Instructions = 0;
  
  public InstructionsScreen(Main A) 
  {   
    try 
    {    
      IS = ImageIO.read(new File("InstructionMenu.png"));
    }
    catch (IOException e) { }
    
    this.A = A;
  }
  
  public void paint(Graphics2D g)
  {
    if(Instructions % 2 != 0)
      g.drawImage(IS, 0, 0, null);
  }
  
  public void keyReleased(KeyEvent e) 
  {
    if (e.getKeyCode() != KeyEvent.VK_2)
      Instructions += 2;
  }
  
  public void keyPressed(KeyEvent e) 
  {
    if (e.getKeyCode() == KeyEvent.VK_2)
      Instructions += 1;
  }
}