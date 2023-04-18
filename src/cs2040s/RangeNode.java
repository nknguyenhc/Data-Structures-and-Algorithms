package cs2040s;

public class RangeNode extends AVLNode {
    double leftEnd;
    double rightEnd;
    double maxInChildren;

    public RangeNode(double leftEnd, double rightEnd) {
        this.leftEnd = leftEnd;
        this.rightEnd = rightEnd;
    }

    /**
     * Determine if the given element is contained within this range.
     * @param elem the element to determine
     * @return true if the element is contained within this range
     */
    public boolean contains(double elem) {
        return this.leftEnd <= elem & this.rightEnd >= elem;
    }

    /**
     * Determine if the given element is contained within this range.
     * Edges do not count.
     * @param elem the element to determine
     * @return true if the element is contained within this range
     */
    public boolean strictlyContains(double elem) {
        return this.leftEnd < elem & this.rightEnd > elem;
    }

    public double getLeft() {
        return this.leftEnd;
    }

    public double getRight() {
        return this.rightEnd;
    }

    /**
     * Implements the method from the Comparable interface, for range tree implementation
     * @param anotherRange another instance of subtype of T
     * @return
     */
    @Override
    public int compareTo(AVLNode anotherRange) {
        return Double.compare(this.leftEnd, ((RangeNode) anotherRange).leftEnd);
    }
}
