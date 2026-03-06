import java.util.*;
import java.io.*;

class Name {
    String name;

    public Name(String name){
        this.name = name;
    }

    public boolean equals(Name o) {
        String r1 = "QWERTYUIOP";
        String r2 = "ASDFGHJKL";
        String r3 = "ZXCVBNM";

        if (this.name.length() != o.name.length()) {
            return false;
        }

        for (int i = 0; i < name.length(); i++) {
            if (r1.indexOf(name.charAt(i)) != -1) {
                if (r1.indexOf(o.name.charAt(i)) == -1) {
                    return false;
                }
                
                if (Math.abs(r1.indexOf(name.charAt(i)) - r1.indexOf(o.name.charAt(i))) > 1) {
                    return false;
                }
            }

            if (r2.indexOf(name.charAt(i)) != -1) {
                if (r2.indexOf(o.name.charAt(i)) == -1) {
                    return false;
                }

                if (Math.abs(r2.indexOf(name.charAt(i)) - r2.indexOf(o.name.charAt(i))) > 1) {
                    return false;
                }
            }

            if (r3.indexOf(name.charAt(i)) != -1) {
                if (r3.indexOf(o.name.charAt(i)) == -1) {
                    return false;
                }

                if (Math.abs(r3.indexOf(name.charAt(i)) - r3.indexOf(o.name.charAt(i))) > 1) {
                    return false;
                }
            }
        }

        return true;
    }
}

public class rostertypos {

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("rostertypos".toLowerCase()+".in"));

        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            int len1 = f.nextInt(); int len2 = f.nextInt();

            ArrayList<Name> names = new ArrayList<>();

            for (int i = 0; i < len1; i++) {
                names.add(new Name(f.next()));
            }

            for (int i = 0; i < len2; i++) {
                Name n = new Name(f.next());
                boolean b = true;
                for (Name name : names) {
                    if (n.equals(name)) {
                        b = false;
                        break;
                    }
                }

                if (b) {
                    names.add(n);
                }
            }

            ArrayList<String> ns = new ArrayList<>();
            for (int i = 0; i < names.size(); i++) {
                ns.add(names.get(i).name);
            }

            Collections.sort(ns);
            for (String n : ns) {
                System.out.print(n + " ");
            };
            System.out.println();
        }

        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new rostertypos().run();
    }
}
