package reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Created by azhadan on 7/12/13.
 */
public class MainReflect {

    public static void main(String[] args) {

        System.out.println("-----------------Start------------------");
        try {
            Class cls = Class.forName("reflection.ReflectClass");
            Object obj = cls.newInstance();

            Method m = cls.getDeclaredMethod("setFirstName", String.class);
            m.invoke(obj, new String("andrey"));

            Field privateField = cls.getDeclaredField("lastName");
            privateField.setAccessible(true);
            privateField.set(obj, "Zhadan");

            m = cls.getDeclaredMethod("getLastName");
            m.invoke(obj);

            System.out.print("Declared Methods ");
            Method[] methods = cls.getDeclaredMethods();
            for (Method method : methods)
                System.out.print(method.getName() + " / ");

            System.out.print("\nMethods ");
            methods = cls.getMethods();
            for (Method method : methods)
                System.out.print(method.getName() + " / ");

            System.out.print("\nDeclared Fields ");
            Field[] fields = cls.getDeclaredFields();
            for (Field field : fields)
                System.out.print(field.getName() + " / ");

            System.out.print("\nFields ");
            Field[] fields2 = cls.getFields();
            for (Field field : fields2)
                System.out.print(field.getName() + " / ");


            System.out.println("\n----Own Annotation----");
            System.out.println("\n----Just getters----");
            methods = cls.getMethods();
            for (Method method : methods) {
                Annotation annotation = method.getAnnotation(AnnotationGet.class);
                if (annotation != null)
                    method.invoke(obj);
            }

            System.out.println("\n----Setter FIRST_NAME----");
            for (Method method : methods) {
                AnnotationSet annotation = method.getAnnotation(AnnotationSet.class);
                if (annotation != null) {
                    if (annotation.name().contains("FIRST_NAME"))
                        method.invoke(obj, "Andrey");
                    else if (annotation.name().contains("LAST_NAME"))
                        method.invoke(obj, "Zhadan");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
