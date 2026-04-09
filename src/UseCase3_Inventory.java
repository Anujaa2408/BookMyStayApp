/**
 * UC3 - Test Inventory System
 */
public class UseCase3_Inventory {

    public static void main(String[] args) {

        RoomInventory inventory = new RoomInventory();

        // Display initial inventory
        inventory.displayInventory();

        System.out.println();

        // Example update
        inventory.updateAvailability("Single Room", 4);

        System.out.println("After Update:");

        inventory.displayInventory();
    }
}