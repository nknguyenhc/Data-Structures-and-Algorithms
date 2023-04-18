package cs2040s;

/**
 * This class uses AVL Tree implementation for a range tree,
 * which supports search interval operations.
 */
public class AVLRangeTree extends AVLTree<RangeNode> implements RangeTreeSet {
    @Override
    public RangeNode searchRange(double elem) {
        RangeNode curr = this.root;
        while (!curr.contains(elem)) {
            if (curr.maxInChildren < elem) {
                return null;
            }
            if (curr.left == null) {
                curr = (RangeNode) curr.right;
            } else if (((RangeNode) curr.left).maxInChildren < elem) {
                curr = (RangeNode) curr.right;
            } else {
                curr = (RangeNode) curr.left;
            }
        }
        return curr;
    }

    @Override
    public RangeNode searchStrictRange(double elem) {
        RangeNode curr = this.root;
        while (!curr.strictlyContains(elem)) {
            if (curr.maxInChildren <= elem) {
                return null;
            }
            if (curr.left == null) {
                curr = (RangeNode) curr.right;
            } else if (((RangeNode) curr.left).maxInChildren <= elem) {
                curr = (RangeNode) curr.right;
            } else {
                curr = (RangeNode) curr.left;
            }
        }
        return curr;
    }
}
