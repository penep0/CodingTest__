package org.boj1193;

import java.util.Scanner;

//분수 찾기
public class boj1193 {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int i = 1;
        while(true) {
            if(N - i <= 0) {
                break;
            } else {
                N -= i;
            }
            i++;
        }
        if(i % 2 == 0) {
            System.out.println(N + "/" + (i - N + 1));
        } else {
            System.out.println((i - N + 1) + "/" + N);
        }
    }
}
