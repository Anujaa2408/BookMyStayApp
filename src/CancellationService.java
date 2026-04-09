import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

public class CancellationService {

    private RoomInventory inventory;
    private HashMap<String, Set<String>> allocatedRooms;
    private Stack<String> rollbackStack;

    public CancellationService(RoomInventory inventory,
                               HashMap<String, Set<String>> allocatedRooms) {

        this.inventory = inventory;
        this.allocatedRooms = allocatedRooms;
        this.rollbackStack = new Stack<>();
    }

    public void cancelBooking(String roomType) {

        System.out.println("\n=== Cancellation Request ===");

        if (!allocatedRooms.containsKey(roomType) ||
                allocatedRooms.get(roomType).isEmpty()) {

            System.out.println("Cancellation Failed: No booking found");
            return;
        }

        // Get last room (LIFO)
        String roomId = null;
        for (String id : allocatedRooms.get(roomType)) {
            roomId = id;
        }

        allocatedRooms.get(roomType).remove(roomId);
        rollbackStack.push(roomId);

        int available = inventory.getAvailability(roomType);
        inventory.updateAvailability(roomType, available + 1);

        System.out.println("Cancelled Room ID: " + roomId);
    }
}