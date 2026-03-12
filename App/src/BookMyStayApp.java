import java.util.HashMap;

// ===== UC2: Room Abstract Class =====
abstract class Room {
    String roomType;
    int beds;
    double price;

    Room(String roomType, int beds, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.price = price;
    }

    void displayRoomDetails() {
        System.out.println("Room Type : " + roomType);
        System.out.println("Beds      : " + beds);
        System.out.println("Price     : $" + price);
    }
}

// ===== Room Types =====
class SingleRoom extends Room {
    SingleRoom() {
        super("Single Room", 1, 100);
    }
}

class DoubleRoom extends Room {
    DoubleRoom() {
        super("Double Room", 2, 180);
    }
}

class SuiteRoom extends Room {
    SuiteRoom() {
        super("Suite Room", 3, 300);
    }
}

// ===== UC3: Inventory =====
class RoomInventory {

    private HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 0); // Example unavailable room
    }

    int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }
}

// ===== UC4: Search Service =====
class RoomSearchService {

    static void searchAvailableRooms(RoomInventory inventory, Room[] rooms) {

        System.out.println("\nAvailable Rooms\n");

        for (Room room : rooms) {

            int available = inventory.getAvailability(room.roomType);

            if (available > 0) {
                room.displayRoomDetails();
                System.out.println("Available : " + available);
                System.out.println();
            }
        }
    }
}

// ===== Main Application =====
public class BookMyStayApp {

    public static void main(String[] args) {

        // ===== UC1 =====
        System.out.println("Book My Stay App");
        System.out.println("UC1: Application Entry & Welcome Message");
        System.out.println("Welcome to the Hotel Booking Management System!");
        System.out.println("------------------------------------");

        // ===== UC2 =====
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        Room[] rooms = {single, doubleRoom, suite};

        // ===== UC3 =====
        RoomInventory inventory = new RoomInventory();

        // ===== UC4 =====
        System.out.println("\nUC4: Room Search & Availability Check");
        RoomSearchService.searchAvailableRooms(inventory, rooms);
    }
}