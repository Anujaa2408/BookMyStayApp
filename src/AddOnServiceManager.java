import java.util.*;

/**
 * UC7 - Manage Add-On Services
 */
public class AddOnServiceManager {

    // Map: ReservationID → List of Services
    private HashMap<String, List<Service>> serviceMap;

    public AddOnServiceManager() {
        serviceMap = new HashMap<>();
    }

    // Add service to reservation
    public void addService(String reservationId, Service service) {

        serviceMap.putIfAbsent(reservationId, new ArrayList<>());

        serviceMap.get(reservationId).add(service);

        System.out.println("Service added to " + reservationId + ": " + service.name);
    }

    // Display services for a reservation
    public void showServices(String reservationId) {

        System.out.println("\nServices for " + reservationId + ":");

        List<Service> services = serviceMap.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No services selected.");
            return;
        }

        for (Service s : services) {
            s.display();
        }
    }

    // Calculate total cost
    public double calculateTotalCost(String reservationId) {

        double total = 0;

        List<Service> services = serviceMap.get(reservationId);

        if (services != null) {
            for (Service s : services) {
                total += s.price;
            }
        }

        return total;
    }
}