import java.util.Arrays;

public class TaskDistribution {
    public static int[] distributeTasks(int[] tasks, int m) {
        
        int[] loads = new int[m];
        for (int i = 0; i < loads.length; i++) {
            loads[i] = 0;
        }

        for (int task : tasks){
            int minIndex = 0;
            for (int i = 1; i < m; i++) {
                if (loads[i] < loads[minIndex]) {
                    minIndex = i;
                }
            }
            loads[minIndex] += task;
        }

        return loads;
    }

}
