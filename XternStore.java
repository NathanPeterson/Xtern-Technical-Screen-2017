import java.util.Scanner;

public class XternStore{
  private XternSwag[] storeList = {new XternSwag("Xtern Pin", 1),
                                   new XternSwag("Xtern Pen", 5),
                                   new XternSwag("Xtern Laptop Decal", 15),
                                   new XternSwag("Xtern Water Bottle", 50),
                                   new XternSwag("Xtern T-Shirt", 100)};
  private Player currentPlayer;
  private Scanner input;
  private boolean isContinue;

  public XternStore(Scanner scanner){
    input = scanner;
  }

  public void runStore(Player player){
    currentPlayer = player;
    printStoreInstructions();
    isContinue = true;
    while(isContinue){
      handleStoreSelection();
    }
  }

  private void printStoreInstructions(){
    System.out.println("\t**   Welcome to the XternStore, " + currentPlayer.getPlayerName()
                    + "\n\t  Check out some of this Awesome Xtern Swag!\n"
                    + "\n\tSelect a piece of Swag from the Store to buy it:");

    for(int i = 1; i <= storeList.length; i++){
      System.out.println("\t["+ (i) + "]" + storeList[i-1].getName() + "  -->  " + storeList[i-1].getPrice() + " XternCoin(s)");
      if(i == storeList.length){
          System.out.println("\t["+ (i+1) + "] Leave Store");
      }
    }
  }

  private void handleStoreSelection(){
    System.out.print("\nEnter your choice: ");
    int selection = input.nextInt();
    switch(selection){
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
        handleBuySwag(selection);
        break;
      case 6:
        isContinue = false;
        break;
      default:
        System.out.println("Invalid Option");
        break;
    }
  }

  private void handleBuySwag(int itemNumber){
    if(isPlayerAbleToBuy(itemNumber)){
      currentPlayer.addToItemList(storeList[itemNumber - 1]);
      currentPlayer.removeCoin(storeList[itemNumber - 1].getPrice());
      printSuccessPurchased(itemNumber);
      isContinue = false;
    }
    else{
      printFailPurcased(itemNumber);
    }
  }

  private boolean isPlayerAbleToBuy(int item){
    return storeList[item - 1].getPrice() <= currentPlayer.getCoinBank();
  }

  private void printSuccessPurchased(int itemNumber){
    System.out.println("\n" + currentPlayer.getPlayerName() + " you have successfully purchased: "
                      + storeList[itemNumber - 1].getName() + " for " + storeList[itemNumber -1].getPrice() + " XternCoin(s).\n"
                      +"Your current bank ballance is: " + currentPlayer.getCoinBank() + " XternCoin(s).\n");
  }
  private void printFailPurcased(int itemNumber){
    System.out.println("\n" + currentPlayer.getPlayerName() + " you do not have enough coins in your bank.\n"
                      +"The Price to buy " + storeList[itemNumber - 1].getName() + " is: " + storeList[itemNumber -1].getPrice() + " XternCoin(s).\n"
                      +"Your current bank ballance is: " + currentPlayer.getCoinBank() + " XternCoin(s).\n");
  }

}
