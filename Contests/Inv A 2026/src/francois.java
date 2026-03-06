import java.util.*;
import java.io.*;
import java.awt.*;

public class francois{

    public void run() throws IOException {
        Scanner f= new Scanner(new File("francois".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String byteStream = f.nextLine();
            Object o = null;

            try {
                o = Serializer.unmarshall(byteStream);
            } catch (Exception e) {
                System.out.println("Come on problem setter, get your classes straight!");
                continue;
            }

            CustomLinkedList list = null;
            if (o instanceof CustomLinkedList) {
                list = CustomLinkedList.class.cast(o);
                CustomLinkedList newList = list.reverse();

                System.out.println(Serializer.marshall(newList));
            }
        }
        f.close();
    }



    public static void main(String[] args) throws IOException {
        new francois().run();
    }
}
