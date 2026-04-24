public class ackermann {
    static long ackermann(long n, long m){
        if(n == 0) return m+1;
        if(m == 0) return ackermann(n-1, 1);
        return ackermann(n-1, ackermann(n, m-1));
    }

    public static void main(String[] args) {
        System.out.println(ackermann(5, 0));
    }
}
//(A!B + C)^(A + !D)*C
