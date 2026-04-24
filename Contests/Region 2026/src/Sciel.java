import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Scanner;

public class Sciel {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner f = new Scanner(new File("sciel.dat"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String byteStream = f.nextLine();
            Object o = null;

            try {
                o = Serializer.unmarshall(byteStream);
            } catch (Exception e) {
                System.out.println("bad unmarshall");
            }

            Testcase tc = null;
            if (o instanceof Testcase) {
                tc = Testcase.class.cast(o);
            } else {
                System.out.println("bad cast");
                continue;
            }

            System.out.println(tc.solve());
        }
    }
}

class Serializer {
    public static String marshall(Serializable o) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(o);
        String encodedData = Base64.getEncoder().encodeToString(baos.toByteArray());
        baos.close();
        oos.close();
        return encodedData;
    }

    public static Object unmarshall(String s) throws ClassNotFoundException, IOException {
        byte[] data = Base64.getDecoder().decode(s);
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        ObjectInputStream ois = new ObjectInputStream(bais);
        Object o = ois.readObject();
        bais.close();
        ois.close();
        return o;
    }
}

class Route implements Serializable {
    private static final long serialVersionUID = 1L;

    protected String city1, city2;

    @Override
    public String toString() {
        // TODO: Implement
        return "";
    }
}

enum Color {
    RED, GREEN, BLUE, YELLOW, PINK
}

class EdgeCost implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Color color;
    protected int weight;

    @Override
    public String toString() {
        // TODO: Implement
        return "";
    }
}

class Board implements Serializable {
    private static final long serialVersionUID = 1L;

    protected HashMap<String, HashMap<String, EdgeCost>> graph;

    @Override
    public String toString() {
        // TODO: Implement
        return "";
    }
}

class Hand implements Serializable {
    private static final long serialVersionUID = 1L;

    protected HashMap<Color, Integer> cards;

    @Override
    public String toString() {
        // TODO: Implement
        return "";
    }
}

class Testcase implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Board board;
    protected Hand hand;
    protected Route route;

    private boolean dfs(String cur, String end) {
        if (cur.equals(end)) return true;

        boolean res = false;

        for (String next : board.graph.getOrDefault(cur, new HashMap<>()).keySet()) {
            EdgeCost edge = board.graph.get(cur).get(next);

            if (hand.cards.getOrDefault(edge.color, 0) >= edge.weight) {
                hand.cards.put(edge.color, hand.cards.get(edge.color) - edge.weight);
                res |= dfs(next, end);
                hand.cards.put(edge.color, hand.cards.get(edge.color) + edge.weight);
            }
        } return res;
    }

    public String solve() {
        // TODO: Implement

        if (dfs(route.city1, route.city2)) {
            return "Tomorrow comes";
        }

        return "When one falls, we continue";
    }

    @Override
    public String toString() {
        // TODO: Implement
        return "";
    }
}
