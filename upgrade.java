public class upgrade{
  int UpgradeId;
  double UpgradeMultiplier;
  int UpgradeCost;
  int BaseUpgradeCost;
  int howmanytimes;
  int BaseUpgradeMultiplier;
  private main bildi;
  public upgrade(int id,int BUC,int BUM,main bildi) {
    UpgradeId = id;
    BaseUpgradeCost = BUC;
    BaseUpgradeMultiplier = BUM;
    UpgradeCost = BaseUpgradeCost;
    UpgradeMultiplier = BaseUpgradeMultiplier;
    this.bildi = bildi;
  }
  public void increaseUpgradeMultiplier(int howmanytimes){
    while (howmanytimes >= 1) { 
      if (UpgradeMultiplier == 1) {
        UpgradeMultiplier = UpgradeMultiplier*2;
        bildi.Score = bildi.Score - UpgradeCost;
        increaseUpgradeCost();
      } else {
        UpgradeMultiplier = UpgradeMultiplier*UpgradeMultiplier;
        bildi.Score = bildi.Score - UpgradeCost;
        increaseUpgradeCost();
      } // end of if-else
      howmanytimes = howmanytimes-1;
    } // end of while
  }
  public void increaseUpgradeCost() {
    if (UpgradeCost == BaseUpgradeCost) {
      UpgradeCost = UpgradeCost*2;
    } else {
      UpgradeCost = UpgradeCost*UpgradeCost;  
    } // end of if-else
  } 
}