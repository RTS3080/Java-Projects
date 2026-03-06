import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;
import java.io.*;
import java.util.function.BiFunction;
import java.util.function.Function;

public class prob23{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int top = f.nextInt();
        int mid = f.nextInt();
        int bot = f.nextInt();

        f.nextLine();
        ArrayList<String> topStrs = new ArrayList<>();
        ArrayList<String> midStrs = new ArrayList<>();
        ArrayList<String> botStrs = new ArrayList<>();
        ArrayList<String> emptyStrs = new ArrayList<>();

        Function<String, Integer> getWidth = (a) -> a.length() - a.replace(" ", "").length();

        while (f.hasNext()) {
            String line = f.nextLine().trim();
            int width = getWidth.apply(line);
            if (width == 0) {
                emptyStrs.add(line);
            } else if (width <= top) {
                topStrs.add(line);
            } else if (width <= mid) {
                midStrs.add(line);
            } else if (width <= bot) {
                botStrs.add(line);
            }
        }

        emptyStrs.sort((a, b) -> {
            if (a.startsWith("T") || b.startsWith("B"))
                return -1;
            if (a.startsWith("B") || b.startsWith("T")) {
                return 1;
            } return 0;
        });

        Comparator<String> sort = Comparator.comparingInt(getWidth::apply);

        topStrs.sort(sort);
        midStrs.sort(sort);
        botStrs.sort(sort);

        int empStart = (emptyStrs.size() + 1) / 2;
        for (int i = 0; i < empStart; i++) {
            System.out.println(emptyStrs.get(i));
        }

        print(topStrs);
        print(midStrs);
        print(botStrs);

        for (int i = empStart; i < emptyStrs.size(); i++) {
            System.out.println(emptyStrs.get(i));
        }
        f.close();
    }

    public void print(ArrayList<String> lines) {
        int i = 0;
        while (i < lines.size()) {
            System.out.println(lines.get(i));
            i += 2;
        }

        if (i == lines.size()) {
            i--;
        } else {
            i -= 3;
        }

        while (i >= 0) {
            System.out.println(lines.get(i));
            i -= 2;
        }
    }

    public static void main(String[] args) throws FileNotFoundException{
        new prob23().run();
    }
}
