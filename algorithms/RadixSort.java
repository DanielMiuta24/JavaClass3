package algorithms;

public class RadixSort {
    // LSD radix sort for non-negative integers (base 10)
    public static void sort(int[] a) {
        if (a.length == 0) return;
        int max = 0;
        for (int v : a) if (v > max) max = v;
        int exp = 1;
        int[] aux = new int[a.length];
        while (max / exp > 0) {
            int[] cnt = new int[10];
            for (int v : a) cnt[(v / exp) % 10]++;
            for (int i = 1; i < 10; i++) cnt[i] += cnt[i-1];
            for (int i = a.length - 1; i >= 0; i--) {
                int d = (a[i] / exp) % 10;
                aux[--cnt[d]] = a[i];
            }
            System.arraycopy(aux, 0, a, 0, a.length);
            exp *= 10;
        }
    }
}
