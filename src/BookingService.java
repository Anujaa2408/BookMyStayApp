import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * UC6 + UC8 + UC9 - Booking Service
 * Handles allocation, history tracking, and validation
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

    // Process booking requests
    public void processBookings() {

        System.out.println("=== Processing Bookings ===");

        while (true) {

            Reservation request = queue.getNextRequest();

            if (request == null) {
                System.out.println("No more requests.");
                break;
            }

            try {
                // ✅ UC9: Validate request
                BookingValidator.validate(request, inventory);

                String roomType = request.roomType;
                int available = inventory.getAvailability(roomType);

                // Generate unique room ID
                String roomId = roomType.substring(0, 2).toUpperCase() + "_" + available;

                // Initialize set if not exists
                allocatedRooms.putIfAbsent(roomType, new HashSet<>());

                // Ensure uniqueness
                if (!allocatedRooms.get(roomType).contains(roomId)) {

                    allocatedRooms.get(roomType).add(roomId);

                    // ✅ Update inventory (UC6)
                    inventory.updateAvailability(roomType, available - 1);

                    // ✅ Store in history (UC8)
                    history.addReservation(request);

                    // Confirmation
                    System.out.println("Booking Confirmed:");
                    System.out.println("Guest: " + request.guestName);
                    System.out.println("Room Type: " + roomType);
                    System.out.println("Room ID: " + roomId);
                    System.out.println();
                }

            } catch (InvalidBookingException e) {
                // ✅ UC9: Graceful failure
                System.out.println("Booking Failed: " + e.getMessage());
            }
        }
    }
}