package org.boj2108;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.util.Arrays.sort;

// 통계학
public class boj2108 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] numbers = new int[N];
        int[] arr = new int[8001];
        int avg = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            numbers[i] = Integer.parseInt(st.nextToken());
            avg += numbers[i];
            arr[numbers[i] + 4000]++;
        }
        sort(numbers);
        System.out.println(Math.round((float)avg / N));
        System.out.println(numbers[N / 2]);
        int c = 0;
        for (int i = 0; i < 8001; i++) c = Math.max(c, arr[i]);

        int mode = 0;
        boolean first = false;
        for (int i = 0; i < 8001; i++) {
            if (arr[i] == c) {
                if (!first) {
                    mode = i - 4000;
                    first = true;
                } else {
                    mode = i - 4000;
                    break;
                }
            }
        }
        System.out.println(mode);
        System.out.println(numbers[N - 1] - numbers[0]);
    }
}
