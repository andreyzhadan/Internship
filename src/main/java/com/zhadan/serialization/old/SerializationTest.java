package com.zhadan.serialization.old;

import java.io.*;

/**
 * Created by azhadan on 7/17/13.
 */
public class SerializationTest {
    public static void main(String[] args) {
        try {
            System.out.println("Creating...");
            Child c = new Child(1, 300, 20);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            System.out.println("Serializing...");
            oos.writeObject(c);
            oos.flush();
            baos.flush();
            oos.close();
            baos.close();

            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            System.out.println("Deserializing...");
            Child c1 = (Child) ois.readObject();
            System.out.println("c1.i = " + c1.getI());
            System.out.println("c1.j = " + c1.getJ());
            System.out.println("c1.j = " + c1.getObj());
            System.out.println((c == c1) + " / " + (c.getJ().equals(c1.getJ())));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
