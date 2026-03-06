import java.util.*;
import java.io.*;

public class christina{

    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("christina".toLowerCase()+".dat"));
        int times = in.nextInt();
        String [] arr = new String[times];
        for (int i = 0; i < times; i++) {
            arr[i] = in.next();
        }
        in.nextLine();
        while(in.hasNext()){
            String str = in.nextLine();
            int s = 0;
            int e = 3;
            String ans = "";
            while(e<=str.length()){
                String sub = str.substring(s,e);
                int num = Integer.parseInt(sub.substring(0,2))-1;
                String name = arr[num];
                char ch = sub.charAt(2);
                String add;
                if(ch=='l') {
                    add = reverse(name);
                    add = add.toLowerCase();
                    ans+=add;
                }
                if(ch=='r') {
                    add = reverse(name);
                    ans+=add;
                }
                if(ch=='u') {
                    add = reverse(name);
                    add = add.toUpperCase();
                    ans+=add;
                }
                if(ch=='U') {
                    add = name;
                    add = add.toUpperCase();
                    ans+=add;
                }
                if(ch=='R') {
                    add = name;
                    ans+=add;
                }
                if(ch=='L') {
                    add = name;
                    add = add.toLowerCase();
                    ans+=add;
                }
                s+=3;
                e+=3;
            }
            System.out.println(ans);

        }

        in.close();
    }
    public String reverse(String str){
        String ans = "";
        for(int i=str.length()-1;i>=0;i--){
            ans += str.charAt(i);
        }
        return ans;

    }




    public static void main(String[] args) throws FileNotFoundException{
        new christina().run();
    }
}

