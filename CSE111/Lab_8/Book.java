public class Book{
  public static int total_books_sold;
  public static double total_revenue=0;
  public String name;
  public double price = 150;
  
  public Book (String x, int y){
    name= x;
    price = price - (price * y/100);
    total_books_sold++;
    total_revenue += price;
  }
  
  public void bookDetails(){
    System.out.println("Title: " + name);
    System.out.println("Price after Discount: ");
    System.out.println(price);
  }
}