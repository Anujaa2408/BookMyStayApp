import java.io.Serializable;

/**
 * UC5 - Reservation (UPDATED for UC12)
 */
public class Reservation implements Serializable {

    String guestName;
    String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public void display() {
        System.out.println("Guest: " + guestName + ", Room: " + roomType);
    }
}