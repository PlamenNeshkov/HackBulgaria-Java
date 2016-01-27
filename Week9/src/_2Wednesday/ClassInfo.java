package _2Wednesday;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by plamen on 1/27/16.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface ClassInfo {
    String author();
    int revision() default 1;
    boolean isChecked() default true;
    Class<?>[] relatedClasses();
}
