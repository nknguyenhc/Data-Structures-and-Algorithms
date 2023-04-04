package cs2040s;

public interface Comparable<T> {
    /**
     * Compare to another element of subtype of T
     * @param another another instance of subtype of T
     * @return positive if this element is greater than T, 0 if equal, negative if smaller
     */
    public int compareTo(T another);
}
