import java.util.Scanner;
public class L6T5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the height of the triangle: ");
        int height = scanner.nextInt();
        for (int i = 1; i <= height; i++) {        
            for (int j = height - i; j > 0; j--) {
                System.out.print(" ");
            }
            System.out.print(1);
            if (i < height){
                int j;
                for (j = 1; j < 2*(i - 1); j++){             
                    System.out.print(" ");
                }
                if (i != 1){
                    System.out.println(j);
                }
                else{
                    System.out.println(" ");
                }
            }          
            else if (i == height){
                int j;
                for (j = 2; j <= 2*(height-1); j++){
                    System.out.print(j);
                }
                System.out.println(j);
            }  
        }   
    }}