import java.io.Serializable;
import java.util.HashMap;

/**
 * UC3 - Room Inventory (UPDATED for UC12)
 */
public class RoomInventory implements Serializable {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    public void displayInventory() {
        System.out.println("=== Room Inventory ===");

        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + " → Available: " + inventory.get(roomType));
        }
    }
}