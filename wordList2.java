import java.io.*;
import java.util.*;
//import java.util.concurrent.ThreadLocalRandom;

class wordList2
{
  //String[] words = new String[];
  private static String[] words = new String[1000];
  public static String[] allWords()
  {
    try
    {
      FileReader fr = new FileReader("list of 1000 words.txt");
      //Majority of words received from http://www.ef.com/english-resources/english-vocabulary/top-1000-words/ ; Many words changed however
      BufferedReader br = new BufferedReader(fr);
      String line;
      int i = 0;
     
      
      while ((line = br.readLine()) != null)
      {
        words[i] = line;
        i++;
      }
      
      Collections.shuffle(Arrays.asList(words));
      //http://stackoverflow.com/questions/1519736/random-shuffling-of-an-array
      
      br.close();
    }
    catch(IOException e)
    {
      System.out.println("error");
    }
    return words;
  }
}