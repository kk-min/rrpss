package Project;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import Project.ReservationMenuUI;

public class UITimerExample extends TimerTask {

	private String name;

	public UITimerExample(String n) {
		this.name = n;
	}

	@Override
	public void run() {
		/*System.out.println(
				Thread.currentThread().getName() + " " + name + " the task has executed successfully " + new Date());*/
		ReservationMenuUI.checkExpiredReservations();
	}
}
