import java.util.*;
import java.io.*;

public class Dennis{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Dennis".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int maxLen = 0;
            ArrayList<String> words = new ArrayList<>();
            int times2=f.nextInt(); f.nextLine();
            while(times2-->0){
                String s = f.nextLine().trim();
                maxLen = Math.max(maxLen, s.length());
                words.add(s);
            }
            char[][] mat = new char[maxLen][words.size()];
            for(char[]  chs : mat){
                Arrays.fill(chs, ' ');
            }
            for (int i = 0; i < maxLen; i++) {
                for (int j = 0; j < words.size(); j++) {
                    int a = i;
                    if(a>=words.get(j).length()) continue;
                    mat[i][j] = words.get(j).charAt(a);
                }
            }
            for(char[]  chs : mat){
                System.out.println(chs);
            }
            System.out.println("*".repeat(words.size()));
        }
        f.close();
    }
    
    
    
    public static void main(String[] args) throws FileNotFoundException{
        new Dennis().run();
    }
}
