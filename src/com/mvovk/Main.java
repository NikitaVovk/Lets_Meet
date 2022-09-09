package com.mvovk;

import com.google.gson.Gson;
import com.mvovk.models.Calendar;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {


    public static Calendar readCalendar(  int numOfFile){
        Reader reader =null;
        Calendar calendar = null;
        Gson gson = new Gson();
        try {
            reader = Files.newBufferedReader(Paths.get("resources/Calendar" +numOfFile+".json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (reader!=null){
            calendar = gson.fromJson(reader, Calendar.class);
        }
        return calendar;
    }
    public static int readTheNum (String text){
        int num =0;

        while (!(num>=1&&num<=5)){
            System.out.println(text);
            try {
                Scanner scan = new Scanner(System.in);
                num = scan.nextInt();
            }catch (InputMismatchException e) {
                System.out.println("Podałeś liczbę w złym formacie");

            }
        }
        return num;
    }
    public static String readTheMeetingDuration (){
        String time=null;
        while (true){
            try {
                Scanner scan = new Scanner(System.in);
                time = scan.nextLine();
            }catch (InputMismatchException e) {
                System.out.println("Podałeś liczbę w złym formacie");

            }
        SimpleDateFormat sdf = new SimpleDateFormat("hh:mm");
        Date date = null;
        try {
            date = sdf.parse(time);
        } catch (ParseException e) {
            System.out.println("Zły format zapisu czasu\nPodaj czas w formacie 'hh:mm'");
            continue;
        }
        break;
        }
        return time;
    }
    public static void main(String[] args) {
        while (true){
        Calendar calendar1 ,calendar2 ;

        int num ;

        num=readTheNum("Wybierz pierwszy kalendarz wpisując liczbę od 1 do 5:");

        calendar1=readCalendar(num);
        System.out.println("\n"+calendar1);



        num = readTheNum("Wybierz drugi kalendarz wpisując liczbę od 1 do 5:");

        calendar2=readCalendar(num);
        System.out.println(calendar2);

        System.out.println("Podaj minimalny czas trwania spotkania w formacie 'hh:mm':");
        String meetingDuration = readTheMeetingDuration();

        Solution solution = new Solution(calendar1,calendar2,meetingDuration);

        System.out.println("\nDostępne terminy spotkań:");
        System.out.println( solution.getSolution());
        while (num!=0&&num!=1) {
            num = readTheNum("\nPodaj 0, jeśli chcesz zakończyć, lub 1, jeśli chcesz kontynuować");
            if (num == 0)
                break;
        }
        }


    }
}
