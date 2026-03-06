import java.util.*;
import java.io.*;

public class RoundaboutRounding{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        PrintWriter pw= new PrintWriter(new File("Rounding".toLowerCase()+".out"));
        int times=f.nextInt(); f.nextLine();
        timeloop:
        while(times-->0){
            int a = f.nextInt();
            int diff = 0;
            for (int i = 0; i <= a; i++) {
                if((i+"").matches(".*4[56789].*")){
                    diff++;
                }
            }
            System.out.println(diff);
            pw.println(diff);
        }
        pw.flush();
        f.close();
    }

    public int normalRounding(int a,int n){
        if(n == 0) return a;
        String s = a+"";
        int dig = s.charAt(s.length()-n)-'0';
//        System.out.println("dig "+dig+" n "+n);
        if(dig>=5){
            a = (a-a%(int) Math.pow(10,n)) + (int)Math.pow(10,n);
        }
        else{
            a -= a%(int) Math.pow(10,n);
        }
        return a;
    }
    public int chainRounding(int a,int n){
        for(int i=1;i<=n;i++){
            a = normalRounding(a,i);
        }
        return a;
    }

    public static void main(String[] args) throws FileNotFoundException{
        new RoundaboutRounding().run();
    }
}


//import java.util.*;
//import java.io.*;

//public class RoundaboutRounding{
//
//    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(System.in);
//        PrintWriter pw= new PrintWriter(new File("Rounding".toLowerCase()+".out"));
//        int times=f.nextInt(); f.nextLine();
//        timeloop:
//        while(times-->0){
//            int a = f.nextInt();
//            int diff = 0;
//            for (int i = 0; i <= a; i++) {
//                if(normalRounding(i,(i+"").length())!=chainRounding(i,(i+"").length()))
//                    diff++;
//            }
//            System.out.println(diff);
//            pw.println(diff);
//        }
//        pw.flush();
//        f.close();
//    }
//
//    public int normalRounding(int a,int n){
//        if(n == 0) return a;
//        String s = a+"";
//        int dig = s.charAt(s.length()-n)-'0';
////        System.out.println("dig "+dig+" n "+n);
//        if(dig>=5){
//            a = (a-a%(int) Math.pow(10,n)) + (int)Math.pow(10,n);
//        }
//        else{
//            a -= a%(int) Math.pow(10,n);
//        }
//        return a;
//    }
//    public int chainRounding(int a,int n){
//        for(int i=1;i<=n;i++){
//            a = normalRounding(a,i);
//        }
//        return a;
//    }
//
//    public static void main(String[] args) throws FileNotFoundException{
//        new RoundaboutRounding().run();
//    }
//}
