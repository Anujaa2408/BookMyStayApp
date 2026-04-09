/**
 * UC4 - Room Search Service (Read-only)
 */
public class SearchService {

    private RoomInventory inventory;

    public SearchService(RoomInventory inventory) {
        this.inventory = inventory;
    }

    public void searchAvailableRooms() {

        System.out.println("=== Available Rooms ===");

        // Create room objects (domain)
        Room[] rooms = {
                new SingleRoom(),
                new DoubleRoom(),
                new SuiteRoom()
        };

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.roomType);

            // Show only available rooms
            if (available > 0) {
                room.displayDetails();
                System.out.println("Available: " + available);
                System.out.println();
            }
        }
    }
}