package problems;

public class LongestIncreasingSequence {
    private static class NumberInSequence {
        private int value;
        private NumberInSequence parent;

        private NumberInSequence(int value, NumberInSequence parent) {
            this.value = value;
            this.parent = parent;
        }
    }

    private static int longestChainIndex(int longestCount, NumberInSequence[] searchArray, int number) {
        int start = 0;
        int end = longestCount - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (searchArray[mid].value <= number) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start - 1;
    }

    public static int[] solve(int[] input) {
        if (input.length == 0) {
            return new int[0];
        }

        int longestCount = 1;
        NumberInSequence[] activeEndNodes = new NumberInSequence[input.length];
        activeEndNodes[0] = new NumberInSequence(input[0], null);
        for (int i = 1; i < input.length; i++) {
            int longestChainIndex = longestChainIndex(longestCount, activeEndNodes, input[i]);
            if (longestChainIndex == longestCount - 1) {
                activeEndNodes[longestCount] = new NumberInSequence(input[i], activeEndNodes[longestChainIndex]);
                longestCount++;
            } else if (longestChainIndex == -1) {
                if (input[i] < activeEndNodes[0].value) {
                    activeEndNodes[0] = new NumberInSequence(input[i], null);
                }
            } else {
                if (input[i] < activeEndNodes[longestChainIndex + 1].value) {
                    activeEndNodes[longestChainIndex + 1] = new NumberInSequence(input[i],
                            activeEndNodes[longestChainIndex]);
                }
            }
        }

        int[] result = new int[longestCount];
        NumberInSequence curr = activeEndNodes[longestCount - 1];
        for (int i = longestCount - 1; i >= 0; i--) {
            result[i] = curr.value;
            curr = curr.parent;
        }
        return result;
    }
}
