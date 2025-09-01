package org.boj1260;

import java.io.*;
import java.util.*;

public class boj1260 {
    public static int n;
    public static int m;
    public static int k;
    public static int[][] arr = new int[1001][1001];
    public static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = arr[b][a] =1;
        }
        dfs(k);
        visited = new boolean[n + 1];
        System.out.println();
        bfs(k);
        br.close();
    }

    public static void dfs(int point) {
        visited[point] =  true;
        System.out.print(point+" ");
        for(int i = 1; i <= n; i++) {
            if(!visited[i] && arr[point][i] == 1) {
                dfs(i);
            }
        }
    }

    public static void bfs(int point) {
        visited[point] = true;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(point);
        while(!q.isEmpty()) {
            int a = q.poll();
            System.out.print(a + " ");
            for(int i = 1; i <= n; i++) {
                if(!visited[i] && arr[a][i] == 1) {
                    q.offer(i);
                    visited[i] = true;
                }
            }
        }
    }

}