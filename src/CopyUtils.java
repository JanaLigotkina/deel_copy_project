import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class CopyUtils {
    private static final Map<Class<?>, Object> DEFAULT_VALUES = new HashMap<>();

    public static <T> T deepCopy(T obj) throws Exception {
        if (obj == null) {
            return null;
        }

        Class<T> objectClass = (Class<T>) obj.getClass();
        if (objectClass.isPrimitive() || objectClass == String.class || Number.class.isAssignableFrom(objectClass) || objectClass == Boolean.class) {
            return obj;
        }

        if (objectClass.isArray()) {
            int length = Array.getLength(obj);
            T copy = (T) Array.newInstance(objectClass.getComponentType(), length);
            for (int i = 0; i < length; i++) {
                Array.set(copy, i, deepCopy(Array.get(obj, i)));
            }
            return copy;
        }

        if (Collection.class.isAssignableFrom(objectClass)) {
            Collection copy = (Collection) objectClass.newInstance();
            for (Object element : (Collection) obj) {
                copy.add(deepCopy(element));
            }
            return (T) copy;
        }

        T copy = objectClass.getDeclaredConstructor().newInstance();
        for (Field field : objectClass.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                field.setAccessible(true);
                field.set(copy, deepCopy(field.get(obj)));
            }
        }
        return copy;
    }
}
