public class Smartphone{
  public String name;
  public String [] fn = new String [3];
  public String [] f = new String [3];
  public int count=0;
  
  public Smartphone(){
  } 
  public Smartphone(String x){
    name=x;
  }
  
  
  public void addFeature(String x, String y){
    if (this.name==null){
      System.out.println("Feature can not be added without phone name");
    }
    else{
      for (int i = 0; i<3; i++){
        if (fn[i].equals(x)){
          f[i]+= " ," + y;
        }
      }
      fn[count]=x;
      f[count]=y;
      count++;
        
      
    }    
  }
  public void updateName(String x){
    name =x;
  }
  
  public void printDetail(){
    System.out.println("Name: " + name);
    for (int i= 0; i< fn.length; i++){
      System.out.println(fn[i]+ " "+ f[i]);
    }
  }
}
      
  
      