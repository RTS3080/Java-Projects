import java.util.*;
import java.io.*;

public class yulia{
    int[][] memo;
    public void run() throws FileNotFoundException{
        Scanner in= new Scanner(new File("yulia".toLowerCase()+".dat"));
        int times  = in.nextInt();
        for (int i = 0; i < times; i++) {
            int n = in.nextInt(); in.nextLine();
            String target;
            memo = new int[n][n];
            for(int[] arr: memo){
                Arrays.fill(arr, Integer.MAX_VALUE);
            }
            char[][] mat = new char[n][n];
            for (int j = 0; j < n; j++) {
                mat[j] = in.nextLine().toCharArray();
            }
            target = in.nextLine();
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                String s1 = "";
                String s2 = "";
                for (int k = 0; k < n; k++) {
                    s1+=mat[j][k];
                    s2+=mat[k][j];
                }
                int res1 = recur(0,0, target, s1);
                int res2 = recur(0,0, target, s2);
                min = Math.min(min, Math.min(res1, res2));


            }
            System.out.println(min);

        }

        in.close();
    }

    public int recur(int i, int j, String str1, String str2){
        if(i>=str1.length()) return str1.length()-i;
        if(j>=str2.length()) return str2.length()-j;
        if(memo[i][j]!=Integer.MAX_VALUE) return memo[i][j];
        int result;
        if(str1.charAt(i)==str2.charAt(j)){
            result = recur(i+1, j+1, str1, str2);
        }
        else{
            int result1 = recur(i+1, j+1, str1, str2)+1;
            int result2 = recur(i, j+1, str1, str2)+1;
            int result3 = recur(i+1, j, str1, str2)+1;
            result = Math.min(result3, Math.min(result1, result2));
        }
        return memo[i][j] = result;
    }



    public static void main(String[] args) throws FileNotFoundException{
        new yulia().run();
    }
}

