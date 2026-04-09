import java.util.HashMap;
import java.util.List;

/**
 * UC8 - Reporting Service
 */
public class BookingReportService {

    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // Generate simple report
    public void generateReport() {

        System.out.println("\n=== Booking Report ===");

        List<Reservation> list = history.getAllReservations();

        HashMap<String, Integer> report = new HashMap<>();

        for (Reservation r : list) {
            report.put(r.roomType, report.getOrDefault(r.roomType, 0) + 1);
        }

        for (String roomType : report.keySet()) {
            System.out.println(roomType + " booked: " + report.get(roomType));
        }
    }
}