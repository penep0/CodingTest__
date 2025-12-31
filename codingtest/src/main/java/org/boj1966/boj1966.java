package org.boj1966;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

// 프린터 큐
public class boj1966 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            Queue<int[]> queue = new ArrayDeque<>();
            int[] priorityCount = new int[10];
            for (int i = 0; i < N; i++) {
                int priority = Integer.parseInt(st.nextToken());
                queue.add(new int[]{i, priority});
                priorityCount[priority]++;
            }

            int printOrder = 0;
            while (!queue.isEmpty()) {
                int[] current = queue.poll();
                int curIndex = current[0];
                int curPriority = current[1];

                boolean hasHigherPriority = false;
                for (int p = curPriority + 1; p <= 9; p++) {
                    if (priorityCount[p] > 0) {
                        hasHigherPriority = true;
                        break;
                    }
                }

                if (hasHigherPriority) {
                    queue.add(current);
                } else {
                    printOrder++;
                    priorityCount[curPriority]--;
                    if (curIndex == M) {
                        sb.append(printOrder).append('\n');
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
    }
}
