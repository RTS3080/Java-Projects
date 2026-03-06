import java.util.*;
import java.io.*;

public class crypt{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("crypt".toLowerCase()+".dat"));
        while (f.hasNextLine()){
            String en =f.next(),str=f.next();
            if (f.hasNextInt()){f.nextLine();}
            char[][] mat=new char[str.length()/en.length()][en.length()];
            int w=0;
            for (int i = 0; i < mat.length; i++) {
                for (int j = 0; j < en.length(); j++) {
                    mat[i][j]=str.charAt(w);
                    w++;
                }
            }
            ArrayList<Character> c=new ArrayList<>();
            for (int i = 0; i < en.length(); i++) {
                c.add(en.charAt(i));
            }
            Collections.sort(c);
           // System.out.println(Arrays.deepToString(mat));
            str="";
            for (int i =0; i <c.size() ; i++) {
                for (int j = 0; j < mat.length; j++) {
                    str+=mat[j][en.indexOf(c.get(i))];
                }
            }
            System.out.println(str);
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new crypt().run();
    }
}

