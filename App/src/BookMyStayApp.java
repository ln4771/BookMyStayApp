import java.util.HashMap;

// ===== Room Abstract Class (UC2) =====
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

// ===== UC3 Inventory Class =====
class RoomInventory {

    private HashMap<String, Integer> inventory;

    RoomInventory() {
        inventory = new HashMap<>();

        // Initial room availability
        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    void updateAvailability(String roomType, int count) {
        inventory.put(roomType, count);
    }

    void displayInventory() {
        System.out.println("\nCurrent Room Inventory");

        for (String room : inventory.keySet()) {
            System.out.println(room + " Available : " + inventory.get(room));
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
        System.out.println("Version 1.0");
        System.out.println("-----------------------------------");

        // ===== UC2 =====
        System.out.println("UC2: Basic Room Types");
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        single.displayRoomDetails();
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println();

        suite.displayRoomDetails();

        // ===== UC3 =====
        System.out.println("\nUC3: Centralized Room Inventory Management");
        System.out.println("Version 3.0");
        System.out.println("-----------------------------------");

        RoomInventory inventory = new RoomInventory();

        inventory.displayInventory();
    }
}