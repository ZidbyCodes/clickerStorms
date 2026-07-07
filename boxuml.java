import lejos.nxt.*;
/**
 *
 * Description
 *
 * @version 1.0 from 15.06.2026
 * @author 
 */

public class boxuml{
  // start attributes
  int with;
  int height;
  int xpos;
  int ypos;
  int xc;
  int yc;
  int id;
  boolean finish;
  private main bildi;
  int displayedNumber;
  int countofTimes = 0;
  boolean isSelected;
  // end attributes
  
  public boxuml(int w, int h, int x, int y, main bildi, int id) {
    xpos = x;
    ypos = y;
    with = w;
    height = h;
    this.finish = false;
    this.bildi = bildi;
    this.id = id;
  }

  // start methods
  public void drawBox() {
    // TODO add your code here
    finish = false;
    xc = xpos;
    yc = ypos;
    while (finish == false) { 
      LCD.setPixel(xc,yc,1);
      xc = xc+1;
      if (xc > with + xpos) {
        //LCD.drawChar('x',1,3); //used for debugging
        while (yc < height+ypos) {
          //LCD.drawChar('y',1,4);  //used for debugging
          xc = xpos;
          LCD.setPixel(xc,yc,1);
          LCD.setPixel(xc+with,yc,1); 
          yc = yc+1;
        } // end of while      
      } // end of if
      
      if (yc == height+ ypos && xc -1 == with + xpos) {
        finish = true;
        //LCD.drawChar('f',2,4); //used for debugging
      } // end of if
//      Button.waitForAnyPress(); //used for debugging
    } // end of while
  }
  public void loescheBox() {
    finish = false;
    xc = xpos;
    yc = ypos;
    while (finish == false) { 
      LCD.setPixel(xc,yc,0);
      xc = xc+1;
      if (xc > with + xpos) {
        while (yc < height+ypos) {
          xc = xpos;
          LCD.setPixel(xc,yc,0);
          LCD.setPixel(xc+with,yc,0); 
          yc = yc+1;
        } // end of while      
      } // end of if
      if (yc == height+ ypos && xc == with + xpos) {
        finish = true;
      } // end of if
    } // end of while
  }
  public void drawInhalt()
  {
    if (id == 1) {
      displayedNumber = (int) bildi.Score;
      countofTimes = 0;
      while (displayedNumber/1000 >= 1) {
        countofTimes = countofTimes+1;
        displayedNumber = displayedNumber/100;
        LCD.drawChar('a',4,3);
        clearInhalt();
//        Button.waitForAnyPress();       used for debugging
      } // end of if
      LCD.drawInt(displayedNumber,6,1);
      LCD.drawInt(countofTimes,6,2);
      LCD.drawChar('d',1,3);  
    }else {
      LCD.drawInt(displayedNumber,6,1);
      LCD.drawChar('f',1,3); 
    } // end of if-else
  }
  public void clearInhalt() {
    if (id == 1) {
      LCD.clear(6,1,4);
    }
  }
  public void blinken()
  {
    loescheBox();
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
    drawBox();
    try {
      Thread.sleep(100);
    } catch (InterruptedException e) {
      Thread.currentThread().interrupt();
    }
  }
}
  
//  public static void main (String[] args) throws Exception
//  {
//       boxuml boxi = new boxuml(10,10,10,10);
//       boxi.drawBox();
//  } //used for debugging
// end methods
// end of boxuml
