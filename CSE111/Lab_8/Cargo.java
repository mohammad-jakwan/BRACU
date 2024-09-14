public class Cargo{
  public static double capacity = 10;
  public static int id;
  public Boolean flag = false;
  public String content;
  public double weight;
  
  
  public Cargo(String x,double y ){
    content=x;
    weight = y;
    id++;
    flag = false;
  }
    public static double capacity(){
    return capacity;
  }
  
  public void load(){ 
    if (capacity>=weight){
      flag = true;
      capacity-= weight;
      System.out.println("Cargo "+ id +" loaded for transport.");
    }
    else{
      System.out.println("Cannot load cargo, exceeds weight capacity.");
    }
  }
  
  public void unload(){
    capacity+=weight;
    System.out.println("Cargo"+id+" unloaded.");
    flag = false;
  }
  
    public void details(){
      System.out.print("Cargo ID : " + id + ", ");
      System.out.print("Contents: " +content + ", ");
      System.out.print("Weight: "+ weight + ", ");
      System.out.println("Loaded: "+ flag);
    }
}