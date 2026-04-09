import java.util.HashMap;
import java.util.Set;
import java.util.Stack;

/**
 * UC10 - Cancellation Service
 */
public class CancellationService {

    private RoomInventory inventory;
    private BookingHistory history;

    // Track allocated rooms (same structure as BookingService)
    private HashMap<String, Set<String>> allocatedRooms;

    // Stack for rollback (LIFO)
    private Stack<String> rollbackStack;

    public CancellationService(RoomInventory inventory,
                               BookingHistory history,
                               HashMap<String, Set<String>> allocatedRooms) {

        this.inventory = inventory;
        this.history = history;
        this.allocatedRooms = allocatedRooms;
        this.rollbackStack = new Stack<>();
    }

    // Cancel booking
    public void cancelBooking(String roomType) {

        System.out.println("\n=== Cancellation Request ===");

        // Validate existence
        if (!allocatedRooms.containsKey(roomType) ||
                allocatedRooms.get(roomType).isEmpty()) {

            System.out.println("Cancellation Failed: No active booking found for " + roomType);
            return;
        }

        // LIFO → get last allocated room
        String roomId = allocatedRooms.get(roomType)
                .stream()
                .reduce((first, second) -> second)
                .orElse(null);

        // Remove from allocated
        allocatedRooms.get(roomType).remove(roomId);

        // Push to rollback stack
        rollbackStack.push(roomId);

        // Restore inventory
        int current = inventory.getAvailability(roomType);
        inventory.updateAvailability(roomType, current + 1);

        System.out.println("Booking Cancelled:");
        System.out.println("Room Type: " + roomType);
        System.out.println("Released Room ID: " + roomId);
    }
}