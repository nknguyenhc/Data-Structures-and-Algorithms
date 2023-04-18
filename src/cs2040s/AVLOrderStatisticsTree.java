package cs2040s;


public class AVLOrderStatisticsTree<T extends AVLNode> extends AVLTree<T> implements OrderStatisticsTreeSet<T> {
    @Override
    public final Integer rankByReference(T node) {
        if (node == null) {
            return null;
        }
        if (node.tree != this) {
            return null;
        }

        T next = this.successor(node);
        if (next != null) {
            if (node.compareTo(next) == 0) {
                return this.rankByReference(next);
            }
        }
        T curr = node;
        int total = curr.rightWeight() + 1;
        while (curr != this.root) {
            T parent = this.parent(curr);
            if (curr == parent.left) {
                total += parent.rightWeight() + 1;
            }
            curr = parent;
        }
        return total;
    }

    @Override
    public final Integer rank(T node) {
        T ref = this.object(node);
        return this.rankByReference(ref);
    }

    public final void resetReference(T node) {
        boolean test = this.removeByReference(node);
        if (test) {
            this.add(node);
        }
    }

    @Override
    public final T findElemByRank(int rank) {
        if (rank > this.size | rank <= 0) {
            return null;
        }

        T curr = this.root;
        int currRank = curr.rightWeight() + 1;
        while (true) {
            if (currRank == rank) {
                return curr;
            } else if (currRank < rank) {
                curr = this.leftNode(curr);
                currRank += curr.rightWeight() + 1;
            } else {
                curr = this.rightNode(curr);
                currRank -= curr.leftWeight() + 1;
            }
        }
    }
}
