package problems;
import static org.junit.Assert.*;
import org.junit.Test;

public class GridPrizeCollectionTest {
    @Test
    public void recitationEg() {
        int[][] board = new int[][] {
                new int[] {100, 76, 73, 99, 55, 74, 73, 22},
                new int[] {99, 83, 68, 50, 23, 92, 9, 68},
                new int[] {92, 89, 60, 54, 88, 47, 82, 33},
                new int[] {97, 50, 51, 57, 30, 80, 78, 15},
                new int[] {61, 83, 30, 29, 22, 20, 25, 10},
                new int[] {46, 80, 88, 90, 9, 18, 90, 7},
                new int[] {20, 54, 61, 71, 18, 16, 12, 32},
                new int[] {32, 44, 92, 32, 14, 10, 8, 5}
        };
        assertArrayEquals(new int[][] {
                new int[] {0, 0},
                new int[] {0, 1},
                new int[] {0, 2},
                new int[] {1, 2},
                new int[] {2, 2},
                new int[] {3, 2},
                new int[] {4, 2},
                new int[] {4, 3},
                new int[] {4, 4},
                new int[] {4, 5},
                new int[] {5, 5},
                new int[] {6, 5},
                new int[] {7, 5},
                new int[] {7, 6},
                new int[] {7, 7}
        }, GridPrizeCollection.solve(board, 0, 0, 7, 7));
    }
}
