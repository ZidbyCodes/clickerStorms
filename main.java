import lejos.nxt.*;
/**
 *
 * School Projec
 * https://github.com/ZidbyCodes/clickerStorms
 
 *
 * @version 1.1 from 22.08.2026
 * @zidby
 */

public class main {
  // start attributes
  static double Score = 0;
  static int selectedId = 1;
  static int maxId = 2;
  static int upgrade1 = 0;
  // end attributes
  //Konstuktor
  // start methods
  static void main(String[] args) {
    main bildi = new main();
    run(bildi);
  }

  static void run(main bildi) {
    // TODO add your code here
    TouchSensor touch = new TouchSensor(SensorPort.S1);
    //creating scoreBox
    box scoreBox = new box(30,10,35,5,bildi,1);
    scoreBox.drawBox();
    scoreBox.drawInhalt();
    //creating Upgradebox1 and Upgrade1 respectivly
    upgrade upgrade1 = new upgrade (1,1,1,bildi);
    upgradebox upgradebox1 = new upgradebox(10,10,10,10,bildi,2,upgrade1);
    upgradebox1.drawBox();
    upgradebox1.drawInhalt();
    //Button.waitForAnyPress();  //used for debugging
    while (Button.ESCAPE.isUp()) {
      //touch pressed 1 point
      if (touch.isPressed()) {
        switch (selectedId) {
          case 1:
            Score = Math.round (Score + 10*upgrade1.UpgradeMultiplier);
            scoreBox.drawInhalt();
            //LCD.drawChar('t',1,2); //debugging
            while(touch.isPressed()){
              //LCD.drawChar('c',1,2); //debugging
            }
            break;
          case 2:
            if (Score > Math.pow(upgrade1.UpgradeCost,10)) {
              upgrade1.increaseUpgradeMultiplier(10);
            } // end of if
            scoreBox.drawInhalt();
            break;
        }
      } // end of if
      //enter pressed 1 point
      if (Button.ENTER.isDown()) {
        switch (selectedId) {
          case 1:
            Score = Score+1;
            scoreBox.drawInhalt();
            while (Button.ENTER.isDown()){
              LCD.drawChar('d',2,1);
            }
            LCD.drawChar('e',2,1);
            break;
          case 2:
            if (Score > upgrade1.UpgradeCost){
              upgrade1.increaseUpgradeMultiplier(1);
            } // end of if
            scoreBox.drawInhalt();
            break;
        }
      } // end of if
      //UI
      if (Button.RIGHT.isDown()) {
        selectedId ++;
        //waits 1 second
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        while (Button.RIGHT.isDown()) {
          selectedId ++;
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        } // end of if
        if (selectedId > maxId) {
          selectedId = 1;
        } // end of if
        scoreBox.drawBox();
        upgradebox1.drawBox();
      } // end of if
      if (Button.LEFT.isDown()) {
        selectedId = selectedId -1;
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          Thread.currentThread().interrupt();
        }
        while (Button.LEFT.isDown()) {
          selectedId = selectedId -1;
          try {
            Thread.sleep(100);
          } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
          }
        } // end of if
        if (selectedId <1) {
           selectedId = maxId;
        } // end of if
        scoreBox.drawBox();
        upgradebox1.drawBox();
      } // end of if
      LCD.drawInt(selectedId,4,4);
      switch (selectedId) {
        case 1:
          scoreBox.blinken();
          break;
        case 2:
          upgradebox1.blinken();
          break;
      }
      //add Select Table      
    }
  }
  // end methods
} // end of main
