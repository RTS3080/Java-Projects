import java.util.*;
import java.io.*;

public class translation{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int len = f.nextInt();
            String str = f.next();
            List<Character> L = new ArrayList<>();
            for(Character c : str.toCharArray()){
                L.add(c);
            }
            Collections.rotate(L, 67* (len%2==0?-1:1));
            double med = 0;
            List<Character> copy = new ArrayList<>(List.copyOf(L));
            Collections.sort(copy);
            if(copy.size()%2==1){
                med = copy.get(copy.size()/2);
            }
            else{
                med = (copy.get(copy.size()/2)+copy.get(copy.size()/2-1))/2.;
            }
            for (int i = L.size()-1; i >= 0; i--) {
                if(L.get(i)<med){
                    L.remove(i);
                }
            }
            len = L.size();
            for (int i = 0; i < L.size(); i++) {
                char c = L.get(i);
                if(Character.isUpperCase(c)){
                    c+=32;
                    if(c<='z'-len){
                        c+=len;
                    }
                }
                else{
                    c-=32;
                    if(c<='Z'-len){
                        c+=len;
                    }
                }
                L.set(i,c);
            }
            String s = "";
            for(char c :L){
                s+=c;
            }
            System.out.println(s);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new translation().run();
    }
}
