import java.io.*;
import java.util.Arrays;
import java.util.Base64;
import java.util.Scanner;

public class Monoco {
    public void run() throws FileNotFoundException {
        Scanner f = new Scanner(new File("monoco.dat"));

        int numTimes=f.nextInt();f.nextLine();
        for(int times = 0; times < numTimes; times++){
            String byteStream = f.nextLine();

            Object o = null;

            try {
                o = Serializer.unmarshall(byteStream);
            } catch (Exception e) {
                e.printStackTrace();
            }

            BinTreeNode binTree = null;
            if (o instanceof BinTreeNode) {
                binTree = BinTreeNode.class.cast(o);
                System.out.println(binTree);
            } else {
                System.out.println("bad 2.0");
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        new Monoco().run();
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

class BinTreeNode implements Serializable {
    public static final long serialVersionUID = 1L;

    protected int value;
    protected BinTreeNode left, right;

    public BinTreeNode(int value) {
        this.value = value;
    }

    private int getLevels(BinTreeNode cur) {
        if (cur == null) return 0;
        int left = getLevels(cur.left);
        int right = getLevels(cur.right);
        return Math.max(left, right) + 1;
    }

    private void fill(BinTreeNode cur, Integer[] array, int idx) {
        if (cur == null) return;
        array[idx] = cur.value;
        fill(cur.left, array, 2 * idx + 1);
        fill(cur.right, array, 2 * idx + 2);
    }

    public Integer[] getArrayRepresentation() {
        // TODO: Implement
        int levels = getLevels(this);
        Integer[] array = new Integer[(1 << levels) - 1];
        fill(this, array, 0);
        return array;
    }

    @Override
    public String toString() {
        // TODO: Implement
        Integer[] array = getArrayRepresentation();
        return Arrays.toString(array).replaceAll("[\\[\\],]+", "").trim();
    }
}
