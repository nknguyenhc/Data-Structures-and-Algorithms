package problems;
import cs2040s.FixedSizeQueue;
import java.util.ArrayList;

/**
 * Given a board, each cell contains a prize.
 * You can only move from cell with higher prize to cell with lower prize.
 * Your score is total prizes on the way.
 * Find the path with the greatest score from start to end.
 * We assume that the board dimension is of at least 2,
 * user should solve edge cases by yourself.
 */
public class GridPrizeCollection {
    private static <T> void debug(T[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static <T> void debug(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] solve(int[][] board, int startRow, int startCol, int endRow, int endCol) {
        int m = board.length;
        int n = board[0].length;
        // Run LIS with DP approach
        // Use Kahn's algo to determine topological order
        // While at the same time determine the path
        class Point {
            int x;
            int y;
            public Point(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public String toString() {
                return "(" + this.x + ", " + this.y + ")";
            }
        }
        FixedSizeQueue<Point> queue = new FixedSizeQueue<>(m * n);
        /*
        // First initiate a board of outdegrees
        int[][] outdegrees = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                outdegrees[i][j] = 0;
                if (i > 0) {
                    if (board[i][j] > board[i - 1][j]) {
                        outdegrees[i][j]++;
                    }
                }
                if (i < m - 1) {
                    if (board[i][j] > board[i + 1][j]) {
                        outdegrees[i][j]++;
                    }
                }
                if (j > 0) {
                    if (board[i][j] > board[i][j - 1]) {
                        outdegrees[i][j]++;
                    }
                }
                if (j < n - 1) {
                    if (board[i][j] > board[i][j + 1]) {
                        outdegrees[i][j]++;
                    }
                }
                if (outdegrees[i][j] == 0) {
                    queue.enq(new Point(i, j));
                }
            }
        }
        debug(outdegrees);
        */

        // now solve
        int[][] largestPrizes = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                largestPrizes[i][j] = 0;
            }
        }

        Point[][] nexts = new Point[m][n];
        queue.enq(new Point(endRow, endCol));
        while (queue.size() > 0) {
            Point curr = queue.deq();
            System.out.println(curr);
            Point next = null;

            int largestNextPrize = Integer.MIN_VALUE;
            if (curr.x > 0) {
                if (board[curr.x][curr.y] > board[curr.x - 1][curr.y]) {
                    if (board[curr.x - 1][curr.y] > largestNextPrize) {
                        largestNextPrize = board[curr.x - 1][curr.y];
                        next = new Point(curr.x - 1, curr.y);
                    }
                }
                if (board[curr.x][curr.y] < board[curr.x - 1][curr.y]) {
                    queue.enq(new Point(curr.x - 1, curr.y));
                }
            }
            if (curr.x < m - 1) {
                if (board[curr.x][curr.y] > board[curr.x + 1][curr.y]) {
                    if (board[curr.x + 1][curr.y] > largestNextPrize) {
                        largestNextPrize = board[curr.x + 1][curr.y];
                        next = new Point(curr.x + 1, curr.y);
                    }
                }
                if (board[curr.x][curr.y] < board[curr.x + 1][curr.y]) {
                    queue.enq(new Point(curr.x + 1, curr.y));
                }
            }
            if (curr.y > 0) {
                if (board[curr.x][curr.y] > board[curr.x][curr.y - 1]) {
                    if (board[curr.x][curr.y - 1] > largestNextPrize) {
                        largestNextPrize = board[curr.x][curr.y - 1];
                        next = new Point(curr.x, curr.y - 1);
                    }
                }
                if (board[curr.x][curr.y] < board[curr.x][curr.y - 1]) {
                    queue.enq(new Point(curr.x, curr.y - 1));
                }
            }
            if (curr.y < n - 1) {
                if (board[curr.x][curr.y] > board[curr.x][curr.y + 1]) {
                    if (board[curr.x][curr.y + 1] > largestNextPrize) {
                        largestNextPrize = board[curr.x][curr.y + 1];
                        next = new Point(curr.x, curr.y + 1);
                    }
                }
                if (board[curr.x][curr.y] < board[curr.x][curr.y + 1]) {
                    queue.enq(new Point(curr.x, curr.y + 1));
                }
            }

            largestPrizes[curr.x][curr.y] = largestNextPrize + board[curr.x][curr.y];
            nexts[curr.x][curr.y] = next;

            if (curr.x == startRow & curr.y == startCol) {
                debug(largestPrizes);
                debug(nexts);
                ArrayList<int[]> result = new ArrayList<>();
                result.add(new int[] {startRow, startCol});
                int currX = startRow;
                int currY = startCol;
                while (currX != endRow | currY != endCol) {
                    Point nextInResult = nexts[currX][currY];
                    result.add(new int[] {nextInResult.x, nextInResult.y});
                    currX = nextInResult.x;
                    currY = nextInResult.y;
                }
                result.add(new int[] {endRow, endCol});
                return result.toArray(new int[result.size()][]);
            }
        }

        return null;
    }
}
