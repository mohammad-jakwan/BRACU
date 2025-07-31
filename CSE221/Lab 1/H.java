import java.util.Scanner;
public class H {
    

    static class Train {
        String name;
        int negDepartureMinutes;
        int index;
        String fullInfo;

        Train(String name, int negDepartureMinutes, int index, String fullInfo) {
            this.name = name;
            this.negDepartureMinutes = negDepartureMinutes;
            this.index = index;
            this.fullInfo = fullInfo;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = Integer.parseInt(sc.nextLine());
        Train[] listTrain = new Train[n];

        for (int i = 0; i < n; i++) {
            String trainInfo = sc.nextLine();
            String[] parts = trainInfo.split(" ");

            String name = parts[0];
            int j = 1;
            for (; j < parts.length; j++) {
                if (parts[j].equals("will")) {
                    break;
                }
                name += parts[j];
            }

            String departureTime = parts[parts.length - 1];
            String[] timeParts = departureTime.split(":");
            int hours = Integer.parseInt(timeParts[0]);
            int minutes = Integer.parseInt(timeParts[1]);
            int departureMinutes = hours * 60 + minutes;

            listTrain[i] = new Train(name, -departureMinutes, i, trainInfo);
        }

        for (int x = 1; x < listTrain.length; x++) {
            Train key = listTrain[x];
            int y = x - 1;

            while (y >= 0 &&
                   (listTrain[y].name.compareTo(key.name) > 0 ||
                    (listTrain[y].name.equals(key.name) && listTrain[y].negDepartureMinutes > key.negDepartureMinutes) ||
                    (listTrain[y].name.equals(key.name) && listTrain[y].negDepartureMinutes == key.negDepartureMinutes && listTrain[y].index > key.index))) {

                listTrain[y + 1] = listTrain[y];
                y--;
            }
            listTrain[y + 1] = key;
        }


        for (Train t : listTrain) {
            System.out.println(t.fullInfo);
        }

    }
}
