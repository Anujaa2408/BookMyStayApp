/**
 * UC9 - Test Error Handling
 */
public class UseCase9_ErrorHandling {

    public static void main(String[] args) {

        BookingQueue queue = new BookingQueue();
        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();

        // Valid request
        queue.addRequest(new Reservation("Anujaa", "Single Room"));

        // Invalid request (wrong room type)
        queue.addRequest(new Reservation("Rahul", "Deluxe Room"));

        // Invalid request (empty name)
        queue.addRequest(new Reservation("", "Suite Room"));

        // Process bookings
        BookingService service = new BookingService(queue, inventory, history);
        service.processBookings();
    }
}