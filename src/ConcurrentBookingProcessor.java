/**
 * UC11 - Concurrent Booking Processor (Thread)
 */
public class ConcurrentBookingProcessor extends Thread {

    private BookingService service;

    public ConcurrentBookingProcessor(BookingService service) {
        this.service = service;
    }

    @Override
    public void run() {
        // Each thread processes bookings
        service.processBookings();
    }
}