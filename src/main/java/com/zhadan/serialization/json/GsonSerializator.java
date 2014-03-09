package com.zhadan.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.zhadan.serialization.custom.DataObject;

/**
 * Created by andrewzhadan on 3/8/14.
 */
public class GsonSerializator {
    public static void main(String[] args) {
        DataObject dataObject = new DataObject();

        // Gson gson = new Gson();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(dataObject);
        System.out.println(json);
        DataObject object = gson.fromJson(json, DataObject.class);
    }

}
