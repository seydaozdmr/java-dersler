package w_reflections;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Deprecated
public class Meta {
    @MyAnno(str = "Two parameters",val = 10)
    public static void myMethod(String str,int i){
        Meta meta=new Meta();

        try{
            Class<?> clazz=meta.getClass();

            Method method= clazz.getMethod("myMethod", String.class, int.class);
            MyAnno myAnno= method.getAnnotation(MyAnno.class);

            System.out.println(myAnno.str()+" "+myAnno.val());

            Annotation[] annotations = clazz.getAnnotations();
            for (Annotation a:annotations){
                System.out.println(a);
            }
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        myMethod("test",19);
    }
}
