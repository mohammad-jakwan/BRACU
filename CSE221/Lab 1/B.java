import java.util.Scanner;
public class B {

    static String expr;
    static int pos;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = Integer.parseInt(sc.nextLine());
        for (int t = 0; t < T; t++) {
            String line = sc.nextLine();
            expr = line.substring("calculate ".length()).replaceAll(" ", "");
            pos = 0;
            double result = parseExpression();
            System.out.printf("%.6f%n", result);
        }

        sc.close();
    }
    static double parseExpression() {
        double result = parseTerm();
        while (pos < expr.length()) {
            char op = expr.charAt(pos);
            if (op == '+') {
                pos++;
                result += parseTerm();
            } else if (op == '-') {
                pos++;
                result -= parseTerm();
            } else {
                break;
            }
        }
        return result;
    }
    static double parseTerm() {
        double result = parseNumber();
        while (pos < expr.length()) {
            char op = expr.charAt(pos);
            if (op == '*') {
                pos++;
                result *= parseNumber();
            } else if (op == '/') {
                pos++;
                result /= parseNumber();
            } else {
                break;
            }
        }
        return result;
    }

    static double parseNumber() {
        int start = pos;
        while (pos < expr.length() && (Character.isDigit(expr.charAt(pos)) || expr.charAt(pos) == '.')) {
            pos++;
        }
        return Double.parseDouble(expr.substring(start, pos));
    }
}

