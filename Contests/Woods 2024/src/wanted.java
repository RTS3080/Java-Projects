import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;

public class wanted {

    public class Criminal {
        public String name;
        public String rank;

        public int crimes;

        public double strength;

        public int caught;
        GregorianCalendar bday;

        public Criminal(String n, String r, int c, double s, int ca, GregorianCalendar bday) {
            name = n;
            rank = r;
            crimes = c;
            strength = s;
            caught = ca;
            this.bday = bday;
        }

    }

    public void run () throws Exception {
        Scanner f = new Scanner(new File("Wanted".toLowerCase() + ".dat"));
        int l = f.nextInt();
        ArrayList<String> ranks = new ArrayList<>();
        String[] temp = {"Kingpin", "Underboss", "Captain", "Operative", "Affiliate"};
        Collections.addAll(ranks, temp);
        for (int i = 0; i < l; i++) {
            ArrayList<Criminal> criminals = new ArrayList<>();
            int l2 = f.nextInt();
            f.nextLine();
            for (int j = 0; j < l2; j++) {
                String[] str = f.nextLine().split(" ");
                GregorianCalendar cal = new GregorianCalendar();
                cal.setTime(new SimpleDateFormat("MM/dd/yyyy").parse(str[5]));
                Criminal john = new Criminal(str[0], str[1], Integer.parseInt(str[2]), Double.parseDouble(str[3]), Integer.parseInt(str[4]), cal);
                criminals.add(john);
            }
            ArrayList<String> one = new ArrayList<>();
            ArrayList<String> two = new ArrayList<>();
            Collections.sort(criminals, (a, b) -> {
                if (a.name.equals("Steven") || b.name.equals("Nikhil")) {
                    return -1;
                }
                if (b.name.equals("Steven") || a.name.equals("Nikhil")) {
                    return 1;
                }
                if (!a.rank.equals(b.rank)) {
                    return ranks.indexOf(a.rank) - ranks.indexOf(b.rank);
                }
                if (a.crimes != b.crimes) {
                    return b.crimes - a.crimes;
                }
                if (a.strength != b.strength) {
                    return (a.strength > b.strength ? -1 : 1);
                }
                if (a.caught != b.caught) {
                    return a.caught - b.caught;
                }
                if (a.bday.compareTo(b.bday) != 0) {
                    return a.bday.compareTo(b.bday);
                }
                return a.name.compareTo(b.name);
            });
            System.out.println("Most WANTED:");
            int ct = 0;
            for (Criminal c : criminals) {
                System.out.println(++ct + ". " + c.name);
            }
            System.out.println("-".repeat(10));
        }
    }
    public static void main(String[] args) throws Exception {
        new wanted().run();
    }
}
