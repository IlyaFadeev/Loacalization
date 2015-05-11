package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

/**
 * Created by Ilya on 11.05.2015.
 */
public class LocalizationManager {

    private String currLang = "";
    private JSONObject currLocal;
    public LocalizationManager(String currLang, String path)
    {
        this.currLang = currLang;
        JSONParser parser = new JSONParser();
        try {
            String q = path + currLang + ".json";
            Object object = parser.parse(new FileReader(path + currLang + ".json"));
            currLocal = (JSONObject) object;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Файл не найден!");
        }
        catch (ParseException e)
        {
            System.out.println("Ошибка парсинга!");
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    }


    public String get(String phrase)
    {
        return this.currLocal.get(phrase).toString();
    }

    public String format(String phrase, String param)
    {
        String currString = get(phrase);
        String[] strWithoutParam = currString.split("param");
        String finalStr = "";
        finalStr += strWithoutParam[0] + param + strWithoutParam[1];

        return finalStr;
    }

    public StringBuilder format(String phrase, List<String> listOfParams)
    {
        StringBuilder currString = new StringBuilder(get(phrase));
        int currParam = 0;
        int j = 0;
        while ((currParam = currString.indexOf("param"))>=0)
        {
                currString.delete(currParam, currParam + 5);
            currString.insert(currParam,listOfParams.get(j));
            j++;
        }


        return currString;
    }




}
