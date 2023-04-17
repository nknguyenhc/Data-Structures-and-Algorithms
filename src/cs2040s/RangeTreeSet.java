package cs2040s;

public interface RangeTreeSet<T extends RangeNode<? super U>, U> extends Set<T> {
    /**
     * Determine whether the element is inside any range, and if there is, return the range.
     * @param searchElem the element to search for a suitable range
     * @return the range that the searchElem is contained in, if any
     */
    public T searchRange(U searchElem);
}
