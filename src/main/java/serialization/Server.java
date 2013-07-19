package serialization;

import java.io.*;
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
                    InputStream sin;
                    OutputStream sout;
                    try {
                        sin = socket.getInputStream();
                        ObjectInputStream ois = new ObjectInputStream(sin);

                        //                        Child child = (Child) ois.readObject();
//                        System.out.println(child.getI() + " / " + child.getJ() + " / " + child.getObj());

                        Protocol protocol = (Protocol) ois.readObject();
                        System.out.println("Client send me this " + protocol.getText() + " / " + protocol.getType().name());
                        if (protocol.getType().equals(Protocol.Type.INFO)) {
                            File file = new File("text.txt");
                            if (!file.exists())
                                file.createNewFile();
                            FileWriter fileWritter = new FileWriter(file.getName(), true);
                            fileWritter.write(protocol.getText());
                            fileWritter.close();
                        } else {
                            System.out.println("Counting tf-idf is bullshit");
                        }

                        sout = socket.getOutputStream();
                        ObjectOutputStream oos = new ObjectOutputStream(sout);

                        Protocol back = new Protocol(Protocol.Type.INFO, "OK");

                        System.out.println("Send response to client " + back.getText() + " / " + back.getType().name());
                        oos.writeObject(back);
                        oos.flush();
                        ois.close();
                        oos.close();

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

}
