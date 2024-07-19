import java.util.Scanner;
public class L3_T6{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Please enter a String:");
        String input=sc.nextLine();

        String empty="";
        int j=0;
        System.out.print(input.charAt(j));
        for(int i=0;i<input.length();i++){
            if(input.charAt(i)!= input.charAt(j)){
                empty+=input.charAt(i);
                j=i;
            }
        }
        System.out.println(empty);
    }
}