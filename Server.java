import java.util.Random;

public class Server{
  private int number;
  private Random random = new Random();
  private int numberRangeMax;

  public Server(int rangeMax){
    numberRangeMax = rangeMax;
    generateRandomNumber();
  }

  public void generateRandomNumber(){
    number = random.nextInt(numberRangeMax) + 1;
  }

  public int getRandomNumber(){
    return number;
  }
}
