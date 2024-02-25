public class Task7
{
  public static void main(String[] args)
  {
    double my_id = 1799;
    double distance_km = (my_id/1000);
    double distance_mile = (my_id/1609);
    double time = (5.0 + (56.0/60) + (23.0/(60*60)));
    double velocity_km = distance_km/time;
    double velocity_mile = distance_mile/time;
     
      
    System.out.println("Your velocity in km/h is "+velocity_km);
    System.out.println("Your velocity in miles/h is "+velocity_mile);
 
   }
 }