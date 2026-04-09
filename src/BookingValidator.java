/**
 * UC9 - Booking Validator
 */
public class BookingValidator {

    public static void validate(Reservation request, RoomInventory inventory)
            throws InvalidBookingException {

        // Check null
        if (request == null) {
            throw new InvalidBookingException("Reservation cannot be null.");
        }

        // Validate guest name
        if (request.guestName == null || request.guestName.isEmpty()) {
            throw new InvalidBookingException("Guest name is invalid.");
        }

        // Validate room type
        int available = inventory.getAvailability(request.roomType);

        if (available == 0) {
            throw new InvalidBookingException("Room type not available: " + request.roomType);
        }

        // Prevent negative values
        if (available < 0) {
            throw new InvalidBookingException("Invalid inventory state detected.");
        }
    }
}