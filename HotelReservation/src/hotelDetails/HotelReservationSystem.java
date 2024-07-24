package hotelDetails;

import java.util.Scanner;

public class HotelReservationSystem {
	public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Hotel Reservation System");
            System.out.println("1. Search for available rooms");
            System.out.println("2. Make a reservation");
            System.out.println("3. View reservations");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter room category (SINGLE, DOUBLE, SUITE):");
                    RoomCategory category = RoomCategory.valueOf(scanner.nextLine().toUpperCase());
                    System.out.println("Available rooms: " + hotel.searchRooms(category));
                    break;
                case 2:
                    System.out.println("Enter guest name:");
                    String guestName = scanner.nextLine();
                    System.out.println("Enter room category (SINGLE, DOUBLE, SUITE):");
                    RoomCategory roomCategory = RoomCategory.valueOf(scanner.nextLine().toUpperCase());
                    if (hotel.makeReservation(guestName, roomCategory)) {
                        System.out.println("Enter payment amount:");
                        double amount = scanner.nextDouble();
                        scanner.nextLine();  // Consume newline
                        if (PaymentProcessor.processPayment(guestName, amount)) {
                            System.out.println("Payment successful");
                        } else {
                            System.out.println("Payment failed");
                        }
                    }
                    break;
                case 3:
                    hotel.viewReservations();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

}
