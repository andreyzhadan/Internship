import java.math.BigInteger;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by azhadan on 7/11/13.
 */
public class Fibonacci {
    private static Map<Integer, BigInteger> cacheMap = new WeakHashMap<Integer, BigInteger>();

    static {
        cacheMap.put(0, BigInteger.ZERO);
        cacheMap.put(1, BigInteger.ONE);
    }

    public static BigInteger fibonacci(int num) {
        if (num < 2)
            return BigInteger.valueOf(num);
        return fibonacci(num - 1).add(fibonacci(num - 2));
    }

    public static BigInteger fibonacciCached(int num) {
        if (!cacheMap.containsKey(num))
            cacheMap.put(num, fibonacciCached(num - 1).add(fibonacciCached(num - 2)));
        return cacheMap.get(num);

    }

    public static void main(String[] args) {
        long t0 = System.currentTimeMillis();
        for (int i = 0; i < 40; i++)
            System.out.print(fibonacci(i) + " ");
        System.out.println("\nNon cacheMap version takes " + (System.currentTimeMillis() - t0) + " ms");

        long t1 = System.currentTimeMillis();
        for (int i = 0; i < 40; i++)
            System.out.print(fibonacciCached(i) + " ");
        System.out.println("\nCacheMap version takes " + (System.currentTimeMillis() - t1) + " ms");
    }
}
