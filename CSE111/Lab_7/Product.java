public class Product{
  private String name;
  private double price;
  private int quantity;
  
  public void displayInfo(){
      System.out.println("Product Name: Unknown");
      System.out.println("Price: $0.0");
    }
  
    public void displayInfo(Boolean x){
    if (x = true){
      System.out.println("Product Name: "+ name);
      System.out.println("Price: "+ price);
      System.out.println("Quantity: "+ quantity);
    }
  }
    
    public Product(){
    }
  
    public Product (String x, double y ){
    name = x;
    price = y;
  }
    
  public void setQuantity(int x){
    quantity = x;
  }

  public double getPrice(){
    return price;
  }
  public int getQuantity(){
    return quantity;
  }
}
  