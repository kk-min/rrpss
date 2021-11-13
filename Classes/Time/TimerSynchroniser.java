package Classes.Time;

import java.util.TimerTask;

public class TimerSynchroniser extends TimerTask {
	@Override
	public void run() {
		DateTimeFormatHelper.synchronize();
	}
}
