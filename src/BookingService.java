import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Booking Service
 * Handles booking allocation, validation, history, and exposes data for cancellation
 */
public class BookingService {

    private BookingQueue queue;
    private RoomInventory inventory;
    private BookingHistory history;

    // Track allocated rooms
    private HashMap<String, Set<String>> allocatedRooms;

    // Constructor
    public BookingService(BookingQueue queue, RoomInventory inventory, BookingHistory history) {
        this.queue = queue;
        this.inventory = inventory;
        this.history = history;
        this.allocatedRooms = new HashMap<>();
    }

    // Process bookings
    public void processBookings() {

        System.out.println("=== Processing Bookings ===");

        while (true) {

            Reservation request = queue.getNextRequest();

            if (request == null) {
                System.out.println("No more requests.");
                break;
            }

            try {
                // ✅ UC9: Validation
                BookingValidator.validate(request, inventory);

                String roomType = request.roomType;
                int available = inventory.getAvailability(roomType);

                // Generate room ID
                String roomId = roomType.substring(0, 2).toUpperCase() + "_" + available;

                // Initialize set
                allocatedRooms.putIfAbsent(roomType, new HashSet<>());

                // Ensure uniqueness
                if (!allocatedRooms.get(roomType).contains(roomId)) {

                    allocatedRooms.get(roomType).add(roomId);

                    // ✅ UC6: Update inventory
                    inventory.updateAvailability(roomType, available - 1);

                    // ✅ UC8: Save to history
                    history.addReservation(request);

                    System.out.println("Booking Confirmed:");
                    System.out.println("Guest: " + request.guestName);
                    System.out.println("Room Type: " + roomType);
                    System.out.println("Room ID: " + roomId);
                    System.out.println();
                }

            } catch (InvalidBookingException e) {
                // ✅ UC9: Graceful error
                System.out.println("Booking Failed: " + e.getMessage());
            }
        }
    }

    // ✅ UC10: Getter for cancellation service
    public HashMap<String, Set<String>> getAllocatedRooms() {
        return allocatedRooms;
    }
}