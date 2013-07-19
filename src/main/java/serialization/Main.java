package serialization;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by azhadan on 7/19/13.
 */
public class Main {
    public static void main(String[] args) {
        SecureRandom random = new SecureRandom();
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(new Client(Protocol.Type.INFO, generateRandomString(random)));
            service.submit(new Client(Protocol.Type.ACTION, generateRandomString(random)));
        }
        service.shutdown();
    }

    private static String generateRandomString(SecureRandom random) {
        return new BigInteger(130, random).toString() + "\n";
    }
}
