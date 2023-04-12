package cs2040s;

public interface Set<T> {
    /**
     * Add the element to the set.
     * This operation allows duplicate elements.
     * However, if the reference is already in the set, no operation is done.
     * @param elem the element to be added
     */
    public void add(T elem);

    /**
     * Check if an element is in the set.
     * @param elem the element to compare
     * @return true if the element is in the set
     */
    public boolean contains(T elem);

    /**
     * Return the reference object that is equal (qualified by Object.equals(Object)) to the given element.
     * @param elem the element to compare
     * @return the reference object, or null if the element does not exist
     */
    public T object(T elem);

    /**
     * Remove the element from the set.
     * @param elem the element to be removed
     * @return true if the element was previously in the set
     */
    public boolean remove(T elem);

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

    /**
     * Return the size of the set.
     * @return the size of the set
     */
    public int size();
}
