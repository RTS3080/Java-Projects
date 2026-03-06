import java.util.*;
import java.io.*;

public class Shivam{
    public int getCoef(String val) {
        if (val.isEmpty()) return 1;
        if (val.matches("[-+]?\\d+.*")) {
            String res = val.charAt(0) + "";
            for (int i = 1; i < val.length() && Character.isDigit(val.charAt(i)); i++) {
                res += val.charAt(i);
            }
            return Integer.parseInt(res);
        }
        return val.startsWith("-") ? -1: 1;
    }

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("Shivam".toLowerCase()+".dat"));

        int ti=f.nextInt(); f.nextLine();

        for (int z = 0; z < ti; z++) {
            System.out.print("Function " + (z + 1) + ": ");

            String func = f.nextLine().trim().substring(5);
            int a = getCoef(func.substring(0, func.indexOf("x")));
            func = func.substring(func.indexOf("^") + 2);
            int b = 0;
            if (func.contains("x")) {
                b = getCoef(func);
                func = func.substring(func.indexOf("x") + 1);
            }
            int c = func.isEmpty() ? 0 : getCoef(func);

            double discriminant = b * b - 4 * a * c;
            if (discriminant < 0) {
                System.out.println("There are no real roots to the function.");
            } else if (discriminant == 0) {
                double root = -b / 2 / a;
                if (Math.abs(root) < 0.01) root = 0;
                System.out.printf("There is one real root at (%.2f,0.00).%n", root);
            } else {
                double root1 = (-b - Math.sqrt(discriminant)) / 2 / a;
                double root2 = (-b + Math.sqrt(discriminant)) / 2 / a;

                if (root1 > root2) {
                    double temp = root1;
                    root1 = root2;
                    root2 = temp;
                }

                if (Math.abs(root1) < 0.01) root1 = 0;
                if (Math.abs(root2) < 0.01) root2 = 0;

                if (root2 - root1 < 0.0001) {
                    System.out.printf("There is one real root at (%.2f,0.00).%n", root1);
                } else System.out.printf("There are two real roots at (%.2f,0.00) and (%.2f,0.00).%n", root1, root2);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new Shivam().run();
    }
}
