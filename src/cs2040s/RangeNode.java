package cs2040s;

public abstract class RangeNode<T> implements Comparable<RangeNode<T>> {
    /**
     * Determine if the given element is contained within this range
     * @param elem the element to determine
     * @return true if the element is contained within this range
     */
    public abstract boolean contains(T elem);
}
