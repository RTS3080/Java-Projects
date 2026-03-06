import java.util.*;
import java.io.*;
import java.awt.*;
import java.util.List;

class videos{
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        HashMap<Integer, List<String>> friendsById = new HashMap<>();
        HashMap<Integer, List<Integer>> friendsByLevel = new HashMap<>();
        boolean[][] adj = new boolean[friends.length][friends.length];
        int[][] shadow = new int[friends.length][friends.length];
        for (int i = 0; i < friends.length; i++) {
            int[] f = friends[i];
            Arrays.fill(shadow[i], Integer.MAX_VALUE);
            for(int a : f){
                adj[i][a] = true;
            }
        }
        Queue<node> q = new LinkedList<>();
        q.add(new node(id, level));
        while(!q.isEmpty()){
            node cur = q.poll();
            int r = cur.r;
            int moves = cur.moves;
            if(moves>level){
                continue;
            }
            for(int i = 0; i < adj[r].length; i++){
                if(shadow[r][i] >moves){
                    continue;
                }
                if(adj[r][i]){
                    friendsByLevel.putIfAbsent(r,new ArrayList<>());
                    friendsByLevel.get(r).add(i);
                    q.add(new node(i, moves+1));
                }
                shadow[r][i] = moves;
            }
        }
        System.out.println(friendsByLevel);
        ArrayList<String> result = new ArrayList<>();
        for(Integer ints : friendsByLevel.get(level)){

        }
        return result;
    }
    class node{
        int r;
        int moves;
        public node(int r,  int moves) {
            this.r = r;
            this.moves = moves;
        }
    }


}
class main {
    public static void main(String[] args) {
        List<List<String>> watchedVideos = new ArrayList<>(Arrays.asList(Arrays.asList("A", "B"), Arrays.asList("C"), Arrays.asList("B", "C"), Arrays.asList("D")));
        String s = "[[1,2],[0,3],[0,3],[1,2]]";
        System.out.println(s.replaceAll("\\[","Arrays.asList("));
//        Arrays.asList(Arrays.asList("1","2"),Arrays.asList("0","3"),Arrays.asList(0,3],Arrays.asList(1,2]]

    }
}