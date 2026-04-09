import java.util.LinkedList;
import java.util.Queue;

/**
 * UC5 - Booking Request Queue
 */
public class BookingQueue {

    private Queue<Reservation> queue;

    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Request added:");
        reservation.display();
    }

    // View all requests
    public void showQueue() {
        System.out.println("\n=== Booking Queue ===");

        for (Reservation r : queue) {
            r.display();
        }
    }
}