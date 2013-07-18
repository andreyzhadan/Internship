package serialization;

import java.io.IOException;
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
        final ServerSocket serverSocket = new ServerSocket(port);

        System.out.println("Waiting for client...");
        while (true) {
            final Socket socket = serverSocket.accept();
            new Thread(new Runnable() {
                public void run() {
                    System.out.println("Got a client :");
                    InputStream sin = null;
                    try {
                        sin = socket.getInputStream();
                        ObjectInputStream ois = new ObjectInputStream(sin);
                        Child child = (Child) ois.readObject();
                        System.out.println(child.getI() + " / " + child.getJ());
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        }
    }

}
