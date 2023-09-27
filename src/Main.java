import global.GlobalString;
import managmentService.ManagmentService;
import service.FileServiceInter;
import service.GameServiceInter;
import service.impl.FileServiceImpl;
import service.impl.GameServiceImpl;
import util.Print;
import util.Util;
import util.Util;

import java.time.LocalDateTime;
import java.time.Period;
import java.util.Date;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ManagmentService.managment();
GameServiceInter gameServiceInter = new GameServiceImpl();

        ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
        Future future = executor.submit(new LongRunningTask());
        Runnable cancelTask = () -> future.cancel(true);

        executor.schedule(cancelTask, 10000, TimeUnit.MILLISECONDS);
       gameServiceInter.start();
        executor.shutdown();

    }

}