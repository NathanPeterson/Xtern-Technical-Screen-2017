public class XternSwag{
  private String itemName;
  private int itemCost;

  public XternSwag(String name, int price){
    itemName = name;
    itemCost = price;
  }

  public int getPrice(){
    return itemCost;
  }

  public String getName(){
    return itemName;
  }
}
