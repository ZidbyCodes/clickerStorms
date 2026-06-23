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
  boolean selected;
  boolean finish;
  // end attributes
  
  public boxuml(int w, int h, int x, int y) {
    xpos = x;
    ypos = y;
    with = w;
    height = h;
    this.height = 0;
    this.finish = false;
    this.selected = false;
  }

  // start methods
  public int getWith() {
    return with;
  }

  public int getHeight() {
    return height;
  }

  public int getXpos() {
    return xpos;
  }

  public int getYpos() {
    return ypos;
  }

  public boolean isSelected() {
    return selected;
  }
  public void drawBox() {
    // TODO add your code here
    finish = false;
    xc = xpos;
    yc = ypos;
    while (finish == false) { 
      LCD.setPixel(xc,yc,1);
      xc = xc+1;
      if (xc > (xpos + with)) {
          while (!(yc >= (ypos + height))) {
            xc = xpos;
            LCD.setPixel(xc,yc,1);
            LCD.setPixel(xc+with,yc,1); 
            yc = yc+1;
        } // end of while      
      } // end of if
      
      if (yc > ypos + height) {
        finish = true;
      } // end of if
    } // end of while
  }
  // end methods
} // end of boxuml
