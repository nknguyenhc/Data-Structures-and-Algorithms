package cs2040s;

public interface RangeNode<T> {
    /**
     * Determine if the given element is contained within this range
     * @param elem the element to determine
     * @return true if the element is contained within this range
     */
    public boolean contains(T elem);
}
