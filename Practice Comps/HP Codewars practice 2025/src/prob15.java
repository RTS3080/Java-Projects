import java.util.*;
import java.io.*;

public class prob15{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob15".toLowerCase()+".in.txt"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            char[] s = f.nextLine().trim().toCharArray();
            for (int i = 0; i < s.length; i++) {
                int a = s[i]-'A'+1;
                if(a<=5){
                    a+=6;
                }
                else if(a<=10){
                  a= a * a;
                }
                else if(a<=15){
                    a = (a%3)*5+1;
                }
                else if(a<=20){
                    int sum = Arrays.stream((a+"").split("")).mapToInt(Integer::parseInt).sum();

                    a = sum*8;
                }
                else{
                    int fac = a-1;
                    while(a%fac>0){
                        fac--;
                    }
                    a = fac*2;
                }
                a-=1;
                a%=26;
                System.out.print((char)(a+'A'));
            }
            System.out.println();
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob15().run();
    }
}
