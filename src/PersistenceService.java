import java.io.*;

/**
 * UC12 - Persistence Service
 */
public class PersistenceService {

    private static final String FILE_NAME = "system_state.ser";

    // Save state
    public static void save(RoomInventory inventory, BookingHistory history) {

        try (ObjectOutputStream oos =
                     new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

            oos.writeObject(inventory);
            oos.writeObject(history);

            System.out.println("System state saved successfully.");

        } catch (Exception e) {
            System.out.println("Error saving state: " + e.getMessage());
        }
    }

    // Load state
    public static Object[] load() {

        try (ObjectInputStream ois =
                     new ObjectInputStream(new FileInputStream(FILE_NAME))) {

            RoomInventory inventory = (RoomInventory) ois.readObject();
            BookingHistory history = (BookingHistory) ois.readObject();

            System.out.println("System state loaded successfully.");

            return new Object[]{inventory, history};

        } catch (Exception e) {
            System.out.println("No previous data found. Starting fresh.");
            return null;
        }
    }
}