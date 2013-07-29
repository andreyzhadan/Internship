package com.zhadan.serialization;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by azhadan on 7/17/13.
 */
public class Client implements Runnable {
    private final Protocol.Type type;
    private String text;

    public Client(Protocol.Type type, String text) {
        this.type = type;
        this.text = text;
    }

    @Override
    public void run() {
        int serverPort = 6666;
        String address = "127.0.0.1";
        try {
            System.out.println("Client starts...");
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, serverPort);

            OutputStream sout = socket.getOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(sout);

            //            Random random = new Random();
//            int i = random.nextInt(10000);
//            int j = random.nextInt(10000);
//            System.out.println("Client try to write " + i + " / " + j);
//            Child child = new Child(i, j, new Integer(20));

            Protocol protocol = new Protocol(type, text);
            System.out.println("Send from Client to server " + protocol.getText() + " / " + protocol.getType().name());
            oos.writeObject(protocol);

            InputStream sin = socket.getInputStream();
            ObjectInputStream ois = new ObjectInputStream(sin);

            Protocol back = (Protocol) ois.readObject();
            System.out.println("Server sent back " + back.getText() + " / " + protocol.getType().name());

            oos.flush();
            oos.close();
            ois.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}
