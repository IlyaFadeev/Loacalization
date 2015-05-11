package com.company;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ilya on 11.05.2015.
 */
public class Main {

    public static void main(String[] args) throws IOException {
        JSONObject object = new JSONObject();
        object.put("Game1", "game param number param numbers param param hello!");
        FileWriter writer = new FileWriter("ru.json");
        writer.write(object.toJSONString());
        writer.flush();
        writer.close();
        List<String> listOfParams = new ArrayList<>();
        listOfParams.add("10");
        listOfParams.add("15");
        listOfParams.add("20");
        listOfParams.add("25");
        listOfParams.add("World");
        LocalizationManager manager = new LocalizationManager("ru","");
        System.out.println(manager.format("Game1", listOfParams));

    }
}
