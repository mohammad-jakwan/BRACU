public class Book{
  private String name;
  private String author;
  private int price;
  
  public Book (String x ){
    name = x;
  }
  
    public Book (String x, String y ){
    name = x;
    author = y;
  }
    public Book (String x, String y, int z ){
    name = x;
    author = y;
    price = z;
  }
  
  public void displayDetails(){
    if (author == null && price ==0 ){
      System.out.println("Title: "+ name);
    }
    else if  (price == 0){
      System.out.println("Title: "+ name+ ", Author: " + author);
    }
    else if ( author == null ) {
      System.out.println("Title: "+ name+ ", Price: "+ price);
    }
    else{
      System.out.println("Title: "+ name+ ", Author: " + author+ ", Price: "+ price);
    }
  }
  public void setDetails(int x){
    price = x;
  }

  public void setDetails(String y,int x){
    price = x;
    author = y;
  }
}
  