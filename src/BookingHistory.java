import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * UC8 - Booking History (UPDATED for UC12)
 */
public class BookingHistory implements Serializable {

    private List<Reservation> history;

    public BookingHistory() {
        history = new ArrayList<>();
    }

    public void addReservation(Reservation reservation) {
        history.add(reservation);
    }

    public List<Reservation> getAllReservations() {
        return history;
    }

    public void showHistory() {
        System.out.println("\n=== Booking History ===");

        for (Reservation r : history) {
            r.display();
        }
    }
}