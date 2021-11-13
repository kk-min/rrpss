package Classes.Time;

import java.util.Timer;
/**
 * The TimerExecutor Class
 * A recurring task defined.
 * @version 1.0
 */
public class TimerExecutor {
	/**
	 * Constructor of the recurring task. The recurring task will be executed every 60 seconds.
	 */
	public static void runScheduler() {
		TimerSynchroniser sync = new TimerSynchroniser();

		Timer t = new Timer();
		t.scheduleAtFixedRate(sync, 0, 60 * 1000);
	}
}
