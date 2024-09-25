public class Passenger{
  public static int no_of_passenger;
  public static double total_fare;
  public String name;
  public double fare;
  
  public Passenger(String x, double y){
    name=x;
    fare = y*20;
    no_of_passenger++;
    total_fare+=y*20;
  }
  
  public void setBaggageWeight(double x){
    fare += x*10;
    total_fare+=x*10;
  }
  
  public void passengerDetails(){
    System.out.println("Name: " + name);
    System.out.println("Fare: " + fare + " TK");
  }
}
    
    