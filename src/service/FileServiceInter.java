package service;

public interface FileServiceInter {

     void writeToFile(String filename, String key, String value) ;
       String[] readWordFromFile(String fileName, int wordCount);
     void writeLog(String filename, String log);
       void readLog(String filename);



}
