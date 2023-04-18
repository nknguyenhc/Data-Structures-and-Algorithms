package cs2040s;

public class RangeNode<T extends Comparable<? super T>> extends AVLNode {
    T leftEnd;
    T rightEnd;
    T maxInChildren;

    public RangeNode(T leftEnd, T rightEnd) {
        this.leftEnd = leftEnd;
        this.rightEnd = rightEnd;
    }

    /**
     * Determine if the given element is contained within this range.
     * @param elem the element to determine
     * @return true if the element is contained within this range
     */
    public boolean contains(T elem) {
        return this.leftEnd.compareTo(elem) <= 0 & this.rightEnd.compareTo(elem) >= 0;
    }

    /**
     * Determine if the given element is contained within this range.
     * Edges do not count.
     * @param elem the element to determine
     * @return true if the element is contained within this range
     */
    public boolean strictlyContains(T elem) {
        return this.leftEnd.compareTo(elem) < 0 & this.rightEnd.compareTo(elem) > 0;
    }

    public T getLeftEnd() {
        return this.leftEnd;
    }

    public T getRightEnd() {
        return this.rightEnd;
    }

    final void updateMaxInChildren() {
        if (this.left != null) {
            @SuppressWarnings("unchecked")
            RangeNode<T> leftNode = (RangeNode<T>) this.left;
            if (leftNode.maxInChildren.compareTo(this.maxInChildren) > 0) {
                this.maxInChildren = leftNode.maxInChildren;
            }
        }
        if (this.right != null) {
            @SuppressWarnings("unchecked")
            RangeNode<T> rightNode = (RangeNode<T>) this.right;
            if (rightNode.maxInChildren.compareTo(this.maxInChildren) > 0) {
                this.maxInChildren = rightNode.maxInChildren;
            }
        }
    }

    /**
     * Implements the method from the Comparable interface, for range tree implementation
     * @param anotherNode another instance of subtype of T
     * @return
     */
    @Override
    public int compareTo(AVLNode anotherNode) {
        @SuppressWarnings("unchecked")
        RangeNode<T> anotherRange = (RangeNode<T>) anotherNode;
        return this.leftEnd.compareTo(anotherRange.leftEnd);
    }
}
