import java.util.ArrayList;
import java.util.List;

/**
 * UC8 - Booking History
 */
public class BookingHistory {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    // Add confirmed reservation
    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    // Get all bookings
    public List<Reservation> getAllReservations() {
        return history;
    }

    // Display history
    public void showHistory() {
        System.out.println("\n=== Booking History ===");

        for (Reservation r : history) {
            r.display();
        }
    }
}