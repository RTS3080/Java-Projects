import java.util.*;
import java.io.*;
import java.awt.*;
import static java.lang.Math.*;


public class sasha{

    public void run() throws FileNotFoundException{
        Scanner f= new Scanner(new File("sasha".toLowerCase()+".dat"));
        //Scanner f = new Scanner(new File("input.txt"));
        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            int size = f.nextInt();
            int[] nums = new int[size];
            int[] water = new int[size];
            for(int i = 0; i < size; i++){
                nums[i]=f.nextInt();
            }
            ArrayList<int[]> buckets = new ArrayList<>();
            int rainwater = 0;
            for (int i = 0; i < size;) {
                int sum = 0;
                int p = i+1;
                int cur = nums[i];
                boolean hitEdge=false;
                while(true){
                    if(p==size){
                        hitEdge = true;
                        break;
                    }
                    if(nums[p] >=cur){
                        break;
                    }
                    sum+=cur-nums[p];
                    p++;
                }
                if(!hitEdge && sum>0){
                    buckets.add(new int[]{i, sum});
                    rainwater+=sum;
                }
//                System.out.println(i+" "+p+" "+sum+" "+rainwater+" "+hitEdge);
                i=p;

            }

            for (int i = size-1; i >=0;) {
                int sum = 0;
                int p = i-1;
                int cur = nums[i];
                boolean hitEdge=false;
                while(true){
                    if(p==-1){
                        hitEdge = true;
                        break;
                    }
                    if(nums[p] >=cur){
                        break;
                    }
                    sum+=cur-nums[p];
                    p--;
                }
//                System.out.print(i+" "+p+" "+sum);
                i=p;
                if(!hitEdge && sum>0){
                    boolean here = false;
                    for(int[] bucket : buckets){
                        if(bucket[0]==i && bucket[1]==sum){
                            here=true;
                            break;
                        }
                    }
                    if(!here){
                    buckets.add(new int[]{i, sum});
                    rainwater+=sum;
                    }
                }
//                System.out.println(" "+rainwater+" "+hitEdge);

            }
            Collections.sort(buckets, (a,b)->a[0]-b[0]);
            if(rainwater == 0){
                System.out.println("Dry as a Bone...");
            }
            else {
//                for (int[] arr : buckets) {
//                    System.out.println(Arrays.toString(arr));
//                }
                String out = "";
                for (int[] arr : buckets) {
                    out += arr[1] + " ";
                }
                out += rainwater;
                System.out.println(out);
            }
        }
        f.close();
    }



    public static void main(String[] args) throws FileNotFoundException{
        new sasha().run();
    }
}
