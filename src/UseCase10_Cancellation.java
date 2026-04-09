public class UseCase10_Cancellation {

    public static void main(String[] args) {

        BookingQueue queue = new BookingQueue();
        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();

        // Add bookings
        queue.addRequest(new Reservation("Anujaa", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Single Room"));

        // Process bookings
        BookingService service = new BookingService(queue, inventory, history);
        service.processBookings();

        // Cancel booking
        CancellationService cancel =
                new CancellationService(inventory, service.getAllocatedRooms());

        cancel.cancelBooking("Single Room");

        // Show updated inventory
        System.out.println("\nUpdated Inventory:");
        inventory.displayInventory();
    }
}