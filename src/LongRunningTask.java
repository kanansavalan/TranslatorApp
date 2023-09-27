import service.GameServiceInter;
import service.impl.GameServiceImpl;

class LongRunningTask implements Runnable {
    @Override
    public void run() {

        for (int i = 0; i < Long.MAX_VALUE; i++) {
            if(Thread.interrupted()) {
                GameServiceInter gameServiceInter = new GameServiceImpl();
                int count = gameServiceInter.start();

                System.out.println("Your count is " + count);
                if (count > 0 && count < 3) {
                    System.out.println("Your English level A0");

                } else if (count> 2 && count < 5) {
                    System.out.println("Your English level A1 ");


                } else if (count > 4 && count < 7) {
                    System.out.println("Your English level B1");

                } else if (count > 6 && count < 9) {
                    System.out.println("Your English Level C1");
                } else {
                    System.out.println("Your English level C2");
                }

                return;
            }
        }
    }
}
