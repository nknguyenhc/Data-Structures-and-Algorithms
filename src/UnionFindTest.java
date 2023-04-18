import cs2040s.UnionFind;
import static org.junit.Assert.*;
import org.junit.Test;

public class UnionFindTest {
    @Test
    public void normal1() {
        UnionFind unionFind = new UnionFind(8);
        assertFalse(unionFind.find(0, 2));
        unionFind.union(0, 2);
        assertTrue(unionFind.find(0, 2));
        assertTrue(unionFind.find(0, 2));
        assertFalse(unionFind.find(0, 3));
        assertFalse(unionFind.find(4, 7));
        unionFind.union(4, 7);
        assertTrue(unionFind.find(4, 7));
        assertFalse(unionFind.find(2, 4));
        unionFind.union(2, 3);
        assertTrue(unionFind.find(0, 3));
        assertFalse(unionFind.find(2, 4));
        unionFind.union(1, 6);
        unionFind.union(1, 0);
        assertTrue(unionFind.find(1, 3));
        assertTrue(unionFind.find(2, 6));
        assertFalse(unionFind.find(0, 4));
        unionFind.union(5, 6);
        assertTrue(unionFind.find(0, 5));
        assertFalse(unionFind.find(0, 4));
    }

    @Test
    public void normal2() {
        UnionFind unionFind = new UnionFind(8);
        unionFind.union(0, 3);
        unionFind.union(0, 4);
        unionFind.union(0, 5);
        unionFind.union(6, 7);
        assertFalse(unionFind.find(7, 0));
        assertTrue(unionFind.find(3, 5));
        unionFind.union(7, 3);
        assertTrue(unionFind.find(0, 7));
        assertFalse(unionFind.find(0, 1));
    }

    @Test
    public void redundantOps() {
        UnionFind unionFind = new UnionFind(8);
        unionFind.union(1, 0);
        unionFind.union(2, 3);
        unionFind.union(1, 2);
        unionFind.union(5, 6);
        unionFind.union(2, 3);
        assertTrue(unionFind.find(5, 5));
        assertTrue(unionFind.find(2, 1));
    }

    @Test
    public void redundantOpsOneElem() {
        UnionFind unionFind = new UnionFind(1);
        assertTrue(unionFind.find(0, 0));
        unionFind.union(0, 0);
        assertTrue(unionFind.find(0, 0));
    }
}
