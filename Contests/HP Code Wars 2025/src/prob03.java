import java.util.*;
import java.io.*;

public class prob03{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int count = 0;
        while(f.hasNext()){
            String s = f.nextLine();
            if(s.equals("<TERMINATE>")){
                break;
            }
            count++;
        }
        if(count == 1){
            System.out.println("Hey, ChatGPT, I need a code!");

        }
        else {
            System.out.println("Hey, ChatGPT, I need " + count + " codes!");
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob03().run();
    }
}
