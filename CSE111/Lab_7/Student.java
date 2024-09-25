public class Student{
    private int id;
    private double cgpa;
    private String[] courses;
    private int count;
    private boolean flag;

    public Student(int x){
        id =x;
        courses = new String[4];
        count = 0;
        flag = false;
    }

    public Student(int x, double y){
        id = x;
        cgpa = y;
        courses = new String[4]; 
        count =0;
        flag = true;
    }

    public void setID(int x){
        id = x;
    }

    public void setCG(double x){
        cgpa =x ;
        flag = true;
    }

    public void addCourse(String course){
        if (!flag){
            System.out.println("Failed to add " + course);
            System.out.println("Set CG first");
        }
        if (cgpa < 3.0 && count >= 3){
            System.out.println("Failed to add " + course);
            System.out.println("CG is low. Can't add more than 3 courses.");   
        }
        if (count >= 4){
            System.out.println("Failed to add " + course);
            System.out.println("Maximum 4 courses allowed.");
        }
        courses[count] = course;
        count++;
    }

    public void addCourse(String[] arr){
      for (int i = 0; i < arr.length; i++){
        addCourse(arr[i]);
      }
    }

    public void rmAllCourse(){
        for (int i = 0; i < count; i++){
            courses[i] = null;
        }
        count = 0;
    }

    public void showAdvisee() {
        System.out.println("Student ID: " + id + ", CGPA: " + cgpa);
        if (count == 0){
            System.out.println("No courses added.");
        } 
        else{
            System.out.print("Added courses are: ");
            for (int i = 0; i < count; i++) {
                System.out.print(courses[i] + " ");
            }
        }
    }
}
