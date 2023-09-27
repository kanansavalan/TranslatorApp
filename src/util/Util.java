package util;

import java.util.Scanner;

public class Util {


    public static  int requiredInt(String title){
        Scanner sc =new Scanner(System.in);
        System.out.println(title);
        int a = sc.nextInt();
        return a;
    }

    public static  String requiredString(String title){
        Scanner sc =new Scanner(System.in);
        System.out.println(title);
        String a = sc.nextLine();
        return a;
    }



}
