import java.util.*;

class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] e : edges) {
            List<Integer> l = g.getOrDefault(e[0], new ArrayList<>());
            l.add(e[1]);
            g.put(e[0], l);
            l = g.getOrDefault(e[1], new ArrayList<>());
            l.add(e[0]);
            g.put(e[1], l);
        }
        int n = g.size();
        int[] vis = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!ts(g, vis, i, 0, new int[] { 0, 0 })) {
                break;
            }
        }
        //System.out.println(Arrays.toString(vis));
        // System.out.println(g);
        for (int i = edges.length - 1; i >= 0; i--) {
            if (vis[edges[i][0]] == 1 && vis[edges[i][1]] == 1) {
                boolean noCycle = true;
                int[] vis1 = new int[n + 1];
                for (int j = 1; j <= n; j++) {
                    if (!ts(g, vis1, j, 0, edges[i])) {
                        noCycle = false;
                        break;
                    }
                    
                }
                if(noCycle) {
                    return edges[i];
                }

            }
        }
        return null;
    }

    boolean ts(Map<Integer, List<Integer>> g, int[] vis, int i, int prev, int[] removed) {
        if (vis[i] == 2) {
            return true;
        }
        if (vis[i] == 1) {
            return false;
        }
        vis[i] = 1;

        List<Integer> nei = g.get(i);
        for (int ne : nei) {
            if ((i == removed[0] && ne == removed[1]) || ((i == removed[1] && ne == removed[0]))) {
                continue;
            }
            if (ne != prev) {
                if (!ts(g, vis, ne, i, removed)) {
                    return false;
                }
            }
        }

        vis[i] = 2;
        return true;

    }
}