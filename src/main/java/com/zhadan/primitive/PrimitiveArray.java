package com.zhadan.primitive;

/**
 * Created by azhadan on 7/10/13.
 */
public class PrimitiveArray {
    private int[] array;

    public PrimitiveArray(int[] array) {
        this.array = array;
    }

    public int[] getArray() {
        return array;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (int elem : getArray()) {
            builder.append(elem).append("/");
        }
        builder.delete(builder.length() - 1, builder.length());
        return builder.toString();
    }

    public int getElem(int index) {
        return array[index];
    }
}
