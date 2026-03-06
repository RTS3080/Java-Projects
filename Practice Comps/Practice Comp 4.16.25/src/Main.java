import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                list.add(new int[]{i, j});
            }
        }
        Collections.shuffle(list);



        for(int[] i : list){
            System.out.println(Arrays.toString(i));
        }
    }
}