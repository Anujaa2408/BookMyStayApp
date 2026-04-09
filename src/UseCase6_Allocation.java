/**
 * UC6 - Test Booking Allocation
 */
public class UseCase6_Allocation {

    public static void main(String[] args) {

        // Create objects
        BookingQueue queue = new BookingQueue();
        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory(); // ✅ NEW (important)

        // Add booking requests
        queue.addRequest(new Reservation("Anujaa", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Single Room"));
        queue.addRequest(new Reservation("Priya", "Suite Room"));

        // Process bookings (UPDATED constructor)
        BookingService service = new BookingService(queue, inventory, history);
        service.processBookings();

        // Optional: show history (to verify UC8 integration)
        System.out.println("\n--- Booking History ---");
        history.showHistory();
    }
}