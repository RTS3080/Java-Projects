import java.util.*;
import java.io.*;
import java.awt.*;

public class Main{
    class test<E> {
        ArrayList<E> array = new ArrayList<>();

        {
            Object res = array.remove("abcd");
            boolean res2 = array.remove("abcd");
        }
    }

    public void run() throws FileNotFoundException{
        ArrayList<String> array = new ArrayList<>();
        Object res = array.remove("abcd");
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Main().run();
    }
}
