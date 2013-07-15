package reflection;

/**
 * Created by azhadan on 7/12/13.
 */
public class ReflectClass {
    private String firstName;
    private String lastName;

    public ReflectClass() {
        System.out.println("Calling a constructor without params");
    }

    public ReflectClass(String firstName, String lastName) {
        System.out.println("Calling a constructor with params");
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @AnnotationGet
    public String getFirstName() {
        System.out.println("Get firstName");
        return firstName;
    }

    @AnnotationSet(name = "FIRST_NAME")
    public void setFirstName(String firstName) {
        System.out.println("Set firstName " + firstName);
        this.firstName = firstName;
    }

    @AnnotationGet
    public String getLastName() {
        System.out.println("Get lastName");
        return lastName;
    }

    @AnnotationSet(name = "LAST_NAME")
    public void setLastName(String lastName) {
        System.out.println("Set lastName " + lastName);
        this.lastName = lastName;
    }
}
