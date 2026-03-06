import java.util.*;
import java.io.*;

public class recruitment{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        double total = 0;
        int[] lens = new int[]{8, 11, 10, 4, 9};
        String[] names = new String[times];
        int[] people = new int[times];
        double[] engagement = new double[times];
        double[] costs = new double[times];
        double[] percents = new double[times];
        for(int i =0 ; i < times ; i++){
            String[] ln = f.nextLine().split(", +");
            String name = ln[0];
            double cost = Double.parseDouble(ln[1]);
            int ppl = Integer.parseInt(ln[2]);
            double percent = Double.parseDouble(ln[3])/100;
            total+=cost*ppl;
            double totCost = cost*ppl;
            double engage = (ppl*percent)/totCost;
            names[i]=name;
            lens[0] = Math.max(lens[0], name.length());
            people[i] = ppl;
            lens[1] = Math.max(lens[1], (""+ppl).length());
            engagement[i] = engage;
            lens[2] = Math.max(lens[2], (String.format("%.2f" ,engage)).length());
            costs[i] = totCost;
            lens[3]  = Math.max(lens[3], (String.format("%.2f" ,totCost)).length()+1);
        }
        for (int i = 0; i < times; i++) {
            System.out.println(costs[i]);
            percents[i] = costs[i]/total*100;
            System.out.println(percents[i]);
            lens[4] = Math.max(lens[4], (String.format("%.2f" ,percents[i])).length());
        }
        System.out.println(total);
        System.out.printf("| %-"+lens[0]+"s | %-"+lens[1]+"s | %-"+lens[2]+"s | %-"+lens[3]+"s | %-"+lens[4]+"s |\n","Position", "# of People", "Engagement", "Cost", "%of Total" );
        System.out.printf("| "+"-".repeat(lens[0])+" | "+"-".repeat(lens[1])+" | "+"-".repeat(lens[2])+" | "+"-".repeat(lens[3])+" | "+"-".repeat(lens[4])+" |\n");
        for (int i = 0; i < times; i++) {
//            System.out.println(names[i]);
//            System.out.println(people[i]);
//            System.out.println(engagement[i]);
//            System.out.println(costs[i]);
//            System.out.println(percents[i]);
            System.out.printf("| %-" + lens[0] + "s | %-" + lens[1] + "d | %-" + lens[2] + ".2f | $%-" + (lens[3] - 1) + ".2f | %.2f%%"+" ".repeat((lens[4]-1-((String.format("%.2f" ,percents[i])).length())))+" |\n", names[i], people[i], engagement[i], costs[i], percents[i]);

        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new recruitment().run();
    }
}
