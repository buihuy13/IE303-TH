import java.util.*;

public class Bai4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        int[] dp   = new int[k + 1];
        int[] prev = new int[k + 1];
        int[] from = new int[k + 1];
        Arrays.fill(dp,   -1);
        Arrays.fill(prev, -1);
        Arrays.fill(from, -1);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int s = k; s >= a[i]; s--) {
                if (dp[s - a[i]] != -1) {
                    int newLen = dp[s - a[i]] + 1;
                    if (newLen > dp[s]) {
                        dp[s]   = newLen;
                        prev[s] = i;
                        from[s] = s - a[i];
                    }
                }
            }
        }

        if (dp[k] == -1) {
            System.out.println("Khong ton tai day con có tong = " + k);
            sc.close();
            return;
        }

        List<Integer> result = new ArrayList<>();
        int s = k;
        while (s > 0) {
            result.add(a[prev[s]]);
            s = from[s];
        }
        Collections.reverse(result);

        System.out.println(result);
        sc.close();
    }
}