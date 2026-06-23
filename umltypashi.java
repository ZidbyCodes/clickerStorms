import lejos.nxt.*;
/**
 *
 * Description
 *
 * @version 1.0 from 15.06.2026
 * @author 
 */

public class umltypashi {
  // start attributes
  private int Score = 0;
  
  //Konstuktor
  public static void main (String[] args) throws Exception
  {
       umltypashi bildi = new umltypashi();
       umltypashi.run();
  }
  
  // start methods
  public int getScore() {
    return Score;
  }

  public void increaseScore(int amount) {
    // TODO add your code here
    
  }

  static void run() {
    // TODO add your code here
    boxuml scoreBox = new boxuml(20,20,30,5);
    scoreBox.drawBox();
    Button.waitForAnyPress();
  }
  // end methods
} // end of umltypashi
