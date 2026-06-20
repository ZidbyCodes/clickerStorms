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
  private int with;
  private int height;
  private int xpos;
  private int ypos;
  private boolean selected;
  private String Inhalt;
  private int x;
  private int y;
  private boolean finish;
  // end attributes
  
  public boxuml(int w, int h, int xpos, int ypos, String Inhalt) {
    with = w;
    height = h;
    this.xpos = xpos;
    this.ypos = ypos;
    this.Inhalt = Inhalt;
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

  public void setInhalt(String InhaltNew) {
    Inhalt = InhaltNew;
  }

  public void drawBox(int w, int h, int xpos, int ypos, String Inhalt) {
    // TODO add your code here
    x = xpos;
    y = ypos;
    while (finish == false) { 
      LCD.setPixel(x,y,1);
      x = x+1;
        if (x == xpos + w) {
          while (y < ypos + h) {
            LCD.setPixel(xpos,y,1);
            LCD.setPixel(xpos+w,y,1); 
            y = y+1;
          } // end of while      
        } // end of if
      if (y > ypos + h) {
        finish = true;
      } // end of if
    } // end of while
  }
  // end methods
} // end of boxuml
