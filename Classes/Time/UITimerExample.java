package Classes.Time;

import java.util.TimerTask;

import Classes.Reservation.ReservationInterface;

public class UITimerExample extends TimerTask {

	private String name;

	public UITimerExample(String n) {
		this.name = n;
	}

	@Override
	public void run() {
		/*System.out.println(
				Thread.currentThread().getName() + " " + name + " the task has executed successfully " + new Date());*/
		ReservationInterface.checkExpiredReservations();
	}
}
