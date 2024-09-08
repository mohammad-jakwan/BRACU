public class Shelf{
  
  public int capacity =0 ;
  public int books = 0;
 
  public void showDetails(){
    System.out.println("Shelf Capacity: "+capacity);
    System.out.println("Number of books: "+ books);
  }
  
  public void addBooks(int x){
    if (capacity-books <= 0){
      System.out.println("Zero capacity. Cannot add books.");
    }
                         
    else if (capacity>books+x){
      System.out.println(x+" books added to shelf");
      books += x;
    }
    else{
      System.out.println("Exceeds capacity");
    }
  }
    
    
}