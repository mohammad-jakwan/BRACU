public class Student{
  public static int total_students;
  public static int cse_dept;
  public static int other_dept;
  public String name;
  public double cg;
  public static int id = 0;
  public String department;
  
  public Student(String x, double y){
    name=x;
    cg = y;
    total_students++;
    cse_dept++;
    id++;
  }
  
    public Student(String x, double y, String z){
    name=x;
    cg = y;
    department =z;
    total_students++;
    other_dept++;
    id++;
  }
  
    public void individualDetail(){
    System.out.println("ID: " + id);
    System.out.println("Name: " + name);
    System.out.println("CGPA: "+ cg);
    if (department== null){
      System.out.println("Department: CSE" );
    }
    else{
      System.out.println("Department: "+ department );
      
  }
    }
    public static Student createStudent(String nm, double cg, String d){
      Student A = new Student(nm, cg, d);
      return A;
}
   
  
  public static void printDetails(){
    System.out.println("Total Student(s): " + total_students);
    System.out.println("CSE Student(s): " + cse_dept);
    System.out.println("Other Department Student(s): " + other_dept);
  }
}
    
    