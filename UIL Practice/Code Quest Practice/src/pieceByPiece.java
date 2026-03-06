import java.util.*;
import java.io.*;


public class pieceByPiece {
    enum Directions{
        Top,
        Right,
        Bottom,
        Left;
    }
    class chunk{

        char id;
        int numBorders;
        //top, right, bottom, left
        Integer[] edges;
        chunk[] connections;
        public chunk(char id, Integer[] edges){
            this.id=id;
            this.edges=edges;
            connections = new chunk[4];
        }


        void setBorderCount(HashMap<Integer, Integer> counts){
            for (int i = 0; i < 4; i++) {
                int edge = edges[i];
                if(counts.get(edge) == 1){
                    numBorders++;
                    edges[i] = -1;
                }
            }
        }


        public String toString(){
            return id+"";
        }
    }
    static void rotate(Object[] arr, int rotationAmount){
        ArrayList<Object> copy = new ArrayList<>(Arrays.asList(arr));
        Collections.rotate(copy, rotationAmount);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = copy.get(i);
        }
    }


    HashMap<Integer, Integer> counts;
    public void run()throws Exception
    {
//        Scanner f = new Scanner(new File("1".toLowerCase()+".in"));
        Scanner f = new Scanner(System.in);
        int times=f.nextInt(); f.nextLine();
        while(times-->0){
            counts = new HashMap<>();
            int r = f.nextInt();
            int c = f.nextInt();
            char reference = f.next().charAt(0);
            int startIndex = -1;
            chunk[] chunks = new chunk[r * c];
            for (int i = 0; i < r * c; i++) {
                char id = f.next().charAt(0);
                Integer[] edges = new Integer[4];
                for (int j = 0; j < 4; j++) {
                    edges[j] = f.nextInt();
                    counts.put(edges[j], counts.getOrDefault(edges[j], 0) + 1);
                }
                if(id == reference){
                    startIndex = i;
                }
                chunks[i] = new chunk(id, edges);
            }
            for(chunk ch : chunks){
                ch.setBorderCount(counts);
            }
            chunk[] cornerChunks = new chunk[4];
            int cnt = 0;
            for(chunk ch : chunks){
                if(ch.numBorders == 2){
                    cornerChunks[cnt++] = ch;
                }
            }
            chunk start = chunks[startIndex];
            Queue<Object> q = new LinkedList<>();
            q.offer(start);
            q.offer(start+"");
            while(!q.isEmpty()){
                chunk curr = (chunk) q.poll();
                String vis = (String) q.poll();
                for(chunk ch : chunks){
                    if(vis.contains(ch.id+"")) continue;
                    for (int i = 0; i < 4; i++) {
                        for (int j = 0; j < 4; j++) {
                            if(curr.edges[i].equals(ch.edges[j]) && curr.edges[i] != -1){
                                curr.connections[i] = ch;
                                ch.connections[j] = curr;
                                rotate(ch.edges, i - j + 2);
                                rotate(ch.connections, i - j + 2);
                                q.offer(ch);
                                q.offer(vis+ch.id);
                            }
                        }
                    }
                }
            }

            chunk curr = chunks[0];
            while (curr.edges[3] != -1) {
                if (curr.connections[3] == null) throw new RuntimeException("Missing left connection at " + curr.id);
                curr = curr.connections[3];
            }
            while(curr.edges[0] != -1){
                curr = curr.connections[0];
            }


            char[][] out = new char[r][c];
            int i = 0;
            int j = 0;
            while(curr!=null && i < r) {
                chunk copy = curr;
                while (copy!=null && j < c) {
                    out[i][j++] = copy.id;
//                    System.out.print(copy.id);
                    copy = copy.connections[1];
                }
//                System.out.println();
                i++; j = 0;
                curr = curr.connections[2];
            }


            for(char[] row : out){
                System.out.println(row);
            }


        }
        f.close();
    }


    public static void main(String[] args)throws Exception
    {
        new pieceByPiece().run();
    }
}
