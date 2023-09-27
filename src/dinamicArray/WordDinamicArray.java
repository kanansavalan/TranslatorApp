//package dinamicArray;
//
//import word.Word;
//
//public class WordDinamicArray  {
//    public Word[] words;
//    public WordDinamicArray(){
//        words = new Word[0];
//
//    }
//    public void add(Word word){
//        Word[] newWords = new Word[words.length+1];
//        for(int i = 0 ; i<words.length;i++){
//            newWords[i] = words[i];
//
//        }
//        newWords[words.length] = word;
//        words= newWords;
//
//
//    }
//
//
//
//    public Word get(int index){
//        if (index<0 || index>= words.length){
//            throw new IllegalArgumentException();
//
//
//        }
//        return  words[index];
//
//
//    }
//
//    public  int getSize(){
//        return words.length;
//    }
//
//
//}
