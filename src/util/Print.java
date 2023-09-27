package util;

import global.GlobalString;
import service.FileServiceInter;
import service.impl.FileServiceImpl;

public class Print {

    public static int printMenu(){

        System.out.println(
                " ================Translator App=====================\n"+
                         "[1] : Start\n"+
                         "[2] : Add Word\n"+
                         "[3] : See History\n"+
                         "[0] : EXIT!\n"+
                " ==================================================="
        );
int a= Util.requiredInt("Please enter option");
   return a; }


    public static  void printEnglishWords(int count){

        FileServiceInter fileServiceInter = new FileServiceImpl();

      String [] words=  fileServiceInter.readWordFromFile(GlobalString.dictionaryFileName,count);
      for (int i = 0; i<words.length;i++){

          String[] wordSplit = words[i].split(":");
          String wordEnglish = wordSplit[0];
          System.out.println(wordEnglish);







      }


    }


}
