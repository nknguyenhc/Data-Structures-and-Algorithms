package problems;
import static org.junit.Assert.*;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class LazyPrizeCollectionTest {
    @Test
    public void lectureExample() {
        ArrayList<int[]> node0 = new ArrayList<>();
        Collections.addAll(node0, new int[] {1, -4});
        ArrayList<int[]> node1 = new ArrayList<>();
        Collections.addAll(node1, new int[] {5, 7});
        ArrayList<int[]> node2 = new ArrayList<>();
        Collections.addAll(node2, new int[] {0, -3}, new int[] {3, -10});
        ArrayList<int[]> node3 = new ArrayList<>();
        Collections.addAll(node3, new int[] {1, -11}, new int[] {6, -6});
        ArrayList<int[]> node4 = new ArrayList<>();
        Collections.addAll(node4, new int[] {3, 1}, new int[] {7, 1});
        ArrayList<int[]> node5 = new ArrayList<>();
        Collections.addAll(node5, new int[] {4, 2}, new int[] {7, -3});
        ArrayList<int[]> node6 = new ArrayList<>();
        Collections.addAll(node6, new int[] {2, 3});
        ArrayList<int[]> node7 = new ArrayList<>();
        Collections.addAll(node7, new int[] {6, -5});
        ArrayList<ArrayList<int[]>> map = new ArrayList<>();
        Collections.addAll(map, node0, node1, node2, node3, node4, node5, node6, node7);
        assertEquals(0, LazyPrizeCollection.solve(map, 0));
        assertEquals(7, LazyPrizeCollection.solve(map, 1));
        assertEquals(9, LazyPrizeCollection.solve(map, 2));
        assertEquals(10, LazyPrizeCollection.solve(map, 3));
        assertEquals(6, LazyPrizeCollection.solve(map, 4));
        assertEquals(8, LazyPrizeCollection.solve(map, 5));
        assertEquals(8, LazyPrizeCollection.solve(map, 6));
        assertEquals(9, LazyPrizeCollection.solve(map, 7));
        assertEquals(8, LazyPrizeCollection.solve(map, 8));
    }

    @Test
    public void cycle() {
        ArrayList<int[]> node0 = new ArrayList<>();
        node0.add(new int[] {1, 3});
        ArrayList<int[]> node1 = new ArrayList<>();
        node1.add(new int[] {2, 5});
        ArrayList<int[]> node2 = new ArrayList<>();
        node2.add(new int[] {0, 2});
        ArrayList<ArrayList<int[]>> map = new ArrayList<>();
        Collections.addAll(map, node0, node1, node2);
        assertEquals(0, LazyPrizeCollection.solve(map, 0));
        assertEquals(5, LazyPrizeCollection.solve(map, 1));
        assertEquals(8, LazyPrizeCollection.solve(map, 2));
        assertEquals(10, LazyPrizeCollection.solve(map, 3));
        assertEquals(15, LazyPrizeCollection.solve(map, 4));
        assertEquals(18, LazyPrizeCollection.solve(map, 5));
    }

    @Test
    public void cycle2() {
        ArrayList<int[]> node0 = new ArrayList<>();
        node0.add(new int[] {1, 2});
        ArrayList<int[]> node1 = new ArrayList<>();
        node1.add(new int[] {2, 5});
        ArrayList<int[]> node2 = new ArrayList<>();
        node2.add(new int[] {0, 3});
        ArrayList<ArrayList<int[]>> map = new ArrayList<>();
        Collections.addAll(map, node0, node1, node2);
        assertEquals(0, LazyPrizeCollection.solve(map, 0));
        assertEquals(5, LazyPrizeCollection.solve(map, 1));
        assertEquals(8, LazyPrizeCollection.solve(map, 2));
        assertEquals(10, LazyPrizeCollection.solve(map, 3));
        assertEquals(15, LazyPrizeCollection.solve(map, 4));
        assertEquals(18, LazyPrizeCollection.solve(map, 5));
    }

    @Test
    public void unreachable() {
        ArrayList<int[]> node0 = new ArrayList<>();
        Collections.addAll(node0, new int[] {1, 2}, new int[] {2, 6});
        ArrayList<int[]> node1 = new ArrayList<>();
        Collections.addAll(node1, new int[] {2, 2});
        ArrayList<int[]> node2 = new ArrayList<>();
        ArrayList<ArrayList<int[]>> map = new ArrayList<>();
        Collections.addAll(map, node0, node1, node2);
        assertEquals(0, LazyPrizeCollection.solve(map, 0));
        assertEquals(6, LazyPrizeCollection.solve(map, 1));
        assertEquals(4, LazyPrizeCollection.solve(map, 2));
        assertEquals(Integer.MIN_VALUE, LazyPrizeCollection.solve(map, 3));
        assertEquals(Integer.MIN_VALUE, LazyPrizeCollection.solve(map, 4));
    }
}
