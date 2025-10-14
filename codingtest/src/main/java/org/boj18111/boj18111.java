package org.boj18111;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj18111 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int max = 0;
        int min = 256;
        int ans = Integer.MAX_VALUE;
        int ansHeight = 0;
        int[][] land = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                if (land[i][j] > max) max = land[i][j];
                if (land[i][j] < min) min = land[i][j];
            }
        }

        for (int i = min; i <= max; i++) {
            int time = 0;
            int block = B;
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (land[j][k] > i) {
                        time += (land[j][k] - i) * 2;
                        block += (land[j][k] - i);
                    } else if (land[j][k] < i) {
                        time += (i - land[j][k]);
                        block -= (i - land[j][k]);
                    }
                }
            }
            if (block >= 0) {
                if (time < ans || (time == ans && i > ansHeight)) {
                    ans = time;
                    ansHeight = i;
                }
            }
        }
        System.out.println(ans + " " + ansHeight);
    }
}
