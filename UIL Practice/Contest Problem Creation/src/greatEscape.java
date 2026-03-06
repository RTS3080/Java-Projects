import java.util.*;
import java.io.*;
import java.awt.*;

public class greatEscape{
    double xSize;
    double ySize;
    double zSize;

    public void run() throws FileNotFoundException{
//        Scanner f= new Scanner(new File("greatEscapeStudent".toLowerCase()+".dat"));
        Scanner f= new Scanner(new File("greatEscapeJudge".toLowerCase()+".dat"));
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            xSize = f.nextDouble();
            ySize = f.nextDouble();
            zSize = f.nextDouble();
            ArrayList<Sphere> spheres = new ArrayList<>();
            int times2=f.nextInt(); f.nextLine();
            for(int i = 0; i< times2; i++){
                Sphere s = new Sphere(i,f.nextDouble(), f.nextDouble(), f.nextDouble(), f.nextDouble(), f.nextDouble());
                spheres.add(s);
            }
//            System.out.println("did we get here 1");
            HashMap<Integer, double[]> map = new HashMap<>();
            for (int i = 0; i < spheres.size(); i++) {
                map.put(i, new double[spheres.size()]);
            }
            for (int i = 0; i < spheres.size(); i++) {
                for (int j = 0; j < spheres.size(); j++) {
                    Sphere a = spheres.get(i);
                    Sphere b = spheres.get(j);
                    map.get(i)[j] = Math.sqrt(Math.pow(a.x-b.x, 2)+Math.pow(a.y-b.y, 2)+Math.pow(a.z-b.z, 2));
                }
            }
//            System.out.println("did we get here 2");
            // i = which direction we are on, starting = all the nodes that intersect with the current axes we are on
            int[] minTimes = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
            for (int i = 0; i < 3; i++) {
                int t = 0;
                while(minTimes[i]>t) {
                    ArrayList<Object[]> starting = new ArrayList<>();

                    //finding all the spheres that intersect the wall we are on
                    for (int j = 0; j < 3; j++) {
                        for (Sphere s : spheres) {
                            if (!s.intersectsWall(i, t, xSize, ySize, zSize).isEmpty()) {
                                for (int a : s.intersectsWall(i, t, xSize, ySize, zSize)) {
                                    starting.add(new Object[]{s, a});
                                }
                            }
                        }
                    }
//                    for(Object[] a : starting){
//                        System.out.println("Starting Node "+a[0]+" "+a[1]+" time = "+t+" radius = "+(((Sphere)a[0]).ri +((Sphere)a[0]).rate*t)+" intersecting side "+i);
//                    }
                    for (int j = 0; j < starting.size(); j++) {
                        Sphere s = (Sphere) starting.get(j)[0];
                        int side = (int) starting.get(j)[1];
//                        System.out.println("Starting: time = "+t+" side = "+side+" node = "+s);
                        PriorityQueue<Sphere> q = new PriorityQueue<>();
                        q.offer(s);
                        HashSet<Integer> visited = new HashSet<>();
                        while (!q.isEmpty()) {
                            if(minTimes[i] < t) continue;
                            Sphere a = q.poll();
                            for (Sphere b : spheres) {
                                if (visited.contains(b.name)) {
                                    continue;
                                }
                                if (a.getRadius(t) + b.getRadius(t) >= map.get(a.name)[b.name]) {
//                                    System.out.println(a+" "+b+" "+map.get(a.name)[b.name]+" <= "+(a.getRadius(t)+b.getRadius(t)));
                                    visited.add(b.name);
                                    q.offer(b);
                                    if(b.intersectsWall(i,t, xSize, ySize,zSize).contains(-side)){
                                        minTimes[i]=Math.min(minTimes[i], t);
//                                        System.out.println("Original wall: "+side);
//                                        System.out.println("intersected on axis: "+i+" -> "+a+" - "+b);
//                                        System.out.println("Walls intersected: "+b.intersectsWall(i,t, xSize, ySize,zSize));
                                        break;
                                    }
                                }
                            }
                        }

//                        System.out.println("Nodes Visited: "+visited);
                    }
                    t++;
                }
//                System.out.println("Min Times: "+Arrays.toString(minTimes));
//                System.out.println("----------------");

            }
//            System.out.println(Arrays.toString(minTimes));
            System.out.println(Math.max(minTimes[0], Math.max(minTimes[1], minTimes[2])));

        }
        f.close();
    }
    public static class Sphere implements Comparable<Sphere>{
        public int name;
        public double x;
        public double y;
        public double z;
        public double rate;
        public double ri;
        public Sphere(int name, double x, double y, double z, double ri , double rate){
            this.name = name;
            this.x=x;
            this.y=y;
            this.z=z;
            this.rate=rate;
            this.ri=ri;
        }
        public String toString(){
            return String.format("name: %d (%.2f, %.2f, %.2f) : %.2f, %.2f",name, x, y, z, ri, rate);
        }
        public int compareTo(Sphere other){
            return (int) dist(other);
        }
        public double dist(Sphere s){
            return Math.sqrt(Math.pow(x-s.x, 2)+Math.pow(y-s.y, 2)+Math.pow(z-s.z, 2));
        }
        public double getRadius(int t){
            return ri + rate*t;
        }
        public ArrayList<Integer> intersectsWall(int direciton, int t, double xSize, double ySize, double zSize){
            double r = this.ri + (this.rate*t);
            ArrayList<Integer> out = new ArrayList<>();
            if(direciton == 0){ //x axis: y=0
                if(this.x-r<=0)
                    out.add( -1);
                if(this.x+r>=xSize)
                    out.add(1);
                return out;
            }
            else if(direciton == 1){
                if(this.y-r<=0)
                    out.add(-2);
                if(this.y+r>=ySize)
                    out.add(2);
                return out;
            }
            else if(direciton == 2){
                if (this.z - r <= 0)
                    out.add(-3);
                if (this.z + r >= zSize)
                    out.add(3);
                return out;
            }
            return null;
        }
        public int hashCode(){
            return Objects.hash(name, x, y, z, rate, ri);
        }


    }



    
    
    public static void main(String[] args) throws FileNotFoundException{
        new greatEscape().run();
    }
}
