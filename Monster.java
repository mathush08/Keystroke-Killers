import java.awt.image.BufferedImage ;
import java.awt.*;  
import javax.imageio.*;
import java.io.*; 
import java.awt.event.KeyEvent;


public class Monster
{
  private BufferedImage Blu = null; 
  private BufferedImage Gloop = null;
  private BufferedImage Nogard = null;
  private BufferedImage Ore = null;
  private BufferedImage Trident = null;
  private BufferedImage Wizzy = null;
  private Main A;
  private int x = 0;
  private int y = 0;
  private int i = 0;
  private int q = 0;
  private int speed = 0;
  private int compare = 15;
  private int see = 1;
  private int way = 0;
  private String[] words;
  private boolean Start = false;
  private int Pause = 0;
  
  
  
  public Monster(Main A, int Monster, int Position, int i, String[] words) 
  {   
    try 
    {    
      Blu = ImageIO.read(new File("Blu.png"));
    }
    catch (IOException e) { }
    try 
    {    
      Gloop = ImageIO.read(new File("Gloop.png"));
    } 
    catch (IOException e) { }
    try 
    {    
      Nogard = ImageIO.read(new File("Nogard.png"));
    } 
    catch (IOException e) { }
    try 
    {    
      Ore = ImageIO.read(new File("ore.png"));
    } 
    catch (IOException e) { }
    try 
    {    
      Trident = ImageIO.read(new File("trident.png"));
    } 
    catch (IOException e) { }
    try 
    {    
      Wizzy = ImageIO.read(new File("wizzy.png"));
    } 
    catch (IOException e) { }
    
    
    this.x = Monster;
    this.y = Position * 300;
    this.i = (i * - 150) - 100;
    this.A = A;
    this.words = words;
  }
 
  
  public void paint(Graphics2D g, String word, int correct, int wordP, int StopMonsters)
  {
    if(words[wordP].equals(word))
    {
      q = correct;
    }
    
    if (wordP == compare)
    {
      speed++;
      compare += 15;
    }

    if(Start && Pause % 2 == 0)
    {
      g.setColor(Color.WHITE);
      if(x == 1 && StopMonsters == 0)
      {
        
        g.drawImage(Blu, y, i, 80, 80, null);
        g.setFont(new Font("Calibri", Font.PLAIN, 25));
        g.drawString(word, y, i);
        g.setColor(Color.RED);
        g.drawString(word.substring(0, q), y, i);
      }
      
      if(x == 2 && StopMonsters == 0)
      {
        g.drawImage(Gloop, y, i, 80, 80, null);
        g.setFont(new Font("Calibri", Font.PLAIN, 25));
        g.drawString(word, y, i);
        g.setColor(Color.RED);
        g.drawString(word.substring(0, q), y, i);
      }
      if(x == 3 && StopMonsters == 0)
      {
        g.drawImage(Nogard, y, i, 80, 80, null);
        g.setFont(new Font("Calibri", Font.PLAIN, 25));
        g.drawString(word, y, i);
        g.setColor(Color.RED);
        g.drawString(word.substring(0, q), y, i);
      }
      if(x == 4 && StopMonsters == 0)
      {
        g.drawImage(Ore, y, i, 80, 80, null);
        g.setFont(new Font("Calibri", Font.PLAIN, 25));
        g.drawString(word, y, i);
        g.setColor(Color.RED);
        g.drawString(word.substring(0, q), y, i);
      }      
      if(x == 5 && StopMonsters == 0)
      {
        g.drawImage(Trident, y, i, 80, 80, null);
        g.setFont(new Font("Calibri", Font.PLAIN, 25));
        g.drawString(word, y, i);
        g.setColor(Color.RED);
        g.drawString(word.substring(0, q), y, i);
      }
      if(x == 6 && StopMonsters == 0)
      {
        g.drawImage(Wizzy, y, i, 80, 80, null);
        g.setFont(new Font("Calibri", Font.PLAIN, 25));
        g.drawString(word, y, i);
        g.setColor(Color.RED);
        g.drawString(word.substring(0, q), y, i);
      }
    }
    // if(Start)
    // g.drawImage(GS, 0, 0, null);
  }
  
  public void move()
  {
    if(Start == false)
      way = 0;
    if(Start == true && Pause % 2 != 0)
      way = 0;
    if(Start == true && Pause % 2 == 0) 
      way = 1 + speed;
    else
      way = 0;
    i = i + way;
  }
  
  public void keyReleased(KeyEvent e) 
  {
    //if (e.getKeyCode() != KeyEvent.VK_3)
    //Pause += 2;
  }
  
  public void keyPressed(KeyEvent e) 
  {
    {
      if (e.getKeyCode() == KeyEvent.VK_1)
      Start = true;
      if (e.getKeyCode() == KeyEvent.VK_3)
      Pause += 1;
    }
  }
  
  public int geti()
  {
    return i;
  }
}


