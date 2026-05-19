public class CloseableStuff {
    static class R implements AutoCloseable {
        String name;

        public R(String n) {
            name = n;
            System.out.println("+" + name);
        }

        public void close() {
            System.out.println("-" + name);
        }
    }

    public static void main(String[] args) {
        try (R a = new R("A"); R b = new R("B")) {
            System.out.println("X");
        }

        int a = Integer.MAX_VALUE;
        System.out.println(Math.incrementExact(a));
    }
}
