import java.util.*;
import java.io.*;
import java.awt.*;

import static java.lang.Math.*;


public class fenwickTree {
    public int[] tree;
    public int n;
    public int[] parents;

    public fenwickTree(int[] vals) {
        n = vals.length;
        parents = new int[n+1];
        tree = new int[n+1];

        for (int i = 1; i < vals.length+1; i++) {
            tree[i] += vals[i-1];
            int parent = i + (i & -i);
            parents[i] = parent;
            if(parent <= n){
                tree[parent] += tree[i];
            }
        }

    }

    public void update(int i, int change){
        while(i<=n){
            tree[i] += change;
            i += i & -i;
        }
    }

    public int prefixSum(int i){
        int sum = 0;
        while(i>0){
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }

    public int prefixRange(int a, int b){
        return prefixSum(b) - prefixSum(a-1);
    }

}

