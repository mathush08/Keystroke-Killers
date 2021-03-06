//This is the Main stuff with the words and music 

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends JPanel
{
  private String[] words = wordList2.allWords();
  private Monster[] Number = new Monster[1000];
  private GameScreen GS = new GameScreen(this);
  private MenuScreen MS = new MenuScreen(this);
  private InstructionsScreen IS = new InstructionsScreen(this);
  private PauseScreen PS = new PauseScreen(this);
  private UserInteraction UI = new UserInteraction(this, words);
  private EndScreen ES = new EndScreen(this);  
  
  public Main()
  {
    for(int i = 0; i < Number.length; i++)
    {
      Number[i] = new Monster(this, (int)(6 * Math.random() + 1), (int)(3 * Math.random() + 1), i, words);
    }
    
    {
      addKeyListener(new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
        }
        @Override
        public void keyReleased(KeyEvent e) {
          GS.keyReleased(e);
          IS.keyReleased(e);
          PS.keyReleased(e);
          UI.keyReleased(e);
          for(Monster b:Number)      
          {
            b.keyReleased(e);
          }
        }
        @Override
        public void keyPressed(KeyEvent e) 
        {
          GS.keyPressed(e);
          IS.keyPressed(e);
          PS.keyPressed(e);
          UI.keyPressed(e);
          for(Monster b:Number)      
          {
            b.keyPressed(e);
          }
        }
      });
      setFocusable(true); 
    }
  }
  
  /* public int Play(GameScreen GS)
   {
   if(GS.Start() == 1)
   return 1;
   else 
   return 0;
   } */
  
  public int FixPause(Monster b)
  {
    
    if(b.geti() > -300 && b.geti() < 720) //LB.
      return 1;
    else 
      return 0;  
  }
  
  public int EndScreen (Monster b)
  {
    if (b.geti() >= 500)
      return 1;
    else
      return 0;
  }
  
  public int EndScreen2 (Monster b)
  {
    if (b.geti() == 500)
      return 1;
    else
      return 0;
  }
  
  public int StopMonsters()
  {
    if(ES.getStopMonsters() == 1)
      return 1;
    else 
      return 0;
  }
  
  public void move()
  { 
    //Move each Parcel in the list     
    for(int i = UI.sendWordP(); i < 1000; i++)       
    { 
      Number[i].move(); 
    }
    UI.move();
  }
  
  
  public void paint(Graphics g) 
  {
    super.paint(g);  
    Graphics2D g2d = (Graphics2D) g;
    MS.paint(g2d);
    IS.paint(g2d);
    GS.paint(g2d, UI.sendScore());
    UI.paint(g2d, ES.getStopMonsters());
    /*int i = 0;
    for(Monster b:Number)      
    {
      b.paint(g2d, words[i], UI.sendCorrect(), UI.sendWordP(), UI.sendDestroy());
      PS.paint(g2d, FixPause(b));
      i++;
    }*/
    for(int i = UI.sendWordP(); i < 1000; i++)      
    {
      Number[i].paint(g2d, words[i], UI.sendCorrect(), UI.sendWordP(), StopMonsters());
      ES.paint(g2d, EndScreen(Number[i]), EndScreen2(Number[i]), UI.sendScore());
      PS.paint(g2d, FixPause(Number[i]));
    }
    //PS.paint(g2d);
    g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
  }
  
  public static void main(String [] args) throws InterruptedException 
  {
    
    
    JFrame frame = new JFrame("KeyStroke Killers");             
    Main A = new Main();
    frame.add(A);  
    frame.setSize(1280, 760);   
    frame.setVisible(true); 
    SoundClipTest.SoundClipPlay();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    while (true)
    {
      A.move();
      A.repaint();
      Thread.sleep(45);
      //Change to 45
    }
  }
}