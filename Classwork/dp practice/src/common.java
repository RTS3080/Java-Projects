import java.util.*;
import java.io.*;

public class common{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("lcs".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            String s1=f.next().trim();
            String s2=f.nextLine().trim();
            String str= recur(s1,s2,s1.length()-1,s2.length()-1);
            String reg="";
            for (int i = 0; i < s1.length() && i<s2.length(); i++) {
                if(!str.contains(s1.substring(i, i + 1)))
                    reg+=s1.substring(i,i+1);
                if(!str.contains(s2.substring(i,i+1)))
                    reg+=s2.substring(i,i+1);
            }
            if(!reg.isEmpty())
                reg="["+reg+"]";
//            System.out.println(reg);
            String[] s1Words = s1.split(reg);
            String[] s2Words= s2.split(reg);
//            System.out.println(Arrays.toString(s1Words)+" "+Arrays.toString(s2Words));
            String big1="";
            for(String s :s1Words){
                if(s.length()>big1.length())
                    big1=s;
            }
            String big2 = "";
            for(String s:s2Words){
                if(s.length()>big2.length())
                    big2=s;
            }
            String big=big1.length()>big2.length()?big2 :big1;


        }
        f.close();
    }

    String recur(String s1, String s2, int n, int m) {
        if(n<0 || m<0)
            return "";
        if(s1.charAt(n) == s2.charAt(m)){
            return recur(s1,s2,n-1,m-1)+s1.charAt(n);
        }
        String one = recur(s1,s2,n-1,m);
        String two = recur(s1,s2,n,m-1);
        if(one.length()>two.length())
            return one;
    return two;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new common().run();
    }
}
