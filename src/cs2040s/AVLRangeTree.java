package cs2040s;

/**
 * This class uses AVL Tree implementation for a range tree,
 * which supports search interval operations.
 */
public class AVLRangeTree<T extends Comparable<? super T>> extends AVLTree<RangeNode<T>> implements RangeTreeSet<T> {
    @Override
    public RangeNode<T> searchRange(T elem) {
        RangeNode<T> curr = this.root;
        while (!curr.contains(elem)) {
            if (curr.maxInChildren.compareTo(elem) < 0) {
                return null;
            }
            if (curr.left == null) {
                curr = this.rightNode(curr);
            } else if (this.leftNode(curr).maxInChildren.compareTo(elem) < 0) {
                curr = this.rightNode(curr);
            } else {
                curr = this.leftNode(curr);
            }
        }
        return curr;
    }

    @Override
    public RangeNode<T> searchStrictRange(T elem) {
        RangeNode<T> curr = this.root;
        while (!curr.strictlyContains(elem)) {
            if (curr.maxInChildren.compareTo(elem) <= 0) {
                return null;
            }
            if (curr.left == null) {
                curr = this.rightNode(curr);
            } else if (this.leftNode(curr).maxInChildren.compareTo(elem) <= 0) {
                curr = this.rightNode(curr);
            } else {
                curr = this.leftNode(curr);
            }
        }
        return curr;
    }
}
