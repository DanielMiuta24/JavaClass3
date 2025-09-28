package algorithms;

import java.util.*;

public class BacktrackingNQueens {
    public static List<int[]> solve(int n) {
        List<int[]> solutions = new ArrayList<>();
        int[] cols = new int[n];
        Arrays.fill(cols, -1);
        backtrack(0, cols, solutions);
        return solutions;
    }
    private static void backtrack(int row, int[] cols, List<int[]> out) {
        int n = cols.length;
        if (row == n) { out.add(cols.clone()); return; }
        for (int c = 0; c < n; c++) {
            if (isSafe(cols, row, c)) {
                cols[row] = c;
                backtrack(row + 1, cols, out);
                cols[row] = -1;
            }
        }
    }
    private static boolean isSafe(int[] cols, int r, int c) {
        for (int i = 0; i < r; i++) {
            int pc = cols[i];
            if (pc == c || Math.abs(pc - c) == Math.abs(i - r)) return false;
        }
        return true;
    }
}
