package serialization;

import java.io.Serializable;

/**
 * Created by azhadan on 7/17/13.
 */
public class Child implements Serializable {
    protected int i;
    private Integer j;

    public Child() {
        System.out.println("Child::Empty constructor");
    }

    public Child(int i, Integer j) {
        this.i = i;
        this.j = j;
        System.out.println("Child::Constructor");
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
}
