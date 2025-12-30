package org.boj18110;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

// solved.ac
public class boj18110 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        if (N == 0) {
            System.out.println(0);
            return;
        }
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        float sum = 0;
        Arrays.sort(arr);
        for (int i = Math.round(N * 3 / 20.0f); i < N - Math.round(N * 3 / 20.0f); i++) {
            sum += arr[i];
        }

        System.out.println(Math.round(sum / (N - 2 * Math.round(N * 3 / 20.0f))));
    }
}
