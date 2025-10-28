package org.boj1697;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj1697 {
    static final int MAX = 100000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // N이 K보다 크거나 같으면 뒤로 걷기만 하면 됨
        if (N >= K) {
            System.out.println(N - K);
            return;
        }

        int[] dist = new int[MAX + 1];
        Arrays.fill(dist, -1);

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(N);
        dist[N] = 0;

        while (!q.isEmpty()) {
            int cur = q.poll();

            // 목적지 도달 시 바로 종료
            if (cur == K) {
                System.out.println(dist[cur]);
                return;
            }

            // 세 가지 이동
            int[] nexts = {cur - 1, cur + 1, cur * 2};
            for (int nx : nexts) {
                if (nx < 0 || nx > MAX) continue;     // 범위 체크
                if (dist[nx] != -1) continue;          // 이미 방문
                dist[nx] = dist[cur] + 1;
                q.add(nx);
            }
        }
    }
}
