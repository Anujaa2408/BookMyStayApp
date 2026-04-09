/**
 * UC9 - Custom Exception for Invalid Booking
 */
public class InvalidBookingException extends Exception {

    public InvalidBookingException(String message) {
        super(message);
    }
}