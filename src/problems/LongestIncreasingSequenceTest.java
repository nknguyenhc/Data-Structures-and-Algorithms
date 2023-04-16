package problems;
import static org.junit.Assert.*;
import org.junit.Test;

public class LongestIncreasingSequenceTest {
    @Test
    public void normal1() {
        assertArrayEquals(new int[] {2, 3, 5, 6},
                LongestIncreasingSequence.solve(new int[] {8, 2, 3, 7, 5, 6, 1}));
    }

    @Test
    public void normal2() {
        assertArrayEquals(new int[] {1, 2, 4, 6, 6},
                LongestIncreasingSequence.solve(new int[] {8, 9, 1, 2, 10, 11, 4, 6, 6}));
    }

    @Test
    public void oneElem() {
        assertArrayEquals(new int[] {1},
                LongestIncreasingSequence.solve(new int[] {1}));
    }

    @Test
    public void noElem() {
        assertArrayEquals(new int[] {},
                LongestIncreasingSequence.solve(new int[] {}));
    }

    @Test
    public void twoElems() {
        assertArrayEquals(new int[] {1},
                LongestIncreasingSequence.solve(new int[] {2, 1}));
    }
}
