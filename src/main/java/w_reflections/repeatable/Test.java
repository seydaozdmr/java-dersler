package w_reflections.repeatable;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@MyAnnoB()
@MyAnnoB(str = "Test2")
public class Test {

    @MyAnnoB(str = "First annotation", val = -1)
    @MyAnnoB(str = "Second annotation", val = 100)
    public static void myMeth(String str, int i){
        Test ob = new Test();
        try {
            Class<?> c = ob.getClass();
            // Obtain the annotations for myMeth().
            Method m = c.getMethod("myMeth", String.class, int.class);
            // Display the repeated MyAnno annotations.
            Annotation anno = m.getAnnotation(RepeatAnno.class);
            System.out.println(anno);

            Annotation[] annos = m.getAnnotationsByType(MyAnnoB.class);
            for(Annotation a : annos)
                System.out.println(a);
        } catch (NoSuchMethodException exc) {
            System.out.println("Method Not Found.");
        } }
    public static void main(String[] args) {
        myMeth("test", 10);
    }
}
