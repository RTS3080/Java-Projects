import java.awt.event.KeyEvent;
import java.io.*;
import java.util.*;
import java.util.function.BiFunction;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.lang.System.out;


public class BS {
    public static void main(String[] args) throws FileNotFoundException {
//        double a = 2.2;
//        System.out.println(a / 2);
//        byte b = 120;
//        b += 7;
//        System.out.println(Byte.SIZE);
//        System.out.println(b);
//
//        int m = 13, n = 5, o = 9;
//        if (m++ < n + o && o * 2 >= m + n--)
//            o += 3;
//        else
//            n -= 4;
//        System.out.println(m + " " + n + " " + o);
//        String a="777177";
//        System.out.println(a.replaceAll("7*","0"));
//        String z="7771";
//        System.out.println(Arrays.toString(z.split("7")));
//        String[] z=a.split("\\S*");
//        System.out.println(Arrays.toString(z));
//        String b=a.replaceAll("\\S*","0");
//        System.out.println(b);
//        for (int i = 1; i < a.length(); i++) {
//            String q=a.substring(0,i+1);
//            if(q.replaceAll("\\S*","0").equals("00")){
//                System.out.println(i+" "+q);
//            }
//        }
//        System.out.println("one".matches("\\S*"));
//        byte x= (byte) 70000;
//        System.out.println(x);
//        Short uil='a';
//        System.out.println(uil);
//        ArrayList<Byte> al=new ArrayList<>();
//        al.add('a');
//        System.out.println(18>>>33);
//        int k=5;
//        for ( int p = 2; p <= k; p++ )
//            for ( int r = 1; r < k; r++ )
//                System.out.println( "Hello" );
//        int[] nums = {1, 2, 3, 4, 5};
//        int value = 6;
//
//        changeIt(nums, value);
//
//        for (int k = 0; k < nums.length; k++)
//
//            System.out.print(nums[k] + " ");
//
//
//        System.out.print(value);
//    }
//    public static void changeIt( int[] list, int num )
//    {
//
//        list = new int[5];
//        num = 0;
//
//        for( int x = 0; x < list.length; x++ )
//
//            list[ x ] = 0;
//
//        String a = "hello";
//        String b = "world";
//        System.out.printf("%2$q %1$q",a,b);
//        byte bytes[] = new byte[5];
//        for (int i = 127; i < 132; i++) {
//            bytes[i - 127] = (byte)i;
//        }
//        String str = new String(bytes);
//        for (int i = 0; i < 5; i++) {
//            System.out.print((int)str.charAt(i)+" ");
//        }
//        String reg = "(\\w+) (\\d+) (\\1) (\\2)";
//        String test = "sup 23 sup 23";
//        System.out.println(test.matches(reg));
//        char A = 'A';
//        int B = 0;
//        System.out.println(true ? A : B);
//        System.out.println(false ? B : A);
//
//        Map<String, String> m = new TreeMap<>();
//        m.put("bob", "Geo");
//        m.put("Alan", "Art");
//        m.remove("bob", "Art");
//        m.remove("bob");
//
//        Set<String> q = m.keySet();
//        for(String str : q)
//        System.out.print(str+" "+m.get(str)+" : ");

//        Boolean b = false;
//
//        int n = 65;
//        char c = 'B';
//        System.out.println(b ?n : c);
//
//        System.out.println((Integer) 1222 ==((Integer)1222)); // false - outside byte range
//        System.out.println((Integer) 127 ==((Integer)127)); // true - inside byte range
//        System.out.println(127 ==((Integer)127));// true
//
//        System.out.println((char) 1 << 18 == 1 << 18); //true
//        System.out.println(((Character) ((char) 1)) << 18 == (char) 1 << 18); //true
//        int a = 5;
//
//        if((a+=2)>3){
//            System.out.println("hello");
//        }
//        byte b = (byte)128;
//        System.out.println(Integer.toBinaryString(128));
//        System.out.println(Integer.toBinaryString(b));
//        Double[] d = {5e80};
//        System.out.println(5e26);
//
//        System.out.println(En.MERC.toString().equals("ENUM"));
//        System.out.println(En.MERC);
//    }
//
//    enum En {
//        MERC (1, 2),
//        VENU (2, 3);
//        int x, y;
//
//        En(int i, int j) {
//            this.x = i;
//            this.y = j;
//        }
//
//        @Override
//        public String toString() {
//            return 1 + " " + 2;
//        }
//    }
//        List<Integer> a = new LinkedList<>();
//        double d = 47.00000000000004;
//        double e = 47.00000000000009;
//        while(d<e) {
//            System.out.println(d=Math.nextAfter(d, e));
//        }
//
//        abstract class a{
//            int go(){return 1;}
//        }
//        class b extends a{
//            int i;
//            int go(){return i;}
//            public b(int i){
//                this.i = i;
//            }
//        }
//        b hi = new b(0);
//        System.out.println(hi.go());
//
//        abstract class A{
//            static int go(){
//                return 2;
//            }
//            int hi(){
//                return 3;
//            }
//        }
//
//        class B{
//           public B(){
//           }
//           int go(){
//               return 4;
//           }
//        }
//        B A = new B();
//        System.out.println(A.go());
//        Math.decrementExact()
//        Scanner sc = new Scanner("1 2 3 4 5 6 16");
//        sc.radix()
//        sc.useRadix(7);
//        while(sc.hasNext()){
//            System.out.print(sc.nextInt()+" ");
//        }
//        System.out.println();
//        sc.reset();
//        while(sc.hasNext()){
//            System.out.print(sc.nextInt()+" ");
//        }
//        System.out.println();
//        int a = -8;
//        int b = 3;
//        System.out.println(a%b);
//        System.out.println(Math.floorMod(a,b));
//        System.out.println("-".repeat(5));
//        System.out.println(a/b);
//        System.out.println(Math.ceilDiv(a,b));
//        System.out.println(-1 >> 2);
//        System.out.println(-1 >>> 2);

//        char c = (char)(1<<16);
//        System.out.println(Character.MAX_VALUE+0);
//        System.out.println(Math.pow(2,16));
//        System.out.println(c+0);
//        System.out.println(c == Character.MAX_VALUE);
//        System.out.println(c+1);
//
//        char ch=11;
//        char chs = 3;
//        System.out.println(ch | chs);
//        String q = "14 95 194810 86 9720 29 87 193 28 30 574";
//        String x = "([0-3])";
//        String[] r= q.split(x);
//        Scanner sc = new Scanner(q);
//        sc.useDelimiter(x);
//        System.out.println(r.length);
//        int n =0;
//        while(sc.hasNext() && sc.next().length()<=5){
//            n++;
//        }
//        System.out.println(n);
//        int c = 10;
//        for(c = 20; c< 30; c++){
//            c+=2.5;
//        }
//        System.out.println(c);
//        System.out.println(r(0,0));
//        for (int i = 0; i < 2; i++) {
//            for (int j = 0; j < 2; j++) {
//                for (int k = 0; k < 2; k++) {
//                    boolean a = i==0;
//                    boolean b = j==0;
//                    boolean c = k==0;
//                    System.out.println((!a&&b&&c)+" "+((a^c)&&b));
//                }
//            }
//        }
//        double nan = Double.NEGATIVE_INFINITY;
//        System.out.println((int)nan);
//        System.out.println(0/Double.NEGATIVE_INFINITY);

//        String[] str = "xx".split("");
//        System.out.println(str[0] == "x");
//        String q = "x";
//        System.out.println(q+str[0]=="xx");
//        String x = "str";
//        x += "hello";
//        System.out.println("we getting a 5");
//        q = "BETH BENNET";
//        System.out.println(q.replace('E', 'K'));
//        System.out.println(Math.ceil(-3.5));
//        double d = 10;
//        float f = 6.1f;
//        System.out.println(d-f);
//        String q = "\\d+\\w+[@#$%^]\\d+";
//        String p = "123Hello#67";
//        System.out.println(p.matches(q));
//
//        System.out.println(Long.MAX_VALUE/(1000*1000));
//        System.out.println(Long.MAX_VALUE);
//        char c = 'a';
//        c*=.75;
//        System.out.println(c);
//        String r = "0|(00+)\\1+";
//        for (int i = 1; i <= 100; i++) {
//            String f= String.format(("%0"+i+"d"), 0);
//            if(!f.matches(r)) {
//                System.out.println(f+" "+i);
//            }
//        }
//        char c = 'x';
//        char a = 'n';
//        System.out.println(Character.compare(a,c));
//        int k = 65108;
//        String st = "";
//        while(k>0){
//            switch (k%5){
//                case 1: st+='N'; break;
//                case 2: st+='S'; break;
//                case 3: st+='E'; break;
//                case 4: st+='W'; break;
//                default: st+=' '; break;
//            }
//            k/=10;
//        }
//        System.out.println(st);
//        ArrayList<String> list = new ArrayList<>();
//        list.add("AKANE");
//        list.add("NO");
//        list.add("MAI");
//        list.add("AKIRA");
//        list.add("PANI");
//        list.add("PONI");
//        for (int k = 0; k < list.size()-1; k++) {
//            for (int j = k+1; j < list.size(); j++) {
//                String x = list.get(k).substring(1);
//                String y = list.get(k+1).substring(1);
//                if(x.compareTo(y) >0) {
//                    x = list.get(k);
//                    list.set(k, list.get(k+1));
//                    list.set(k+1, x);
//                }
//            }
//        }
//        System.out.println(list);
//        String q = "1";
//        System.out.println(q.substring(1));
//        Stack<String>a = new Stack<>();
//        Stack<String>b = new Stack<>();
//        Stack<String>c = new Stack<>();
//        String x = "HELLOMYFRIENDHELLO";
//        System.out.println(x.length());
//        for (int i = 0; i < x.length()-3; i+=3) {
//            a.push(x.substring(i, i+1));
//            b.push(x.substring(i+1, i+2));
//            c.push(x.substring(i+2, i+3));
//            System.out.println(i);
//        }
//        System.out.println(a);
//        System.out.println(b);
//        System.out.println(c);
//        System.out.printf("%a\n", 45.3);
//        System.out.printf("%a\n",45.0);
//        System.out.printf("%x\n",45);

//        double jade = 4.5;
//        double joseph = 3.5;
//        double carden = Math.hypot(jade, joseph);
//        char thanh = 5;
//        System.out.println(carden > thanh ? thanh : carden);
//
        String arm = "7 lAkes are_bum$";
        String strong = "212 rules the_universe!";
        String stroud = "\\d+ \\w[aeiou]\\w{3,5} \\w+\\p{Punct}";
//        String stroud = "\\d{1,3} \\w+[aeiou]";
//        stroud += "\\w{2,5} [\\w\\q]+\\p{Punct}+";

        System.out.print(arm.matches(stroud) + " ");
        System.out.println(strong.matches(stroud));
//
//        char a = 'X';
//        int b = 88;
//
//        if (a == b) {
//            out.println("True");
//        }else{
//            out.println("False");
//        }
//        String d = "jz-num4324:212fdua0-fslnum432:"
//                + "142fja423:731fak_num42:243dfs";
//        Pattern p =
//                Pattern.compile(
//                        "\\d+:(\\d+)");
//        Matcher m = p.matcher(d);
//        int x = 0;
//        while (m.find()) {
//            x += Integer.parseInt(m.group(1));
//        } out.println(x);
//        String yufeng = "";
//
//        for (int j=(int)Math.pow(2,3); j>0; j-=3){
//            yufeng += "Order 66!";
//            out.println(j);
//        }
//        out.println(yufeng.length());
//
//        String str = "abcwabcabcwww";
//        Object[] arr = str.split("w", 212);
//        out.println(Arrays.toString(arr));
//
//        for (int i = 0; i < 100; i+=2) {
//            for (int j = 0; j < 100; j+=3) {
//                int c = i << (-j);
//                int fix = (-j%32)+32;
//                if(c != i<<fix) out.println(i+" "+j+" "+c+" "+fix);
//            }
//        }


//
//        int sum = 0;
//        int n = 10;
//        for (int i = 0; i < 212; i++) {
//            for (int j = 0; j < n; j++) {
//                sum += j;
//            }
//        }
//        System.out.println(sum);
//
//        char a = 'X';
//        int b = 89;
//
//        if (a == b) {
//            System.out.println("True");
//        } else {
//            System.out.println("False");
//        }
//
//
//        System.out.println(5 << -29);
//
//        String yufeng = "";
//        System.out.println("hello");
//        for (int i = 1; i < 4; i++) {
//            for (int j = (int) Math.pow(i, 3); j >= i - 1; j -= 3) {
//                yufeng += "Order 66!";
//            }
////            System.out.println(yufeng.length());
//        }
//
//        System.out.println(yufeng.length());
//
//        for (int i = 0; i < 10; i++) {
//            System.out.println((int) (Math.random() * 5) + " " + (int) (Math.random() * 5) + " " + (int) (Math.random() * 20));
//        }
//        ArrayList<Integer> test;
//        test = new ArrayList<>();
//
//        test.add(5);
//        test.add(5);
//        test.add(1000);
//        test.add(1000);
//        out.print((test.get(0) == test.get(1))
//                +" ");
//        out.println(test.get(2) == test.get(3));
//
//        LinkedList<Object> list = new LinkedList<Object>();
//        list.add("ABCDE");
//        list.offer(459);
//        list.add(290.18);
//        list.offer('F');
//        list.poll();
//        list.offer(null);
//        list.remove(2);
//        out.println(list.get(2));
//        // \\p{Punct} = ![#$%&'()*+,-./:;<@=?>[\]^_`{|}~z
//
//
//        BiFunction<Integer, Integer, Integer> f =
//                (a, b) -> (a + b) * (b - a + 1) / 2;
//
//        out.print(f.apply(1, 100));
//        out.println(" " + f.apply(-50, 80));


//        LinkedList<Object> q;
//        q = new LinkedList<>();
//        q.add("hello");
//        q.add(3);
//        q.push(6);
//        q.add(q);
//        q.poll();
//        q.offer(new ArrayList<>().add("wars"));
//        q.push("there");
//        q.offer("stem");
//        out.print(q.remove()+" ");
//        out.println(q.poll());
//        out.println(q);


//        String str = "abcWabcabcWWW";
//        Object[] arr = str.split("W", 212);
//        out.println(Arrays.toString(arr));
//        out.println(Integer.MIN_VALUE
//                + ~Integer.MAX_VALUE);
//        String yufeng = "";
//
//        for (int j=(int)Math.pow(2,3); j>=0; j-=3){
//            yufeng += "Order 66!";
//        }
//        out.println(yufeng.length());
//
//        String str = "whattheheck";
//
//
//        int result = 0;
//        for (int i=0; i<str.length(); i++){
//            char each = str.charAt(i);
//            int temp = each * (int) Math.pow(31, str.length()-i-1);
//            result += temp;
//        }
//        final int SIZE = 10;
//        out.println(result%SIZE);
        //        Scanner in = new Scanner(System.in);
//        int cases = in.nextInt(); in.nextLine();
//
//        TreeMap<String, Integer> a = new TreeMap<>();
//        //       key     value
//
//        for (int i = 0; i < cases; i++) {
//            String line = in.nextLine();
//
//            if(!a.containsKey(line)) {
//                a.put(line, 1);
//            }
//            else{
//                a.put(line, a.get(line) + 1);
//            }
//
//            a.putIfAbsent(line, 0);
//            a.put(line, a.get(line) + 1);

        // logic to add (put) to the treemap
//        }

//        for (String s : a.keySet()){
//            System.out.println(s + " " + a.get(s));
//        }

//        String s = " 1957 - Sputnik Launched";
//        String r = "(?<w>\\b\\D+\\b)|(?<SE>\\d+.?\\d*)";
//        Pattern p = Pattern.compile(r);
//        Matcher m = p.matcher(s);
//        if(m.find()){
//            System.out.println(m.group("w"));
//        }
//        else System.out.println("No matches");
////        System.out.println(m.toString());
//        String str = m+"";
////        System.out.println(str);
//        System.out.println(m.toString().equals(str));
////        System.out.println(m.toString().matches(str));


//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        String s = "-8 -6 -6 30 60 700 10";
//        int[] ints = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
//        for(int i : ints){
//            pq.add(i);
//        }
//        System.out.println(pq);
//
//        System.out.println(pq.remove());
//        System.out.println(pq);


//        System.out.printf("%s%n", "AFflkdsjkl");
//        System.out.printf("%S%n", "AFDSFfdskJFKjkfd");
//        System.out.printf("% .3f%n", 5.8995);
//        System.out.printf("%3.3f%n", 5.8995);
//        System.out.println("55slkfjsd5".matches(""));
//
//        var b = 129;
//        Integer c = 129;
//        System.out.println(c == b);

//        double dub = -0/0.;
//        int num = (int) (1./0.);
//        System.out.println(num);
//        System.out.println(dub+" "+(dub+1));
//        System.out.println(dub != dub + 1);

//        ArrayList<Comparable> array = new ArrayList<Comparable>();
//        array.add(5);
//        array.add(5.3);

//        List<Short> shts = Arrays.asList(new Short[]{1, 2, 3, 4, 5});
//        List<Short> ints = new ArrayList<>();
//        shts.stream().filter(x->x%2 == 0).forEach(ints :: add);
//        System.out.println(ints);
//        String s = "analysis of algorithms";
//        String[] a = s.split("a");
//        System.out.println(Arrays.toString(a));
//        TreeMap<Integer, Integer> map = new TreeMap<>();
//        map.put(37, 72);
//        map.put(40, 45);
//        map.put(93, 63);
//        map.put(66, 19);
//        for(Integer k : map.keySet()) {
//            map.put(map.get(k), k);
//        }
//        System.out.println(map);
//        Deque<Integer> q = new LinkedList<>();
//        for (int i = 0; i < 10; i++) {
//            q.push(i);
//        }
//        System.out.println(q);
//        q.pop();
//        q.pop();
//        System.out.println(q);
//        q.poll();
//        System.out.println(q);
//        System.out.println(q.peek());
//        int x = 0;
//        System.out.println();

//        String str = "Strings";
//        str = str.substring(3);
//        str += str.charAt(2);
//        str +=str.substring(5);
//        System.out.println(str);
//    }
//    public static void use(ArrayList<?> list){
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//        }
//    }
    }

}


    interface Jedi {
        void force();
    }

    class ObiWan implements Jedi {
        public void force() {
            out.println("Hello there");
        }
    }

    class Anakin implements Jedi {
        public void force() {
            out.println("I never liked sand");
        }
    }

    abstract class Temple {
        public abstract Jedi trainJedi();
    }
    class ObiWanThing extends Temple {
        public Jedi trainJedi() {
            return new ObiWan();
        }
    }
    class AnakinThing extends Temple {
        public Jedi trainJedi() {
            return new Anakin();
        }
    }

    //client code
