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

    }
}
