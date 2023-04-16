import cs2040s.AVLTree;
import cs2040s.AVLNode;

public class MedianFindingSolution {
    public static class IntNode extends AVLNode {
        private int field;

        public IntNode(int field) {
            this.field = field;
        }

        @Override
        public int compareTo(AVLNode anotherNode) {
            return this.field - ((IntNode) anotherNode).field;
        }

        public int value() {
            return this.field;
        }

        @Override
        public String toString() {
            return "Node: " + this.field;
        }
    }

    AVLTree<IntNode> tree = new AVLTree<>();

    public void insert(int x) {
        this.tree.add(new IntNode(x));
    }

    public int getMedian() {
        IntNode resultNode = this.tree.findElemByRank((this.tree.size() + 1) / 2);
        this.tree.removeByReference(resultNode);
        return resultNode.value();
    }
}
