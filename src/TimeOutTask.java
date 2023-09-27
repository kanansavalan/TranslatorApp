import managmentService.ManagmentService;
import service.GameServiceInter;
import service.impl.GameServiceImpl;

import java.util.Timer;
import java.util.TimerTask;

class TimeOutTask extends TimerTask {
    private Thread thread;
    private Timer timer;

    public TimeOutTask(Thread thread, Timer timer) {
        this.thread = thread;
        this.timer = timer;
    }

    @Override
    public void run() {
        GameServiceInter gameServiceInter = new GameServiceImpl();
        gameServiceInter.start();
        if(thread != null && thread.isAlive()) {
            thread.interrupt();
            timer.cancel();
        }
    }
}