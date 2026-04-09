/**
 * UC2 - Basic Room Types & Static Availability
 */
public class UseCase2_RoomTypes {

    public static void main(String[] args) {

        System.out.println("=== UC2: Room Types & Availability ===");

        // Polymorphism
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display
        single.displayDetails();
        System.out.println("Available: " + singleAvailable);

        System.out.println();

        doubleRoom.displayDetails();
        System.out.println("Available: " + doubleAvailable);

        System.out.println();

        suite.displayDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}