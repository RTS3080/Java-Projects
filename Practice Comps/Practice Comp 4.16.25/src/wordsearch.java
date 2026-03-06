import java.awt.*;
import java.util.*;
import java.io.*;

public class wordsearch{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("wordsearch".toLowerCase()+".dat"));

        int k = f.nextInt();
        f.nextLine();
        while(k-->0){
            int r = f.nextInt();
            int c = f.nextInt();
            int num = f.nextInt();
            f.nextLine();
            String res = "";
            ArrayList<String> word = new ArrayList<>();
            char[][] in = new char[r][c];
            for (int i = 0; i < r; i++) {
                String t = f.nextLine().replaceAll(" ","");
                in[i] = t.toCharArray();
            }
            for (int i = 0; i < num ; i++) {
                word.add(f.nextLine());
            }
            for (int i = 0; i < word.size(); i++) {
                String cur = word.get(i);
                char first = cur.charAt(0);
                int ret = 0;
                for (int j = 0; j < r; j++) {
                    for (int l = 0; l < c; l++) {
                        if (ret==1){
                            break;
                        }
                        if (in[j][l] == first&&(ret == 2||ret==0)) {
                            ret = Math.max(horiz(in,j,l,cur),Math.max(diag(in,j,l,cur),Math.max(rev(in,j,l,cur), vert(in,j,l,cur))));
                        }

                    }
                }
                res+=ret;
            }
            System.out.println(res);
        }
        f.close();

    }

    public int vert (char[][] in, int r, int c, String word){
        String res = "";
        int cnt = 0;
        int fr = r;
        int br = r;
        while (cnt < word.length()){
            if (br==in.length){
                br = 0;
            }
            res += ""+ in[br][c];
            br++;
            cnt++;
        }
        cnt = 0;
        String ser = "";
        while (cnt < word.length()){
            if (fr<0){
                fr = in.length-1;
            }
            ser += ""+ in[fr][c];
            fr--;
            cnt++;
        }
        if (word.equals(res)||word.equals(ser)){
            return 1;
        }
        return 0;
    }

    public int horiz (char[][] in, int r, int c, String word){
        String res = "";
        int cnt = 0;
        int bc = c;
        int fc = c;
        while (cnt < word.length()){
            if (fc==in[0].length){
                fc = 0;
            }
            res += ""+ in[r][fc];
            fc++;
            cnt++;
        }
        cnt = 0;
        String ser= "";
        while (cnt < word.length()){
            if (bc<0){
                bc = in[0].length-1;
            }
            ser += ""+ in[r][bc];
            bc--;
            cnt ++;
        }
        if (word.equals(res)||word.equals(ser)){
            return 1;
        }
        return 0;
    }

    public int diag (char[][] in, int r, int c, String word){
        String res = "";
        int cnt = 0;
        int bc = c;
        int fc = c;
        int fr = r;
        int br = r;
        while (cnt < word.length()){
            if (fr==in.length){
                fr = 0;
            }
            if (fc==in[0].length){
                fc = 0;
            }
            res += ""+ in[fr][fc];
            fr++;
            fc++;
            cnt++;
        }
        cnt = 0;
        String ser  = "";
        while (cnt < word.length()){
            if (bc<0){
                bc = in[0].length-1;
            }
            if (br<0){
                br = in.length-1;
            }
            ser += ""+ in[br][bc];
            br--;
            bc--;
            cnt++;
        }
        if (word.equals(res)||word.equals(ser)){
            return 1;
        }
        return 0;
    }

    public int rev (char[][] in, int r, int c, String word){
        String res = "";
        int cnt = 0;
        int bc = c;
        int fc = c;
        int fr = r;
        int br = r;
        while (cnt < word.length()){
            if (fr<0){
                fr = in.length-1;
            }
            if (fc==in[0].length){
                fc = 0;
            }
            res += ""+ in[fr][fc];
            cnt++;
            fr--;
            fc++;
        }
        cnt = 0;
        String ser= "";
        while (cnt < word.length()){
            if (bc<0){
                bc = in[0].length-1;
            }
            if (br==in.length){
                br = 0;
            }
            ser += ""+ in[br][bc];
            cnt++;
            br++;
            bc--;
        }
        if (word.equals(res)||word.equals(ser)){
            return 1;
        }
        return 0;
    }


    public static void main(String[] args) throws FileNotFoundException{
        new wordsearch().run();
    }
}
