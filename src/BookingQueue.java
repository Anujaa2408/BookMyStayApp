import java.util.LinkedList;
import java.util.Queue;

/**
 * UC5 & UC6 - Booking Request Queue
 */
public class BookingQueue {

    private Queue<Reservation> queue;

    // Constructor
    public BookingQueue() {
        queue = new LinkedList<>();
    }

    // Add booking request
    public void addRequest(Reservation reservation) {
        queue.add(reservation);
        System.out.println("Request added:");
        reservation.display();
    }

    // NEW METHOD (for UC6) → Get next request (FIFO)
    public Reservation getNextRequest() {
        return queue.poll(); // removes and returns first element
    }

    // Show all requests
    public void showQueue() {
        System.out.println("\n=== Booking Queue ===");

        for (Reservation r : queue) {
            r.display();
        }
    }

    // Check if queue is empty (optional but useful)
    public boolean isEmpty() {
        return queue.isEmpty();
    }
}