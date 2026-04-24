import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.HashMap;

public class Sciel {

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
    }
}

class Board implements Serializable {
    private static final long serialVersionUID = 1L;

    protected HashMap<String, HashMap<String, EdgeCost>> graph;

    @Override
    public String toString() {
        // TODO: Implement
    }
}

class Hand implements Serializable {
    private static final long serialVersionUID = 1L;

    protected HashMap<Color, Integer> cards;

    @Override
    public String toString() {
        // TODO: Implement
    }
}

class Testcase implements Serializable {
    private static final long serialVersionUID = 1L;

    protected Board board;
    protected Hand hand;
    protected Route route;

    public String solve() {
        // TODO: Implement
    }

    @Override
    public String toString() {
        // TODO: Implement
    }
}
