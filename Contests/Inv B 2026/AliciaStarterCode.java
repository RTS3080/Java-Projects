import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;

public class Alicia {
    
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

enum Directedness {
    Undirected, Directed;
}

enum Cyclicity {
    Cyclic, Acyclic;
}

enum Connectedness {
    Connected, Disconnected, Weakly_Connected, Strongly_Connected, Unilaterally_Connected;
}

class Graph implements Serializable {
    public static final long serialVersionUID = 1L;

    private HashMap<Integer, HashSet<Integer>> g;
    private int n, m;

    public Graph(HashMap<Integer, HashSet<Integer>> g, int n, int m) {
        this.g = g;
        this.n = n;
        this.m = m;
    }

    private Directedness directedness;

    public Directedness getDirectedness() {
        // TODO: Implement
    }

    private Cyclicity cyclicity;

    public Cyclicity getCyclicity() {
        // TODO: Implement
    }

    protected Connectedness connectedness;

    @Override
    public String toString() {
        // TODO: Implement
    }
}