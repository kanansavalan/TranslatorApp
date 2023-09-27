import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class TimerTest {
    public static void Check(String[] words) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for (int k = 0; k < words.length; k++) {
            String word = sc.nextLine();
            if (word.equalsIgnoreCase(words[k])) {
                count++;

            }
        }


    }

    public static String[] writeWord(String word) {
        String[] words = new String[5];

        for (int i = 0; i < words.length; i++) {
            words[i] = word;


        }
        return words;
    }


    public static void main(String[] args) {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

            }
        };

        Scanner sc = new Scanner(System.in);

        Timer timer = new Timer();


        String[] word = new String[5];

        int i = 0;

        String word3 = sc.nextLine();

        String[] newWord = TimerTest.writeWord(word3);


    }


}
