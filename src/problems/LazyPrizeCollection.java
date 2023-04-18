package problems;
import java.util.ArrayList;

public class LazyPrizeCollection {
    public static int solve(ArrayList<ArrayList<int[]>> map, int kMax) {
        System.out.println();
        System.out.println("New solve");
        System.out.println("kMax: " + kMax);
        int[][] P = new int[map.size()][kMax + 1];
        for (int i = 0; i < map.size(); i++) {
            for (int j = 0; j < kMax + 1; j++) {
                P[i][j] = 0;
            }
        }

        for (int k = 1; k < kMax + 1; k++) {
            System.out.println("At k = " + k);
            for (int v = 0; v < map.size(); v++) {
                int max = -Integer.MIN_VALUE;
                ArrayList<int[]> neighbours = map.get(v);
                for (int w = 0; w < neighbours.size(); w++) {
                    if (P[neighbours.get(w)[0]][k-1] != Integer.MIN_VALUE &
                            P[neighbours.get(w)[0]][k-1] + neighbours.get(w)[1] > max) {
                        max = P[neighbours.get(w)[0]][k-1] + neighbours.get(w)[1];
                    }
                }
                P[v][k] = max;
                System.out.print(max + " ");
            }
            System.out.println();
        }

        int maxP = Integer.MIN_VALUE;
        for (int v = 0; v < map.size(); v++) {
            if (P[v][kMax] > maxP) {
                maxP = P[v][kMax];
            }
        }
        return maxP;
    }
}
