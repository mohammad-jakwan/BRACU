import java.util.Scanner;

public class Lab3t7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Amount Customer need to pay (Taka): ");
        int pay = scanner.nextInt();
        System.out.print("Enter Amount Customer Gave (Taka): ");
        int given = scanner.nextInt();

        if ( pay < given) {
            int change = given - pay;
            System.out.println("The returned amount is " + change + " TAKA.");
            
            int note100 = 0, note50 = 0, note20 = 0, note10 = 0, coin5 = 0, coin2 = 0, coin1 = 0;

            if (change >= 100) {
                note100 = change / 100;
                change = change % 100;
            }
            if (change >= 50) {
                note50 = change / 50;
                change = change % 50;
            }
            if (change >= 20) {
                note20 = change / 20;
                change = change % 20;
            }
            if (change >= 10) {
                note10 = change / 10;
                change = change % 10;
            }
            if (change >= 5) {
                coin5 = change / 5;
                change = change % 5;
            }
            if (change >= 2) {
                coin2 = change / 2;
                change = change % 2;
            }
            if (change >= 1) {
                coin1 = change;
            }

            System.out.println("100 TAKA note : " + note100);
            System.out.println("50 TAKA note : " + note50);
            System.out.println("20 TAKA note : " + note20);
            System.out.println("10 TAKA note : " + note10);
            System.out.println("5 TAKA coin : " + coin5);
            System.out.println("2 TAKA coin : " + coin2);
            System.out.println("1 TAKA coin : " + coin1);

        } else if (given< pay) {
            System.out.println("Please pay " + (pay - given) + " taka more.");
        } else {
            System.out.println("The required amount is 0 TAKA.");
        }
    }
}
