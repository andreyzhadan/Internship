package serialization;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by azhadan on 7/17/13.
 */
public class Server {
    public static void main(String[] args) throws Exception {
        int port = 6666;
        ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Waiting for client...");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Got a client :");

            InputStream sin = socket.getInputStream();

            ObjectInputStream ois = new ObjectInputStream(sin);

            Child child = (Child) ois.readObject();
            System.out.println(child.getI() + " / " + child.getJ());
        }
    }
}
