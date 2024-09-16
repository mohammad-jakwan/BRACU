public class Cat extends Animal{
  public String type;
  
  public Cat(String x, int a, String y, String z){
    super(x,a,y);
    type=z;
  }
  
  public String info(){
    return super.info()+"Breed: " +type;
  }
  
  public void makeSound(){
    System.out.println(super.color+ " color " + super.name+ " is meowing.");
  }
}
  