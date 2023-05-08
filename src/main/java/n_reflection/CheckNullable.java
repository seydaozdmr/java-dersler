package n_reflection;

import java.lang.reflect.Field;

public class CheckNullable {
    public static<T> boolean isAllFieldsNoNull(T tClass) {
        Field[] derivedFields = tClass.getClass().getDeclaredFields();
        Class baseClass = tClass.getClass().getSuperclass();
        Field[] baseClassFields = baseClass.getClass().getDeclaredFields();

        boolean hasNonNullField = true;
        for (Field field : derivedFields) {
            boolean inherited = false;

            for (Field derivedField : baseClassFields) {
                if (field.getName().equals(derivedField.getName())) {
                    inherited = true;
                    break;
                }
            }
            if (!inherited) {
                field.setAccessible(true);
                Object fieldValue = null;
                try {
                    fieldValue = field.get(tClass);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
                if (fieldValue == null) {
                    hasNonNullField = false;
                    break;
                }
            }
        }
        return hasNonNullField;
    }
}
