package com.zhadan.serialization.custom;

import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 26.02.14
 * Time: 22:46
 */
public class Serializator {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File file = new File("store.bin");
        writeToFile(file);
        readFromFile(file);
        //externalizable - user custom serialization
    }

    private static void readFromFile(File file) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(file);
        ObjectInputStream ois = new ObjectInputStream(fis);
        DataObject object = (DataObject) ois.readObject();
        System.out.println(object);
        ois.close();
    }

    public static void writeToFile(File file) throws IOException {
        DataObject dataObject = new DataObject();
        dataObject.setMyData("qqq");
        FileOutputStream fos = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(dataObject);
        oos.flush();
        oos.close();
    }
}
