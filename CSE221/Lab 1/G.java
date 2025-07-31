import java.util.Scanner;

public class G {
    static class Student {
        int mark;
        int id;

        Student(int mark, int id) {
            this.mark = mark;
            this.id = id;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] std = new int[n];
        int[] marks = new int[n];

        for (int i = 0; i < n; i++) {
            std[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }

        Student[] stdInfo = new Student[n];
        for (int i = 0; i < n; i++) {
            stdInfo[i] = new Student(marks[i], std[i]);
        }

        int sCount = 0;

        for (int i = 0; i < n; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (stdInfo[j].mark > stdInfo[maxIdx].mark ||
                    (stdInfo[j].mark == stdInfo[maxIdx].mark && stdInfo[j].id < stdInfo[maxIdx].id)) {
                    maxIdx = j;
                }
            }

            if (maxIdx != i) {
                Student temp = stdInfo[i];
                stdInfo[i] = stdInfo[maxIdx];
                stdInfo[maxIdx] = temp;
                sCount++;
            }
        }

        System.out.println("Minimum swaps: " + sCount);
        for (Student s : stdInfo) {
            System.out.println("ID: " + s.id + " Mark: " + s.mark);
        }
    }
}

