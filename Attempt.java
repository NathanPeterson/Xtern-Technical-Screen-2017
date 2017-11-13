public class Attempt{
  int guessNumber;
  int actualNumber;
  boolean isCorrect;

  public Attempt(int playerGuess, int serverNumber, boolean result){
    guessNumber = playerGuess;
    actualNumber = serverNumber;
    isCorrect = result;
  }

  public int getGuess(){
    return guessNumber;
  }
  public int getNumber(){
    return actualNumber;
  }
  public boolean getResult(){
    return isCorrect;
  }
}
