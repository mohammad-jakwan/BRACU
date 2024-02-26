import java.util.Scanner;

public class Lab3t4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int studentID = scanner.nextInt();

        int year = studentID / 1000000;
        int temp = (studentID / 100000) ;
        int ses = temp%10;

        String session="";
        if (ses == 1) {
            session = "Spring";
        } else if (ses == 3) {
            session = "Summer";
        } else if (ses == 2) {
            session = "Fall";
        } 

        System.out.println("Student Joined BRAC in " + session + " " + year);
    }
}