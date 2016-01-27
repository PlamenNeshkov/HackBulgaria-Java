package _2Wednesday;

import java.util.Arrays;

/**
 * Created by plamen on 1/27/16.
 */
public class Main {
    public static void main(String[] args) {
        Foo myFoo = new Foo(1, "abc", true);
        
        Arrays.stream(myFoo.getClass().getAnnotations()).forEach(System.out::println);

        System.out.println(myFoo.getClass().getAnnotation(ClassInfo.class));
    }
}
