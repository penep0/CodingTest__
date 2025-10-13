package org.boj1654;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1654 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        long N = Long.parseLong(st.nextToken());

        long[] cable = new long[K];
        long hi = 0;
        for (int i = 0; i < K; i++) {
            cable[i] = Long.parseLong(br.readLine());
            if (cable[i] > hi) hi = cable[i];
        }

        long lo = 1;
        long ans = 0;

        while (lo <= hi) {
            long mid = lo + (hi - lo) / 2;
            long cnt = 0;

            for (long len : cable) {
                cnt += (len / mid);
                if (cnt >= N) break;
            }

            if (cnt >= N) {
                ans = mid;
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }

        System.out.println(ans);
    }
}
