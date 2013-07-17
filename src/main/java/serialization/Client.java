package serialization;

import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Random;

/**
 * Created by azhadan on 7/17/13.
 */
public class Client {
    public static void main(String[] args) {
        int serverPort = 6666;
        String address = "127.0.0.1";
        try {
            System.out.println("Client starts...");
            InetAddress ipAddress = InetAddress.getByName(address);
            Socket socket = new Socket(ipAddress, serverPort);

            OutputStream sout = socket.getOutputStream();

            ObjectOutputStream oos = new ObjectOutputStream(sout);

            Random random = new Random();
            int i = random.nextInt(10000);
            int j = random.nextInt(10000);

            System.out.println("Client try to write " + i + " / " + j);

            Child child = new Child(i, j, new Integer(20));
            oos.writeObject(child);
            oos.flush();
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
