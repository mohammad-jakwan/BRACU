public class Parcel{
  public String name;
  public int weight;
  private double fee;
 
  public Parcel(){
  }

  public Parcel(String s){
    name = s;
  }
    public Parcel(String s, int y){
    name = s;
    weight= y;
  }
    public void addWeight(int x){
      weight+=x;
      System.out.println("Updated Weight: " + weight);
    }
  
  
  public void calcFee(String x){
    if (x.equals("Dhanmondi")){
       fee = (weight * 20) + 50;
    }
    else{
      fee = (weight * 20) ;
    }
  }
  
  public void printDetails(){
    if (name==null){
      System.out.println("Set name first");
    }
    else{
      System.out.println("Name: "+ name);
      System.out.println("Total Weight: "+ weight);
      System.out.println("Total Fee: "+ fee);
    }
  }
  
}