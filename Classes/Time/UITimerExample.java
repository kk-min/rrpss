package Classes.Time;

import java.util.TimerTask;

import Classes.Reservation.ReservationManager;

public class UITimerExample extends TimerTask {
	@Override
	public void run() {
		ReservationManager.checkExpiredReservations();
	}
}
