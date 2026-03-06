import java.util.*;
import java.io.*;
import static java.lang.Math.*;

public class prob30{
    char[][] mat;
    String[] dict;
    Set<String> words;
    boolean[][] vis;
    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(System.in);
        int numDatasets = in.nextInt();
        for(int abc = 1; abc <= numDatasets; abc++){
            Scanner f = new Scanner(new File("prob30-"+abc+"-in.txt"));
            int sz = f.nextInt();
            mat =new char[sz][sz];
            words = new TreeSet<>();
            vis = new boolean[sz][sz];
            for (int i = 0; i < sz; i++) {
                mat[i] = f.next().toCharArray();
            }

            dict = new String[191703];
            Scanner wds = new Scanner(new File("files/words.txt"));
            int cnt = 0;
            while(wds.hasNext() && cnt < dict.length){
                dict[cnt++] = wds.next();
            }

//
            for (int i = 0; i < sz; i++) {
                for (int j = 0; j < sz; j++) {
                    dfs(i, j, "");
                }
            }
            System.out.println(words.size());
            for(String s : words){
                System.out.println(s);
            }
            f.close();
        }
        //Scanner f = new Scanner(new File("prob30".toLowerCase()+".in"));

    }
    void dfs(int r, int c, String word){
        if(r < 0 || r >= mat.length || c < 0 || c >= mat.length || vis[r][c]){
            return;
        }
        word += mat[r][c];
        if(Arrays.binarySearch(dict, word) > 0 && word.length() > 2){
            words.add(word);
        }

        int[] dx = new int[]{1, 1, 1, -1, -1, -1, 0, 0};
        int[] dy = new int[]{-1, 1, 0, -1, 1, 0, -1, 1};
        vis[r][c] = true;
        for (int i = 0; i < 8; i++) {
            dfs(r + dx[i], c + dy[i], word);
        }
        vis[r][c] = false;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob30().run();
    }
}
