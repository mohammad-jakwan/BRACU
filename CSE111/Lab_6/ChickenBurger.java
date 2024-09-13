public class ChickenBurger{
  public String bun = "Sesame";
  public int price = 200;
  public String sauceOption = "Less";
  public String spiceLevel = "Not Set";
  public String[] levels = {"Mild", "Spicy", "Naga", "Extreme"};
 
  public String serveBurger(){
    if (spiceLevel.equals("Not Set")){
      return "Cannot serve now. Customize Spice Level first.";
    }
    else{
      return "The burger is being served:-\n Bun Type: "+ bun+ "\n Price: "+ price+ "\n Sauce Option:"+ sauceOption+ "\n Spice Level:"+ spiceLevel;
    }
      
  }
  
  public void customizeSpiceLevel(String x){
    for (int i = 0; i < levels.length; i++) {
      if (levels[i].equals(x)){
        System.out.println("Spice level set to "+ x+".");
        spiceLevel = x;
        return;
      }  
    }
    System.out.println("This spice level is unavailable.");       
  }
}