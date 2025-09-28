package algorithms;

public class CountingSort {
    // Works for non-negative integers
    public static void sort(int[] a) {
        if (a.length == 0) return;
        int max = 0;
        for (int v : a) if (v > max) max = v;
        int[] cnt = new int[max + 1];
        for (int v : a) cnt[v]++;
        int idx = 0;
        for (int v = 0; v < cnt.length; v++) {
            for (int k = 0; k < cnt[v]; k++) a[idx++] = v;
        }
    }
}
