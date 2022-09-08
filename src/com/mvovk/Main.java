package com.mvovk;

import com.google.gson.Gson;
import com.mvovk.models.Calendar;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

  public static  String jsonString = "{\n" +
            "  \"working_hours\": {\n" +
            "    \"start\": \"09:00\",\n" +
            "    \"end\": \"19:55\"\n" +
            "  },\n" +
            "  \"planned_meeting\": [\n" +
            "    {\n" +
            "      \"start\": \"09:00\",\n" +
            "      \"end\": \"10:30\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"start\": \"12:00\",\n" +
            "      \"end\": \"13:00\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"start\": \"16:00\",\n" +
            "      \"end\": \"18:00\"\n" +
            "    }\n" +
            "  ]\n" +
            "}";

    public static void main(String[] args) {
        Calendar calendar1 = null,calendar2 = null;
        Gson gson = new Gson();
        Reader reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("src/resources/Calendar1.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (reader!=null){
         calendar1 = gson.fromJson(reader, Calendar.class);
        System.out.println(calendar1);
        }
         reader = null;
        try {
            reader = Files.newBufferedReader(Paths.get("src/resources/Calendar4.json"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (reader!=null){
            calendar2 = gson.fromJson(reader, Calendar.class);
            System.out.println(calendar2);
        }
        Solution solution = new Solution();

        solution.getSolution(calendar1,calendar2);
    }
}
