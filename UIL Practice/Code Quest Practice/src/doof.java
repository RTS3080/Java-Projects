import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static java.lang.Math.*;
import java.util.Scanner;

public class doof {
    public static void main(String[] args) {
        System.out.printf("%.3s%.2s\n", "What", "Up");

        int n = 1;

        int res = switch(n)
        {
            case 1:
            case 2:
            case 3:
            default:{
                yield 5;
            }
        };

        System.out.println((int)Character.MAX_VALUE);
        System.out.println(Short.MAX_VALUE);
        Integer a = 1;
        Integer b = 128;

        int c = (Integer) 5;
        List<String> arr = Arrays.asList("1 2 3 4 5".split(" "));
        testing(arr);
        System.out.println(arr);
        System.out.println(b);

        float f = Float.MAX_VALUE * 2;
        float modifier = 10f;
        int count = 0;

        System.out.println(f);
        float cnt = 1;
        while(Float.isInfinite(f)){
            f = Float.MAX_VALUE * (((float)(pow(1/10f, count))+1));
            count++;
            String s= Integer.toString(Float.floatToIntBits(f), 2);
            for (int i = s.length(); i >= 0; i-=8) {
                s=s.substring(0,i)+" "+s.substring(i);
            }
            System.out.println(s.trim());
        }
        System.out.println(count);
        System.out.println(f);
        System.out.println(Float.MAX_VALUE);
        System.out.println(cnt);
        System.out.println(f);
    }

    public static void testing(List<String> a){
        List<String> t = Arrays.asList("1 2 3 4 5 6 7 8 9".split(" "));
        a=new ArrayList<>();
    }
}
