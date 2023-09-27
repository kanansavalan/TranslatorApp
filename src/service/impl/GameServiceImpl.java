package service.impl;

import global.GlobalString;
import service.FileServiceInter;
import service.GameServiceInter;
import util.Util;

import java.io.File;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class GameServiceImpl implements GameServiceInter {

   private  static Scanner sc = new Scanner(System.in);
  private static Timer timer = new Timer();

    private static boolean timeOut = false;




   private  static  long startTime = 0;
    FileServiceInter fileServiceInter = new FileServiceImpl();

    @Override
    public int  start() {


        int count = Util.requiredInt("Please enter word count ");
        String[] words = fileServiceInter.readWordFromFile(GlobalString.dictionaryFileName, count);



LocalDateTime localDateTime = LocalDateTime.now();


                int count1 = 0;
                int count2 = 0;

        startTime = System.currentTimeMillis();


for (int i  = 0; i<words.length; i++){


    String[] splitWords = words[i].split(":");
    String englishWords = splitWords[0];
    String wordAzerbaijan = Util.requiredString("Please enter translation  " + englishWords);
    String azerbaijanWords = splitWords[1];
    if (wordAzerbaijan.equalsIgnoreCase(azerbaijanWords)) {
        count1++;

    } else {
        count2++;
    }

    if (count2 == 3) {
        count2 = 0;
        count1--;
    }


}

                long endTime = System.currentTimeMillis();
                long betweenTime = (endTime-startTime)/1000;

long minutes = betweenTime/60;
long second  = betweenTime % 60;



       return count1;     }





    @Override
    public void addWord() {
        FileServiceInter fileService = new FileServiceImpl();
        int a= Util.requiredInt("Please enter word count");

for (int i = 0 ; i< a ; i ++){
    String key = Util.requiredString("Enter word English");
    String value = Util.requiredString("Enter word Azerbaijan");
    fileService.writeToFile("EngAz.txt",key,value);



}



    }

    @Override
    public void seeHistory() {
fileServiceInter.readLog(GlobalString.logFileName);
    }

    @Override
    public void exit() {
        System.exit(0);

    }
//    public  static void TimeExample() {
//
//            long baslangicZamani = System.currentTimeMillis();
//            long hedefZaman = baslangicZamani + 10000;
//            while (System.currentTimeMillis() < hedefZaman) {
//
//            }
//
//
//            System.out.println("Metod çalıştı!");
//        }
public void start2() {

boolean ss = false;

    int count = Util.requiredInt("Please enter word count ");
    String[] words = fileServiceInter.readWordFromFile(GlobalString.dictionaryFileName, count);
    long time = Util.requiredInt("Please enter time with second");
    long time2 = time * 1000;

    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            System.out.println("Vaxt bitdi!!");
            timeOut = true;


        }
    };

    LocalDateTime localDateTime = LocalDateTime.now();

    timer.schedule(timerTask, time2);
    int count1 = 0;
    int count2 = 0;

    while (!timeOut) {
        for (int i = 0; i < words.length; i++) {


            String[] splitWords = words[i].split(":");
            String englishWords = splitWords[0];
            String wordAzerbaijan = Util.requiredString("Please enter translation  " + englishWords);
            String azerbaijanWords = splitWords[1];
            if (wordAzerbaijan.equalsIgnoreCase(azerbaijanWords)) {
                count1++;

            } else {
                count2++;
            }

            if (count2 == 3) {
                count2 = 0;
                count1--;
            }


        }
    }
    if (timeOut) {

        System.out.println("Your count is " + count1);
        if (count1 > 0 && count1 < 3) {
            System.out.println("Your English level A0");

        } else if (count1 > 2 && count1 < 5) {
            System.out.println("Your English level A1 ");


        } else if (count1 > 4 && count1 < 7) {
            System.out.println("Your English level B1");

        } else if (count1 > 6 && count1 < 9) {
            System.out.println("Your English Level C1");
        } else {
            System.out.println("Your English level C2");
        }

        String log = "New Game started at -> Time: " + localDateTime + " Point – " + count1 + " Word count: " + count;

    }
}










}


