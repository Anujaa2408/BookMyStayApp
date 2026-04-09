/**
 * UC7 - Test Add-On Services
 */
public class UseCase7_AddOnServices {

    public static void main(String[] args) {

        AddOnServiceManager manager = new AddOnServiceManager();

        // Example reservation IDs (from UC6)
        String reservation1 = "SR_5";
        String reservation2 = "DR_3";

        // Add services
        manager.addService(reservation1, new Service("Breakfast", 200));
        manager.addService(reservation1, new Service("Spa", 500));

        manager.addService(reservation2, new Service("Airport Pickup", 800));

        // Display services
        manager.showServices(reservation1);
        manager.showServices(reservation2);

        // Show total cost
        System.out.println("\nTotal cost for " + reservation1 + ": ₹" +
                manager.calculateTotalCost(reservation1));
    }
}