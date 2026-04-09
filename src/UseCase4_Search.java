/**
 * UC4 - Test Room Search
 */
public class UseCase4_Search {

    public static void main(String[] args) {

        // Inventory (state)
        RoomInventory inventory = new RoomInventory();

        // Search service (read-only)
        SearchService searchService = new SearchService(inventory);

        // Perform search
        searchService.searchAvailableRooms();
    }
}