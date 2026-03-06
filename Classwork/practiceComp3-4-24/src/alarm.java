import java.util.*;
import java.io.*;

public class alarm{
    public static void main(String[] args) throws FileNotFoundException{
        Scanner f= new Scanner(new File("alarm".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            char c=f.next().charAt(0);
            int size=f.nextInt();
            if (size > 0) System.out.println((c + "").repeat(size));
            for (int i = 0; i < size - 2; i++) {
                System.out.println(c + " ".repeat(size - 2) + c);
            }
            if (size > 1)
                System.out.println((c + "").repeat(size));
            System.out.println();
//            for (int i = 0; i < size; i++) {
//                box[i][0]=c;
//                box[i][size-1]=c;
//            }
//            for(char[] ch:box){
//                System.out.println(ch);
////                for(char a:ch){
////                    System.out.print(a);
////                }
////                System.out.println();
//            }
//            System.out.println();
        }
        f.close();
    }
}
