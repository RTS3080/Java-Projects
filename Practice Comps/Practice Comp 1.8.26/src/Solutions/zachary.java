package Solutions;

import java.util.*;
import java.io.*;

// i'm commenting my solution because i'm nice like that - thanh le

public class zachary {
    public static void main(String[] args) throws Exception {
//        for (int times = 0; times < 2; times++) {
//            int size = (int)(Math.random() * 1e3) + 1;
//            for(int i = 0;i < 2;i++){
//                String ln = "";
//                for (int j = 0; j < size; j++) {
//                    ln+= (int)(Math.random() * Integer.MAX_VALUE + 1) + " ";
//                }
//                System.out.println(ln.trim());
//            }
//        }
        new zachary().run();
    }

    public void run() throws Exception {
        Scanner f = new Scanner(new File("./judge/zachary.dat"));
        //Scanner f = new Scanner(System.in);
        int times = f.nextInt();
        f.nextLine();
        for(int asdf = 1;asdf <= times;asdf++){
            int[] oranges = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            int[] basket = Arrays.stream(f.nextLine().trim().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            for(int i = 0;i < oranges.length;i++){
                boolean found = false;
                for(int j = 0;j < i;j++){
                    if(basket[j] >= oranges[i]){
                        oranges[i] = j + 1;
                        basket[j] = -1;
                        found = true;
                        System.out.print(j + 1 + " ");
                        break;
                    }
                }
                if(!found) {
                    oranges[i] = -1;
                    System.out.print("-1 ");
                }
            }
            System.out.println();
//            System.out.println(Arrays.toString(oranges).replaceAll("[\\[\\],]",""));
        }
        f.close();
    }
}
