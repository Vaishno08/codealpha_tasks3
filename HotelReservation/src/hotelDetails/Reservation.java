package hotelDetails;

import java.util.Date;

public class Reservation {
	 private String guestName;
	    private Room room;
	    private Date reservationDate;

	    public Reservation(String guestName, Room room) {
	        this.guestName = guestName;
	        this.room = room;
	        this.reservationDate = new Date();
	    }

	    @Override
	    public String toString() {
	        return "Reservation{" +
	                "guestName='" + guestName + '\'' +
	                ", room=" + room +
	                ", reservationDate=" + reservationDate +
	                '}';
	    }

}
