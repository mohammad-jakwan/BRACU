public class Toy{
  public String name;
  private int price;
    
  public Toy( String x, int y){
    System.out.println("A new toy has been made!");
    name = x;
    price = y;
  }
  
  public void updatePrice( int x){
    price = x;
  }
  
      
  public void updateName( String x){
    System.out.println("Changing old name: " +name);
    name = x;
    System.out.println("New name: " +name);
  }
    public void showPrice(){
    System.out.println( "price: "+price + " Taka");
  }
}