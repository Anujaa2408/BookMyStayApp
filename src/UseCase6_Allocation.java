/**
 * UC6 - Test Booking Allocation
 */
public class UseCase6_Allocation {

    public static void main(String[] args) {

        BookingQueue queue = new BookingQueue();
        RoomInventory inventory = new RoomInventory();

        // Add booking requests
        queue.addRequest(new Reservation("Anujaa", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Single Room"));
        queue.addRequest(new Reservation("Priya", "Suite Room"));

        // Process bookings
        BookingService service = new BookingService(queue, inventory);
        service.processBookings();
    }
}