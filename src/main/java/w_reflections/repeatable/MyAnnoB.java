package w_reflections.repeatable;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Repeatable(RepeatAnno.class)
public @interface MyAnnoB {
    String str() default "Testing";
    int val() default 1000;
}
