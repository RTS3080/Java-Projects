import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldStuff {
    static final int a = 5;
    class FinalHolder {
        final int a = 3;
    }

    public void run() throws Exception{
        Field field = Integer.class.getDeclaredField("value");
        field.setAccessible(true);
        field.setInt(42, 99);
        System.out.println(42);
    }

    public static void main(String[] args) throws Exception {
        new FieldStuff().run();
    }
}
