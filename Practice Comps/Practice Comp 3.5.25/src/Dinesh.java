import java.util.*;
import java.io.*;

public class Dinesh{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("dinesh".toLowerCase()+".dat"));
        int cse = f.nextInt();
        f.nextLine();
        for (int tst = 0; tst < cse; tst++){
            String[] name = f.nextLine().trim().split(" ");
            int len = name.length;
            HashMap<String, Integer> NameToInd = new HashMap<>();
            for (int i = 0; i < len; i++) {
                NameToInd.put(name[i], i);
            }
            int[][] mat = new int[len][len];
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
            int paths = f.nextInt();
            for (int i = 0; i < paths; i++) {
                int ind1 = NameToInd.get(f.next());
                int ind2 = NameToInd.get(f.next());
                int weight = f.nextInt();
                mat[ind1][ind2] = weight;
                mat[ind2][ind1] = weight;
            }

            for (int i = 0; i < len; i++)
                for (int j = 0; j < len; j++)
                    for (int k = 0; k < len; k++) {
                        if (mat[i][k] == -1 || mat[k][j] == -1)
                            continue;
                        int sum = mat[i][k] + mat[k][j];
                        if (mat[i][j] == -1 || sum < mat[i][j]) {
                            mat[i][j] = sum;
                            mat[j][i] = sum;
                        }

                    }

            int queries = f.nextInt();
            for (int i = 0; i < queries; i++) {
                String name1 = f.next();
                String name2 = f.next();
                System.out.println(name1 + " to " + name2+":"+mat[NameToInd.get(name1)][NameToInd.get(name2)]);
            }
            f.nextLine();

        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Dinesh().run();
    }
}
