public class ChatFenwickTree {

    public int[] tree;
    private int n;

    // Build in O(n)
    public ChatFenwickTree(int[] arr) {
        n = arr.length;
        tree = new int[n + 1]; // 1-indexed

        // Copy values into tree
        for (int i = 1; i <= n; i++) {
            tree[i] += arr[i - 1];
            int parent = i + (i & -i);
            if (parent <= n) {
                tree[parent] += tree[i];
            }
        }
    }

    // Add delta to index i (1-indexed)
    public void update(int i, int delta) {
        while (i <= n) {
            tree[i] += delta;
            i += i & -i;
        }
    }

    // Prefix sum from 1 to i
    public int prefixSum(int i) {
        int sum = 0;
        while (i > 0) {
            sum += tree[i];
            i -= i & -i;
        }
        return sum;
    }

    // Range sum from l to r
    public int prefixRange(int r, int l) {
        return prefixSum(l) - prefixSum(r - 1);
    }
}