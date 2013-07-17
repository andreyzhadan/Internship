package serialization;

import java.io.Serializable;

/**
 * Created by azhadan on 7/17/13.
 */
public class Child implements Serializable {
    private static final long serialVersionUID = 2016996208819017963L;
    protected int i;
    private Integer j;
    private Object obj;

    public Child(int i, Integer j, Object obj) {

        this.i = i;
        this.j = j;
        this.obj = obj;

        System.out.println("Child::Constructor");
    }

    public Child() {
        System.out.println("Child::Empty constructor");
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public Integer getJ() {
        return j;
    }

    public void setJ(Integer j) {
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }
}
