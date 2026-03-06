import java.util.*;
import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class prob19{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> vowels = new ArrayList<>();

        while (f.hasNext()) {
            String line = f.next().trim().toLowerCase();
            if (line.equals("end")) {
                break;
            }

            line = "**" + line + "**";

            Pattern pattern = Pattern.compile("[^aeiou]([aeiou]{2})[^aeiou]");
            Matcher matcher = pattern.matcher(line);

            while (matcher.find()) {
                String match = matcher.group(1);
                if (!vowels.contains(match)) {
                    vowels.add(match);
                }

                map.put(match, map.getOrDefault(match, 0) + 1);
            }
        }

        for (String pair : vowels) {
            System.out.println(pair + ": " + map.get(pair));
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new prob19().run();
    }
}
