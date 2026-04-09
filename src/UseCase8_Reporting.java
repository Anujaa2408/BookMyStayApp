/**
 * UC8 - Test Booking History & Reporting
 */
public class UseCase8_Reporting {

    public static void main(String[] args) {

        BookingQueue queue = new BookingQueue();
        RoomInventory inventory = new RoomInventory();
        BookingHistory history = new BookingHistory();

        // Add requests
        queue.addRequest(new Reservation("Anujaa", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Double Room"));
        queue.addRequest(new Reservation("Priya", "Single Room"));

        // Process bookings
        BookingService service = new BookingService(queue, inventory, history);
        service.processBookings();

        // Show history
        history.showHistory();

        // Generate report
        BookingReportService reportService = new BookingReportService(history);
        reportService.generateReport();
    }
}