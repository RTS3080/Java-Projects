import java.util.*;
import java.io.*;

public class manisha{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("manisha".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String ln = f.nextLine().replaceAll("\\s","");


        }
        f.close();
    }
//    class exp implements Comparable<exp>{
//        String str;
//        public exp(String str){
//            this.str = str;
//        }
//        public int compareTo(exp o){
//        }
//    }
//    class a implements Comparable<a>{
//        String str;
//        int len;
//        exp e;
//        public a(String str){
//            this.str=str;
//            len = str.length();
//            for(char c : str.toCharArray()){
//                if(c=='\\'){
//                    len--;
//                }
//            }
//        }
//        public int compareTo(a o){
//            if(len==o.len){
//                return len-o.len;
//            };
//
//        }
//    }


    public static void main(String[] args) throws FileNotFoundException{
        new manisha().run();
    }
}
