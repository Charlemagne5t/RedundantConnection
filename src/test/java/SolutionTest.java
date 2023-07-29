import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class SolutionTest {
    @Test
    public void findRedundantConnectionTest1() {
        int[][] edges = {{1, 2}, {1, 3}, {2, 3}};
        int[] expected = {2, 3};
        int[] actual = new Solution().findRedundantConnection(edges);
        boolean result = Arrays.equals(expected, actual);

        Assert.assertTrue(result);
    }

    @Test
    public void findRedundantConnectionTest2() {
        int[][] edges = {{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}};
        int[] expected = {1, 4};
        int[] actual = new Solution().findRedundantConnection(edges);
        boolean result = Arrays.equals(expected, actual);

        Assert.assertTrue(result);
    }

    @Test
    public void findRedundantConnectionTest3() {
        int[][] edges = {{1, 5}, {3, 4}, {3, 5}, {4, 5}, {2, 4}};
        int[] expected = {1, 4};
        int[] actual = new Solution().findRedundantConnection(edges);
        boolean result = Arrays.equals(expected, actual);

        Assert.assertTrue(result);
    }
}
