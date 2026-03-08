import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class prob19{

    public void run() throws FileNotFoundException{
        //Scanner f= new Scanner(new File("prob19".toLowerCase()+".dat"));
        Scanner f = new Scanner(new File("input.txt"));
//        Scanner f = new Scanner(System.in);

        String line = f.nextLine().trim();
        String[] numsarr = line.split("\\D");
        ArrayList<Character> ops = new ArrayList<>();

        ArrayList<Integer> nums = new ArrayList<>();

        for (int i = 0; i < numsarr.length; i++) {
            nums.add(Integer.parseInt(numsarr[i]));
        }

        for (char ch : line.toCharArray()) {
            if (!Character.isDigit(ch)) {
                ops.add(ch);
            }
        }

        boolean hasMult = true;

        while (!ops.isEmpty()) {
            for (int i = 0; i < ops.size(); i++) {
                if ("*/".contains("" + ops.get(i))) {
                    int left = nums.get(i);
                    int right = nums.remove(i + 1);
                    char op = ops.remove(i);

                    nums.set(i, switch (op) {
                        case '*' -> left * right;
                        default -> left / right;
                    });

                    for (int j = 0; j < ops.size(); j++) {
                        System.out.print(nums.get(j) + "" + ops.get(j));
                    }
                    System.out.println(nums.getLast());

                    i--;
                    continue;
                }

                else if (!hasMult) {
                    int left = nums.get(i);
                    int right = nums.remove(i + 1);
                    char op = ops.remove(i);

                    nums.set(i, switch (op) {
                        case '+' -> left + right;
                        default -> left - right;
                    });

                    for (int j = 0; j < ops.size(); j++) {
                        System.out.print(nums.get(j) + "" + ops.get(j));
                    }
                    System.out.println(nums.getLast());
                    i--;
                }

            }
            hasMult = false;
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob19().run();
    }
}
