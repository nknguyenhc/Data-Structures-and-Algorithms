package cs2040s;

public interface TreeSet<T extends Comparable<? super T>> extends Set<T> {
    /**
     * Return the greatest element smaller than or equal to the given element.
     * This operation runs in O(log n) time.
     * @param elem the element for comparison
     * @return the floor of the element, or null if there is not any
     */
    public T floor(T elem);

    /**
     * Return the greatest element strictly smaller than the given element.
     * This operation runs in O(log n) time.
     * @param elem the element for comparison
     * @return the greatest element smaller than the given, or null if there is not any
     */
    public T lower(T elem);

    /**
     * Return the smallest element greater than or equal to the given element.
     * This operation runs in O(log n) time.
     * @param elem the element for comparison
     * @return the ceiling of the element, or null if there is not any
     */
    public T ceil(T elem);

    /**
     * Return the smallest element strictly greater than to the given element.
     * This operation runs in O(log n) time.
     * @param elem the element for comparison
     * @return the smallest element greater than the given, or null if there is not any
     */
    public T higher(T elem);

    /**
     * Return the lowest element in the set.
     * This operation runs in O(log n) time.
     * @return the smallest element, or null if the set is empty
     */
    public T lowest();

    /**
     * Return the greatest element in the set.
     * This operation runs in O(log n) time.
     * @return the greatest element, or null if the set is empty
     */
    public T highest();

    /**
     * Check if the reference of this object is in the tree set.
     * This operation checks by reference and therefore takes O(1) time.
     * @param elem the reference to check
     * @return true if the reference of the element is in the set.
     */
    public boolean containsReference(T elem);

    /**
     * Remove the reference from the set.
     * This operation cuts down on time searching for the element in the set.
     * This operation still takes O(log n) time.
     * @param elem the reference to remove
     * @return true if the element was previously in the set
     */
    public boolean removeByReference(T elem);
}
