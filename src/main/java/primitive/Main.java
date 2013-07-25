package primitive;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * Created by azhadan on 7/10/13.
 */
public class Main {
    public static void main(String[] args) {
        Integer ref0 = new Integer(2);
        Integer ref1 = new Integer(2);
        Integer ref2 = ref1;
        Number ref3 = ref2;
        System.out.println((ref0 == ref1) + " / " + (ref1 == ref2) + " / " + (ref3 == ref1));


        System.out.println(Integer.decode("50"));
        int[] array = {10, 30, 20};
        PrimitiveArray arr = new PrimitiveArray(array);
        System.out.println(arr);

        String v1 = "xx";
        String v2 = "xx";
        System.out.println(v1 == v2);

        WeakHashMap<String, String> map = new WeakHashMap<String, String>();
        //Data someDataObject = new Data("foo");

        String someDataObject = new String("qqq");
        map.put(someDataObject, "www");
        someDataObject = null;
        System.gc();

        for (int i = 0; i < 100000; i++) {
            if (map.size() != 0) {
                System.out.println("At iteration " + i + " the map still holds the reference on someDataObject");
            } else {
                System.out.println("someDataObject has finally been garbage collected at iteration " + i + ", hence the map is now empty");
                break;
            }
        }

        Map<Integer, String> map2 = new HashMap<Integer, String>();
        map2.put(5, "a");
        map2.put(4, "b");
        map2.put(3, "c");
        map2.put(2, "d");
        map2.put(1, "e");
        System.out.println(map2);

    }
}
