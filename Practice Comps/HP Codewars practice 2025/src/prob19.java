import java.util.*;
import java.io.*;

public class prob19{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("prob19".toLowerCase()+".in.txt"));
        ArrayList<Integer>[] rotors = new ArrayList[4];

        String[] spots = new String[4];
        spots[0] = "1360548792";
        spots[1] = "0352691487";
        spots[2] = "5917380246";
        spots[3] = "1652907438";
        for (int i = 0; i < 4; i++) {
            rotors[i] = new ArrayList();
            for (int j = 0; j < 10; j++) {
                rotors[i].add(Integer.parseInt(spots[i].substring(j,j+1)));
            }
        }
        ArrayList<Integer> reflector = new ArrayList();
        String ref = "3680541927";
        for (int i = 0; i < 10; i++) {
            reflector.add(Integer.parseInt(ref.substring(i,i+1)));
        }
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            System.out.println(Arrays.toString(rotors));
            ArrayList<Integer>[] rots = new ArrayList[3];
            int[] chosenRotors = new int[3];
            int[] startingRotations = new int[3];
            for (int i = 0; i < 3; i++) {
                chosenRotors[i] = f.nextInt();
                startingRotations[i] = f.nextInt();
            }
            System.out.println("chosen: "+Arrays.toString(chosenRotors));
            System.out.println("starting rotations: "+Arrays.toString(startingRotations));
            System.out.println("chosen arrs: ");
            for (int i = 0; i < 3; i++) {
                rots[i] = new ArrayList<>();
                for (int j = 0; j < 10; j++) {
                    rots[i].add(rotors[chosenRotors[i]-1].get(j));
                }
                System.out.println(rots[i]);
            }
            System.out.println("rotated: ");
            for (int i = 0; i < 3; i++) {
                Collections.rotate(rots[i], startingRotations[i]);
                System.out.println(rots[i]);
            }
            f.nextLine();
            String s = f.nextLine();
            int[] ln = Arrays.stream(s.split("")).mapToInt(Integer::parseInt).toArray();
            String end = "";
            int count = 0;
            while(count<ln.length){
                int n = ln[count];
                for (int i = 0; i < 3; i++) {
                    n = rots[i].get(n);
//                    System.out.print(n);
                }
//                System.out.println();
                n = reflector.get(n);

//                System.out.println(n);
                for(int i = 2; i>=0;i--){
                    n = rots[i].indexOf(n);
//                    System.out.print(n);
                }
//                System.out.println();

                end+=n;
                count++;

                Collections.rotate(rots[2], 1);
                if(count%10 == 0){
                    Collections.rotate(rots[1], 1);
                }
                if(count%100 == 0){
                    Collections.rotate(rots[0], 1);
                }
//                for (int i = 0; i < 3; i++) {
//                    System.out.println(rots[i]);
//                }
//                System.out.println();
            }
            System.out.println(s);
            System.out.println(end);
        }
        f.close();
    }

    
    
    public static void main(String[] args) throws FileNotFoundException{
        new prob19().run();
    }
}
