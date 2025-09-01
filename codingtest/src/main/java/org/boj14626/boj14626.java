package org.boj14626;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class boj14626 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine().trim(); // 13자리, 한 자리는 '*'

        int star = -1;
        int sum = 0;

        for (int i = 0; i < 13; i++) {
            int w = (i % 2 == 0) ? 1 : 3;
            char c = s.charAt(i);
            if (c == '*') {
                star = i;
            } else {
                sum += (c - '0') * w;
            }
        }

        int wStar = (star % 2 == 0) ? 1 : 3;
        for (int d = 0; d <= 9; d++) {
            if ((sum + d * wStar) % 10 == 0) {
                System.out.println(d);
                return;
            }
        }
    }
}
