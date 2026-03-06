import java.util.*;
import java.io.*;

public class ikea{

    char[][][] mat;
    boolean[][][] shadow;
    int furniture;
    char[] find;
    String found;
    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("ikea".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int levels = f.nextInt(), rows = f.nextInt(), cols = f.nextInt();
            furniture = f.nextInt();
            f.nextLine();
            mat = new char[levels][rows][cols];
            shadow = new boolean[levels][rows][cols];
            String finds = "";
            int startL = -1; int startR = -1, startC = -1;
            int endL = -1; int endR = -1, endC = -1;
            for (int i = 0; i < levels; i++) {
                for (int j = 0; j < rows; j++) {
                    mat[i][j] = f.nextLine().trim().toCharArray();
//                    System.out.println(mat[i][j]);
                    for(int k = 0; k < cols; k++){
                        if(mat[i][j][k]== 'S'){
                            startL = i;
                            startR = j;
                            startC = k;
                        }
                        if(mat[i][j][k]== 'E'){
                            endL = i;
                            endR = j;
                            endC = k;
                        }
                        if(Character.isDigit(mat[i][j][k])){
                            finds += mat[i][j][k];
                        }
                    }
                }
            }
            finds+='E';
            find = finds.toCharArray();
            Arrays.sort(find);
//            System.out.println(find);
            found="";
            if(startR==-1 || endR==-1){
                System.out.println("IKEAnnot do it.");
            }
            else {
                recur(startL, startR, startC, 0);
//                System.out.println(found);
                System.out.println(shadow[endL][endR][endC] && found.length()-1 == furniture ? "IKEAn do it." : "IKEAnnot do it.");
            }
        }
        f.close();
    }
    void recur(int l, int r, int c, int search){
        if(l<0 || r<0 || c<0 || l >= mat.length || r >= mat[l].length || c >= mat[l][r].length
        || shadow[l][r][c] || mat[l][r][c] == '#'){
            return;
        }
        if(mat[l][r][c]==find[search]){
//            System.out.println(find[search]);
            found+=find[search];
            if(find[search]!='E') {
                for (int i = 0; i < shadow.length; i++) {
                    for (int j = 0; j < shadow[l].length; j++) {
                        Arrays.fill(shadow[i][j], false);
                    }
                }
            }
            search = Math.min(search+1, find.length-1);
        }
        shadow[l][r][c] = true;
        if(mat[l][r][c] == 'Z'){
            recur(l+1, r, c, search);
            recur(l-1, r, c, search);
        }
        recur(l, r+1, c, search);
        recur(l, r-1, c, search);
        recur(l, r, c+1, search);
        recur(l, r, c-1, search);
    }


    public static void main(String[] args) throws FileNotFoundException{
        new ikea().run();
    }
}
