package service.impl;



import java.io.*;
import java.util.Random;

public class FileServiceImpl implements service.FileServiceInter {

    public void writeToFile(String filename, String key, String value) {

        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true))) {
            bufferedWriter.write(key);
            bufferedWriter.write(":");
            bufferedWriter.write(value);
            bufferedWriter.newLine();


        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public String[] readWordFromFile(String fileName, int wordCount) {
        String[] selectedWord = new String[wordCount];
        String[] allWord;

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File(fileName)));
            String line;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
                lineCount++;
            }

            br.close();

            if (lineCount <= wordCount) {
                allWord = new String[lineCount];
            } else {
                allWord = new String[lineCount];
                br = new BufferedReader(new FileReader(new File(fileName)));

                for (int i = 0; i < lineCount; i++) {
                    allWord[i] = br.readLine();
                }

                br.close();

                Random random = new Random();

                for (int i = 0; i < wordCount; i++) {
                    int randomIndex = random.nextInt(lineCount - i);
                    selectedWord[i] = allWord[randomIndex];
                    allWord[randomIndex] = allWord[lineCount - i - 1];
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return selectedWord;

    }

    public void writeLog(String filename, String log) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename,true))) {

            bufferedWriter.write(log);
            bufferedWriter.newLine();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    public   void readLog(String filename) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {

            String line;
            while ((line = bufferedReader.readLine()) != null){
                System.out.println(line);
            }

        }catch (IOException e){
            throw new RuntimeException(e);
        }


    }
}