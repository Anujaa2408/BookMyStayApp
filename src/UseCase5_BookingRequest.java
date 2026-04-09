/**
 * UC5 - Test Booking Request Queue
 */
public class UseCase5_BookingRequest {

    public static void main(String[] args) {

        BookingQueue queue = new BookingQueue();

        // Add requests (FIFO order)
        queue.addRequest(new Reservation("Anujaa", "Single Room"));
        queue.addRequest(new Reservation("Rahul", "Double Room"));
        queue.addRequest(new Reservation("Priya", "Suite Room"));

        // Display queue
        queue.showQueue();
    }
}