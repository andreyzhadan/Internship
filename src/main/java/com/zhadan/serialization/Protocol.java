package com.zhadan.serialization;

import java.io.Serializable;

/**
 * Created by azhadan on 7/19/13.
 */
public class Protocol implements Serializable {
    private Type type;
    private String text;

    public Protocol(Type type, String text) {
        this.type = type;
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public static enum Type {
        INFO, ACTION;
    }
}
