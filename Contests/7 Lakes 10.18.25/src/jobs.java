//import java.util.*;
//import java.io.*;
//
//public class jobs{
//    static class Operative implements Comparable<Operative> {
//        String first;
//        String last;
//        double friendliness;
//        String[] jobs;
//
//        public Operative(String f, String l, double fr, String[] j){
//            first = f;
//            last = l;
//            friendliness = fr;
//            jobs = j;
//        }
//
//        public boolean hasJob(String job) {
//            for (int i = 0; i < jobs.length; i++) {
//                if (jobs[i].equals(job)) return true;
//            } return false;
//        }
//
//        public int compareTo(Operative o) {
//            if (!first.equals(o.first)) return first.compareTo(o.first);
//            return last.compareTo(o.last);
//        }
//    }
//
//    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(System.in);
//
//        int numOps = f.nextInt();
//        int numJobs = f.nextInt();
//
//        String[] jobs = new String[numJobs];
//        for (int i = 0; i < numJobs; i++) {
//            jobs[i] = f.next();
//        }
//        Operative[] ops = new Operative[numOps];
//
//        Arrays.sort(ops);
//        ArrayList<Operative>[] res = new ArrayList[numJobs];
//        for (int i = 0; i < numJobs; i++) {
//            res[i] = new ArrayList<>();
//        }
//
//        int jidx = 0;
//        int oidx = 0;
//
//        while (jidx < numJobs && oidx < numOps) {
//            Operative op = ops[oidx];
//            if (op.first.equals("Jeff")) {
//                while (jidx < numJobs && jobs[jidx].equals("MainframeDestruction")) {
//                    jidx++;
//                }
//
//                if (jidx < numJobs) {
//                    if (add(res[jidx], op)) {
//                        oidx++;
//                    } else {
//                        break;
//                    }
//                } else {
//                    break;
//                }
//            }
//        }
//
//        f.close();
//    }
//
//    public boolean add(ArrayList<Operative> job, Operative op) {
//        job.add(op);
//        HashMap<String, Integer> count;
//        double friendly = 0;
//
//        for (Operative o : job) {
//            count.put(o, count.getOrDefault(o, 0) + 1);
//        }
//    }
//
//
//
//    public static void main(String[] args) throws FileNotFoundException{
//        new jobs().run();
//    }
//}
