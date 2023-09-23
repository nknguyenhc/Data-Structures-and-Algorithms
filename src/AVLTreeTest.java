import cs2040s.AVLNode;
import cs2040s.AVLTree;
import static org.junit.Assert.*;
import org.junit.Test;

public class AVLTreeTest {
    private static class TestNode extends AVLNode {
        private int num;

        private TestNode(int num) {
            this.num = num;
        }

        @Override
        public int compareTo(AVLNode another) {
            if (another instanceof TestNode) {
                TestNode anotherNode = (TestNode) another;
                return this.num - anotherNode.num;
            }
            return 0;
        }

        @Override
        public boolean equals(Object object) {
            if (object instanceof TestNode) {
                TestNode anotherNode = (TestNode) object;
                return this.num == anotherNode.num;
            }
            return false;
        }
    }

    @Test
    public void testContain() {
        AVLTree<TestNode> tree = new AVLTree<>();
        TestNode ref1 = new TestNode(10);
        TestNode ref2 = new TestNode(12);
        tree.add(new TestNode(10));
        assertTrue(tree.contains(ref1));
        assertFalse(tree.containsReference(ref1));
        assertFalse(tree.contains(ref2));
        assertEquals(1, tree.size());
        tree.add(ref2);
        assertTrue(tree.contains(ref1));
        assertFalse(tree.containsReference(ref1));
        assertTrue(tree.contains(ref2));
        assertTrue(tree.containsReference(ref2));
        assertEquals(2, tree.size());
        tree.remove(ref1);
        assertFalse(tree.contains(ref1));
        assertTrue(tree.containsReference(ref2));
        assertEquals(1, tree.size());
        tree.add(ref1);
        assertTrue(tree.containsReference(ref1));
        assertTrue(tree.containsReference(ref2));
        tree.remove(ref2);
        assertTrue(tree.containsReference(ref1));
        assertFalse(tree.containsReference(ref2));
        assertEquals(1, tree.size());
        tree.add(new TestNode(12));
        tree.removeByReference(ref2);
        assertTrue(tree.contains(ref2));
        assertEquals(2, tree.size());
    }

    @Test
    public void floorCeilTest() {
        AVLTree<TestNode> tree = new AVLTree<>();
        tree.add(new TestNode(10));
        tree.add(new TestNode(12));
        tree.add(new TestNode(14));
        assertEquals(new TestNode(10), tree.floor(new TestNode(11)));
        assertEquals(new TestNode(12), tree.floor(new TestNode(12)));
        assertEquals(new TestNode(14), tree.floor(new TestNode(90)));
        assertEquals(new TestNode(10), tree.ceil(new TestNode(-12)));
        assertEquals(new TestNode(12), tree.ceil(new TestNode(11)));
        assertEquals(new TestNode(14), tree.ceil(new TestNode(14)));
        tree.add(new TestNode(20));
        assertEquals(new TestNode(14), tree.floor(new TestNode(14)));
        assertEquals(new TestNode(14), tree.ceil(new TestNode(14)));
        assertEquals(new TestNode(20), tree.ceil(new TestNode(15)));
        assertNull(tree.floor(new TestNode(5)));
        assertNull(tree.ceil(new TestNode(20)));
        assertNull(new AVLTree<TestNode>().ceil(new TestNode(5)));
    }

    @Test
    public void higherLowerTest() {
        AVLTree<TestNode> tree = new AVLTree<>();
        tree.add(new TestNode(10));
        tree.add(new TestNode(20));
        tree.add(new TestNode(12));
        tree.add(new TestNode(18));
        tree.add(new TestNode(16));
        assertEquals(new TestNode(12), tree.higher(new TestNode(11)));
        assertEquals(new TestNode(12), tree.higher(new TestNode(10)));
        assertEquals(new TestNode(10), tree.lower(new TestNode(11)));
        assertNull(tree.lower(new TestNode(10)));
        assertNull(tree.higher(new TestNode(20)));
        assertNull(tree.lower(new TestNode(5)));
        assertNull(tree.higher(new TestNode(20)));
        assertNull(new AVLTree<TestNode>().lower(new TestNode(12)));
        tree.add(new TestNode(16));
        assertEquals(new TestNode(16), tree.higher(new TestNode(14)));
        assertEquals(new TestNode(18), tree.higher(new TestNode(16)));
        assertEquals(new TestNode(12), tree.lower(new TestNode(14)));
        tree.remove(new TestNode(16));
        assertEquals(new TestNode(16), tree.higher(new TestNode(14)));
        assertEquals(new TestNode(18), tree.higher(new TestNode(16)));
        tree.remove(new TestNode(16));
        assertEquals(new TestNode(18), tree.higher(new TestNode(12)));
    }
}
