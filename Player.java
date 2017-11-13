import java.util.List;
import java.util.ArrayList;

public class Player{
  private String nameOfPlayer;
  private int currentGuess;
  private int coinBank;
  private List<Attempt> backLog = new ArrayList<Attempt>();
  private List<XternSwag> itemList = new ArrayList<XternSwag>();

  public Player(){}

	public Player(String name) {
        nameOfPlayer = name;
        currentGuess = 0;
        coinBank = 0;
  }

	public String getPlayerName(){
		return nameOfPlayer;
	}

  public void setGuess(int guess){
    currentGuess = guess;
  }

  public int getGuess(){
    return currentGuess;
  }

  public void addCoin(int number){
    coinBank += number;
  }

  public void removeCoin(int number){
    coinBank -= number;
    if (coinBank < 0 ){
      coinBank = 0;
    }
  }

  public int getCoinBank(){
    return coinBank;
  }

  public void addToBackLog(Attempt attempt){
    backLog.add(attempt);
  }

  public List<Attempt> getBackLog(){
    return backLog;
  }

  public void addToItemList(XternSwag swag){
    itemList.add(swag);
  }

  public List<XternSwag> getItemList(){
    return itemList;
  }

}
