public class MobilePhone{ 
  public int capacity;
  public String[] names; 
  public int[] numbers; 
  public int count; 
  
  public void setContactCapacity(int x){
    capacity = x;
    names = new String[x]; 
    numbers = new int[x]; 
  }
    
    public void details(){
      System.out.println("Total contacts: "+ count);
      System.out.println("Contact list: "); 
      if(count>0){
        for(int i=0;i<names.length;i++){
        System.out.println(names[i] + ":" + numbers[i]);
        }
      }
    }
        public void addContact(String name, int num){ 
          if(count<capacity){
            System.out.println("The contact of "+ name + " is added.");
            names[count] = name;
            numbers[count] = num; 
            count++;
          }
            else{
              System.out.println("Storage Full!!"); 
            }
        }
              public void makeCall(int num){ 
                boolean checker = false;
                for(int i = 0; i<numbers.length; i++){
                  if(num == numbers[i]){ 
                    System.out.println("Calling "+ names[i] + "...");
                    checker = true; 
                    break;
                  }
                }
                if(!checker){
                  System.out.println("Calling "+num + "...");
                }
              }
}
                        