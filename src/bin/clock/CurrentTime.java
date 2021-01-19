package bin.clock;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Timer;
import java.util.TimerTask;


public class CurrentTime {
    protected LocalDateTime time;
    private final Timer timer = new Timer();
    protected final TimerTask scheduledTimer;

    public CurrentTime() {
        scheduledTimer = new TimerTask() {
            @Override
            public void run() {
                time = LocalDateTime.now();
            }
        };

        timer.scheduleAtFixedRate(scheduledTimer, 1000, 1000);
        time = LocalDateTime.now();
    }

    public Timer getTimer() {
        return timer;
    }

    public int getHour() {
        return this.time.getHour();
    }

    public int getMinute() {
        return this.time.getMinute();
    }

    public int getSeconds() {
        return this.time.getSecond();
    }

}
