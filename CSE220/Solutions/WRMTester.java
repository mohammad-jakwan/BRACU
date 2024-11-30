import java.util.Scanner;

public class WRMTester {
    public static void main(String[] args) {
        WRM wrm = new WRM();
        Scanner scanner = new Scanner(System.in);
        String choice;

        System.out.println("** Welcome to Waiting Room Management System **");

        do {
            System.out.println("\nMenu:");
            System.out.println("a. Add Patient");
            System.out.println("b. Serve Patient");
            System.out.println("c. Show All Patients");
            System.out.println("d. Can Doctor Go Home?");
            System.out.println("e. Cancel All Appointments");
            System.out.println("f. Reverse The Line");
            System.out.println("g. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextLine();

            switch (choice.toLowerCase()) {
                case "a": // Add Patient
                    System.out.print("Enter Patient ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Patient Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Patient Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    System.out.print("Enter Patient Blood Group: ");
                    String bloodGroup = scanner.nextLine();
                    wrm.registerPatient(id, name, age, bloodGroup);
                    break;

                case "b": // Serve Patient
                    wrm.servePatient();
                    break;

                case "c": // Show All Patients
                    wrm.showAllPatient();
                    break;

                case "d": // Can Doctor Go Home?
                    if (wrm.canDoctorGoHome()) {
                        System.out.println("Yes, the doctor can go home.");
                    } else {
                        System.out.println("No, patients are still waiting.");
                    }
                    break;

                case "e": // Cancel All Appointments
                    wrm.cancelAll();
                    break;

                case "f": // Reverse The Line
                    wrm.reverseTheLine();
                    break;

                case "g": // Exit
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (!choice.equalsIgnoreCase("g"));

        scanner.close();
    }
}
