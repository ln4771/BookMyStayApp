// UC2: Basic Room Types & Static Availability

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

public class BookMyStayApp {

    public static void main(String[] args) {

        // ===== UC1 =====
        System.out.println("Book My Stay App");
        System.out.println("UC1: Application Entry & Welcome Message");
        System.out.println("Welcome to the Hotel Booking Management System!");
        System.out.println("Version 1.0");
        System.out.println("-------------------------------------");

        // ===== UC2 =====
        System.out.println("UC2: Basic Room Types & Static Availability");
        System.out.println("Version 2.0");
        System.out.println("-------------------------------------");

        // Create Room Objects
        Room single = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suite = new SuiteRoom();

        // Static availability variables
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        System.out.println("\nRoom Details\n");

        single.displayRoomDetails();
        System.out.println("Available : " + singleAvailable);
        System.out.println();

        doubleRoom.displayRoomDetails();
        System.out.println("Available : " + doubleAvailable);
        System.out.println();

        suite.displayRoomDetails();
        System.out.println("Available : " + suiteAvailable);
    }
}