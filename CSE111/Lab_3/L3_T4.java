import java.util.Scanner;
public class L3_T4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int count = 1;
            System.out.println("Enter a string:");
            String str = sc.nextLine();
            String d = "";
            int leng = str.length();
            boolean e = false;
            for (int i = 0; i < leng; i++) {
                char ch = str.charAt(i);
                count = 0;
                for (int j = 0; j < leng; j++) {
                    if (ch == str.charAt(j) && !d.contains("" + ch)) {
                        count++;
                    }
                }
                if (count > 1) {
                    System.out.println("'" + ch + "' has been counted " + count + " times in the word " + str);
                    d += ch;
                    e = true;
                }
            }

            if (e == false) {
                System.out.println("You entered " + str);
                break;
            }
        }
    }
}