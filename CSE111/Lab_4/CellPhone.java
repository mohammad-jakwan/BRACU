public class CellPhone{
  String model= "unknown";
  String[] contacts = new String[3]; 
  int count =0;
  
  public void storeContact(String s){
    if (count<3){
      contacts[count]= s;
      count++;
      System.out.println("Contact Stored");
      
    }
    else{
      System.out.println("Memory full. New contact can't be stored.");
    }
  }
    
    public void printDetails(){
      System.out.println("Phone Model "+model);
      System.out.println("Contacts Stored " + count );
      if (count>0){
      System.out.println("Stored Contacts:");
      
      for (int i =0; i <count; i++){
        System.out.println(contacts[i]);
      }
      }
    }
}