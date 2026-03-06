import java.util.ArrayList;
public class ArrayLists {
    public static void main(String[] args) {
        ArrayList<Integer> cal=new ArrayList<Integer>();
        cal.add(1);
        cal.add(2);
        System.out.println(cal);
        System.out.println(cal.size());
        cal.set(0,3);
        cal.add(1,3);
        System.out.println(cal);
    }
}
