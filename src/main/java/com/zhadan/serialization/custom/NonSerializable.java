package com.zhadan.serialization.custom;

/**
 * Created with IntelliJ IDEA.
 * User: Andrew
 * Date: 26.02.14
 * Time: 22:45
 */
public class NonSerializable {
    private String myData = "bbb";

    public String getMyData() {
        return myData;
    }

    public void setMyData(String myData) {
        this.myData = myData;
    }
}
