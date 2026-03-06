import java.util.*;
import java.io.*;

public class codequality{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("codequality".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            Stack<Character> s = new Stack<>();
            int par = 0, brack = 0, curl = 0;
            boolean ok = true;
            int bad = Integer.MAX_VALUE;
            int times2 = 0;
            if(f.hasNext()) {
                times2 = f.nextInt();
                f.nextLine();
            }
            boolean broken = false;
            String str = "";
            while(times2-->0){
                str+=f.nextLine();
            }
            for (int i = 0; i < str.length(); i++) {
                if(str.substring(i,i+1).matches("[()\\[\\]{}]")){
                    if(s.isEmpty()){
                        if(str.substring(i,i+1).matches("[\\)\\]}]")){
                            ok = false;
                            bad = Math.min(i,bad) ;
                            broken = true;
                        }
                        else{
                            s.push(str.charAt(i));
                        }
                    }
                    else{
                        char p = s.pop();
                        char here = str.charAt(i);
                        if((here+"").matches("[\\)\\]}]")){
                            boolean good = true;
                            switch(p){
                                case '(' -> {
                                    if(here == ')') par++;
                                    else good = false;
                                }
                                case '[' ->{
                                    if(here == ']') brack++;
                                    else good = false;
                                }
                                case '{'->{
                                    if(here == '}') curl++;
                                    else good = false;
                                }
                            }
                            if(!good){
                                ok = false;
                                bad = Math.min(i ,bad);
                                broken = true;
                            }
                        }
                        else{
                            s.push(p);
                            s.push(here);
                        }
                    }
                }
            }
            if(!s.isEmpty() && !broken){
                ok= false;
                bad = -1;
            }
            if(ok){
                System.out.printf("YES %d () %d [] %d {}\n", par*2, brack*2, curl*2);
            }
            else {
                System.out.println("NO "+bad);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new codequality().run();
    }
}
