import java.util.Arrays;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        UnionFind uf = new UnionFind(edges.length);
        int indexOfLatestRedundantEdge = -1;
        for (int i = 0; i < edges.length; i++) {
            if (!uf.unify(edges[i][0] - 1, edges[i][1] - 1)) {
                indexOfLatestRedundantEdge = i;
            }
        }

        return edges[indexOfLatestRedundantEdge];
    }


}

class UnionFind {
    int edges;
    int[] parent;
    int[] sizes;
    int numberOfElements;

    public UnionFind(int edges) {
        this.edges = edges;
        parent = new int[edges];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        sizes = new int[edges];
        Arrays.fill(sizes, 1);
        numberOfElements = edges;

    }

    public int getNumberOfElements() {
        return numberOfElements;
    }

    public boolean isConnected(int node1, int node2) {
        return find(node1) == find(node2);
    }

    public int find(int p) {

        int root = p;
        while (root != parent[root]) root = parent[root];

        while (p != root) {
            int next = parent[p];
            parent[p] = root;
            p = next;
        }

        return root;
    }

    public boolean unify(int node1, int node2) {
        if (isConnected(node1, node2)) {
            return false;
        }

        int parent1 = find(node1);
        int parent2 = find(node2);

        if (sizes[parent1] < sizes[parent2]) {
            sizes[parent2] += sizes[parent2];
            parent[parent1] = parent2;
            sizes[parent1] = 0;
        } else {
            sizes[parent1] += sizes[parent2];
            parent[parent2] = parent1;
            sizes[parent2] = 0;
        }
        numberOfElements--;
        return true;
    }

}
