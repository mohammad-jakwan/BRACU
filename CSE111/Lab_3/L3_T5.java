import java.util.Scanner;
public class L3_T5{
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("PLease enter String 1:");
        String a=sc.nextLine();
        System.out.println("PLease enter String 2:");
        String b=sc.nextLine();
        int sum=0;
 

        String c=" ";
        String d=a+c+b;

        for(int i=0;i<d.length();i++){
          int f = d.codePointAt(i);
            if((f>=65 && f<=90) || (f>=97 && f<=122)){
              sum=sum+f;
            }
     }
        System.out.println(d);
        System.out.println(sum);

    }
}