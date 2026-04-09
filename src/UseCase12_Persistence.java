/**
 * UC12 - Test Persistence & Recovery
 */
public class UseCase12_Persistence {

    public static void main(String[] args) {

        RoomInventory inventory;
        BookingHistory history;

        // Load previous state
        Object[] data = PersistenceService.load();

        if (data != null) {
            inventory = (RoomInventory) data[0];
            history = (BookingHistory) data[1];
        } else {
            inventory = new RoomInventory();
            history = new BookingHistory();
        }

        BookingQueue queue = new BookingQueue();

        // Add bookings
        queue.addRequest(new Reservation("Anujaa", "Single Room"));

        BookingService service = new BookingService(queue, inventory, history);
        service.processBookings();

        // Save state
        PersistenceService.save(inventory, history);
    }
}