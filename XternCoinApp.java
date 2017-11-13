import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class XternCoinApp{
  private Scanner input = new Scanner(System.in);
  private Player player;
  private CoinDistributer distributer = new CoinDistributer();
  private XternStore store;
  private List<Player> playerList = new ArrayList<Player>();
  private boolean isContinue = true;

  public XternCoinApp(){
  }

  public void run(){
    gettingPlayerName();
    printInstructions();
    while(isContinue){
      menuSelection();
    }
  }

  private void gettingPlayerName(){
    System.out.print("\n\tWhat is the player's name?: ");
    player = new Player( input.next() );
    playerList.add(player);
  }

  private void printInstructions(){
    System.out.println("\n\t\tWelcome to XternCoin, " + player.getPlayerName()+ "!\n"
      + "\tAll you need to do is Guess our Random Number\n"
      + "\tGuess it correctly and you will earn a coin.\n"
      + "\tGuess incorrectly and just try again\n"
      + "\tCollect as many coins as you can to spend at store.\n\n");
  }

  private void menuSelection(){
    System.out.println("\n\t" + player.getPlayerName() + ", select an Option from the Menu:"
                    +"\n\t[1] Start Guessing  |  [2] Change Difficulty"
                    +"\n\t[3] Check Bank      |  [4] Store"
                    +"\n\t[5] Check Item Info |  [6] Bet X XternCoin(s)"
                    +"\n\t[7] Attempt Backlog |  [8] Create Player"
                    +"\n\t[9] Switch Player   |  [0] Quit");
    handleMenuSelection();
  }

  private void handleMenuSelection(){
    System.out.print("\nEnter your choice: ");
    int selection = input.nextInt();
    switch(selection){
      case 1:
        StartGuessing();
        break;
      case 2:
        configureDistributer();
        break;
      case 3:
        printCurrentPlayerBank();
        break;
      case 4:
        enterStore();
        break;
      case 5:
        getCurrentItemInfo();
        break;
      case 6:
        betXternCoins();
        break;
      case 7:
        printPlayerBackLog();
        break;
      case 8:
        createPlayer();
        break;
      case 9:
        switchPlayer();
        break;
      case 0:
        quitApp();
        break;
      default:
        System.out.println("Invalid Option");
        break;
    }
  }

  private void StartGuessing(){
      System.out.print("\n\n\tGuess a number between 1 and " + distributer.getNumberRange()
                      +"\nEnter your guess: ");
      player.setGuess( input.nextInt() );

      System.out.println( "You entered: " + player.getGuess() );

      distributer.handleGuess(player);
      printCurrentPlayerBank();
  }

  private void configureDistributer(){
    System.out.print("Increase the Challenge and Earn More Coins"
                    + "\n\t[1] Easy -> Guess Range: 1-10 | 1 XternCoin (Default)"
                    + "\n\t[2] Medium -> Guess Range: 1-60 | 6 XternCoin"
                    + "\n\t[3] Hard -> Guess Range: 1-90 | 12 XternCoin\n");
    boolean check = false;
    int answer;
    do{
      answer = input.nextInt();
      if (answer == 1 | answer == 2 | answer == 3){
          check = true;
      }
      else{
        System.out.println("Invalid Input.");
      }
    }while(check == false);

    distributer = new CoinDistributer( answer );
  }

  private void printCurrentPlayerBank(){
    System.out.println( player.getPlayerName() + ", your Current Bank is: " + player.getCoinBank() + " XternCoin(s).");
  };


  private void enterStore(){
      store = new XternStore(input);
      store.runStore(player);
  }

  private void getCurrentItemInfo(){
    List<XternSwag> swagList = player.getItemList();
    int itemWorth = 0;
    int netWorth = 0;
    System.out.println("\n" + player.getPlayerName() + " current Xtern swag obtained: ");

    for(int i = 0; i < swagList.size(); i++){
      XternSwag swag = swagList.get(i);
      System.out.println("XternSwag item" + i + ": [Swag Name: " + swag.getName() + " | Price: " + swag.getPrice() + " XternCoin(s)]");
      itemWorth += swag.getPrice();
    }
    netWorth = player.getCoinBank() + itemWorth;

    System.out.println("\n" + player.getPlayerName() + " your net worth is: " + netWorth + " XternCoin(s).\n");
  }

  private void betXternCoins(){
    System.out.println("\n\t\tBet some of your XternCoins!\n"
                    +"\tBet XternCoins and if you WIN Earn Triple the amount.\n"
                    +"\tGuess wrong and LOSE all the XternCoins you had bet.");
    System.out.print("Enter your bet: ");
    int betAmount = input.nextInt();

    if( isAbleToBet(betAmount) ){
      player.removeCoin(betAmount);
      System.out.print("\n\nEnter your guess: ");
      player.setGuess( input.nextInt() );
      distributer.handleBettingGuess(player, betAmount);
    }
    else{
      System.out.println("Unable to bet that amount. You do not have: " + betAmount + " XternCoin(s)\n"
                        +"Your current bank is: " + player.getCoinBank() + " XternCoin(s)\n");
    }
  }

  private boolean isAbleToBet(int betAmount){
    return betAmount <= player.getCoinBank();
  }

  private void printPlayerBackLog(){
    List<Attempt> backlog = player.getBackLog();

    System.out.println( player.getPlayerName() + " current backLog: ");
    for(int i = 0; i < backlog.size(); i++){
      Attempt attempt = backlog.get(i);
      System.out.println("Attempt" + i + " [Guess: "+ attempt.getGuess() + " | Number: " + attempt.getNumber() + " | Correct: " + attempt.getResult()+"]");
    }
  }

  private void createPlayer(){
    System.out.print("\n\tEnter a name for the new player: ");
    player = new Player( input.next() );
    playerList.add( player );
    printInstructions();
  }

  private void switchPlayer(){
    for(int i = 0; i < playerList.size(); i++){
      System.out.println("\t[" + i + "] " + playerList.get(i).getPlayerName());
    }
    System.out.print("\nSelect one of the players to switch to: ");
    int selectedPlayer = input.nextInt();

    if(selectedPlayer < 0 || selectedPlayer > playerList.size()-1){
      System.out.println("\nPlayer does not exist.");
    }
    else{
      player = playerList.get( selectedPlayer );
      System.out.println("\nCurrently playing as: " + player.getPlayerName());
    }
  }

  private void quitApp(){
    isContinue = false;
  }
}
