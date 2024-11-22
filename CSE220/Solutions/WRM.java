public class WRM {
    Patient dh; // Dummy Head for Doubly Circular Linked List

    public WRM() {
        dh = new Patient(null, null, null, null, null, null);
        dh.next = dh;
        dh.prev = dh;
    }

    // Register a new patient
    public void registerPatient(int id, String name, int age, String bloodGroup) {
        Patient newPatient = new Patient(id, name, age, bloodGroup, dh, dh.prev);
        dh.prev.next = newPatient; // Add to the end of the list
        dh.prev = newPatient;
        System.out.println("Patient registered successfully.");
    }

    // Serve the first patient
    public void servePatient() {
        if (dh.next == dh) {
            System.out.println("No patients to serve.");
        } else {
            Patient toServe = dh.next; // First patient
            System.out.println("Serving patient: " + toServe.name);
            dh.next = toServe.next;
            toServe.next.prev = dh; // Update links
        }
    }

    // Show all patients in the list
    public void showAllPatient() {
        if (dh.next == dh) {
            System.out.println("No patients in the waiting room.");
        } else {
            Patient current = dh.next;
            System.out.println("Patients in the waiting room:");
            while (current != dh) {
                System.out.println(current);
                current = current.next;
            }
        }
    }

    // Check if the doctor can go home
    public boolean canDoctorGoHome() {
        return dh.next == dh;
    }

    // Cancel all appointments
    public void cancelAll() {
        dh.next = dh;
        dh.prev = dh;
        System.out.println("All appointments canceled.");
    }

    // Reverse the patient line
    public void reverseTheLine() {
        if (dh.next == dh) {
            System.out.println("No patients to reverse.");
            return;
        }
        Patient current = dh.next;
        Patient temp = null;

        // Swap next and prev for all nodes
        do {
            temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            current = temp;
        } while (current != dh);

        // Update dummy head pointers
        temp = dh.next;
        dh.next = dh.prev;
        dh.prev = temp;

        System.out.println("Patient line reversed successfully.");
    }
}
