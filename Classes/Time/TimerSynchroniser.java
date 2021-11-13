package Classes.Time;

import java.util.TimerTask;
/**
 * The task to be performed periodically. The task will synchronize the program.
 */
public class TimerSynchroniser extends TimerTask {
	@Override
	public void run() {
		DateTimeFormatHelper.synchronize();
	}
}
