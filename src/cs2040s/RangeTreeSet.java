package cs2040s;

public interface RangeTreeSet<T extends Comparable<? super T>> extends TreeSet<RangeNode<T>> {
    /**
     * Determine whether the element is inside any range, and if there is, return the range.
     * @param searchElem the element to search for a suitable range
     * @return the range that the searchElem is contained in, if any
     */
    public RangeNode<T> searchRange(T searchElem);

    /**
     * Determine whether the element is inside any range (not counting the edges), and if there is, return the range.
     * @param searchElem the element to search for a suitable range
     * @return the range that the searchElem is contained in, if any
     */
    public RangeNode<T> searchStrictRange(T searchElem);
}
