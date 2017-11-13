public class CoinDistributer{
  private Player currentPlayer;
  private int rewardAmount = 1;
  private boolean result;
  private int randomNumberRange = 10;
  private final int MULTIPLIER = 3;

  public CoinDistributer(){
  }

  public CoinDistributer(int difficulty){
    if(difficulty != 1){
      randomNumberRange = difficulty * MULTIPLIER * 10;
      rewardAmount = difficulty * MULTIPLIER;
    }
    else{
      randomNumberRange = 10;
      rewardAmount = 1;
    }
  }

  public void handleBettingGuess(Player player, int betAmount){
    int currentReward = rewardAmount;
    int currentRange = randomNumberRange;
    randomNumberRange = 10;
    rewardAmount = betAmount * MULTIPLIER;
    handleGuess(player);
    rewardAmount = currentReward;
    randomNumberRange = currentRange;
  }

  public int getNumberRange(){
    return randomNumberRange;
  }

  public void handleGuess(Player player){
    currentPlayer = player;
    int number = new Server(randomNumberRange).getRandomNumber();
    int guess = currentPlayer.getGuess();

    if( guess == number ){
      System.out.println("Correct Number! Enjoy a XternCoin!");
      dispenseCoin();
      result = true;
    }
    else{
      System.out.println("Incorrect Number, the correct number was " + number);
      result = false;
    }

    player.addToBackLog(new Attempt(guess, number, result));
  }

  private void dispenseCoin(){
    currentPlayer.addCoin(rewardAmount);
  }

}
