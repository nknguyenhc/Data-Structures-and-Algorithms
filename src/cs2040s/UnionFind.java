package cs2040s;
import java.util.ArrayList;

/**
 * This class implements the algorithm to find and union.
 * Objects are not managed by this class, they must be managed externally.
 * This class only handles the operations through indices.
 * Attach each element to an index, and this class handles the find and union of indices.
 * Initially, all elements are in their own disjoint sets.
 */
public class UnionFind {
    private int[] parent;
    private int[] size;

    public UnionFind(int capacity) {
        this.parent = new int[capacity];
        this.size = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            this.parent[i] = i;
            this.size[i] = 1;
        }
    }

    private int findRoot(int elem) {
        ArrayList<Integer> path = new ArrayList<>();
        int root = elem;
        while (root != this.parent[root]) {
            path.add(root);
            root = this.parent[root];
        }
        for (int i = 0; i < path.size(); i++) {
            this.parent[path.get(i)] = root;
        }
        return root;
    }

    public boolean find(int elem1, int elem2) {
        if (elem1 < 0 | elem1 >= this.parent.length | elem2 < 0 | elem2 >= this.parent.length) {
            throw new IllegalArgumentException("Input(s) not within size");
        }

        return this.findRoot(elem1) == this.findRoot(elem2);
    }

    public void union(int elem1, int elem2) {
        if (elem1 < 0 | elem1 >= this.parent.length | elem2 < 0 | elem2 >= this.parent.length) {
            throw new IllegalArgumentException("Input(s) not within size");
        }

        int root1 = this.findRoot(elem1);
        int root2 = this.findRoot(elem2);
        if (root1 == root2) {
            return;
        }

        if (this.size[root1] < this.size[root2]) {
            this.parent[root1] = root2;
            this.size[root2] += this.size[root1];
        } else {
            this.parent[root2] = root1;
            this.size[root1] += this.size[root2];
        }
    }
}
