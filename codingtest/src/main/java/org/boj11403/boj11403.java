package org.boj11403;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj11403 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        List<Integer>[] list = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            list[i] = new ArrayList<>();
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    list[i].add(j);
                }
            }
        }

        int[][] answer = new int[N][N];
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            dfs(i, i, list, visited, answer);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int i, int j, List<Integer>[] list, boolean[] visited, int[][] answer) {
        for (int k : list[j]) {
            if (!visited[k]) {
                visited[k] = true;
                answer[i][k] = 1;
                dfs(i, k, list, visited, answer);
            }
        }
    }
}
