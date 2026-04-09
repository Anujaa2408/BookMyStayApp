/**
 * UC11 - Test Concurrent Booking
 */
public class UseCase11_Concurrent {

    public static void main(String[] args) {

        BookingQueue queue = new BookingQueue();
        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();

        // Add multiple requests
        queue.addRequest(new Reservation("Anujaa", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Single Room"));
        queue.addRequest(new Reservation("Priya", "Single Room"));
        queue.addRequest(new Reservation("Kiran", "Single Room"));

        // Shared booking service
        BookingService service = new BookingService(queue, inventory, history);

        // Create threads
        Thread t1 = new ConcurrentBookingProcessor(service);
        Thread t2 = new ConcurrentBookingProcessor(service);

        // Start threads
        t1.start();
        t2.start();
    }
}