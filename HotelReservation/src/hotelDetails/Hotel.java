package hotelDetails;

import java.util.*;

public class Hotel {
	private List<Room> rooms;
    private List<Reservation> reservations;

    public Hotel() {
        rooms = new ArrayList<>();
        reservations = new ArrayList<>();
        initializeRooms();
    }

    private void initializeRooms() {
        for (int i = 1; i <= 10; i++) {
            rooms.add(new Room(i, RoomCategory.SINGLE));
        }
        for (int i = 11; i <= 20; i++) {
            rooms.add(new Room(i, RoomCategory.DOUBLE));
        }
        for (int i = 21; i <= 25; i++) {
            rooms.add(new Room(i, RoomCategory.SUITE));
        }
    }

    public List<Room> searchRooms(RoomCategory category) {
        List<Room> availableRooms = new ArrayList<>();
        for (Room room : rooms) {
            if (room.getCategory() == category && room.isAvailable()) {
                availableRooms.add(room);
            }
        }
        return availableRooms;
    }

    public boolean makeReservation(String guestName, RoomCategory category) {
        List<Room> availableRooms = searchRooms(category);
        if (!availableRooms.isEmpty()) {
            Room room = availableRooms.get(0);
            room.setAvailable(false);
            Reservation reservation = new Reservation(guestName, room);
            reservations.add(reservation);
            System.out.println("Reservation successful: " + reservation);
            return true;
        } else {
            System.out.println("No available rooms for category: " + category);
            return false;
        }
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }

}
