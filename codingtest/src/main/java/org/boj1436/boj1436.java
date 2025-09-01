package org.boj1436;

import java.util.Scanner;

public class boj1436 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 666;
        int add = 1;
        while(add != n) {
            result++;
            for(int i = result; i > 100; i /= 10){
                if(i % 1000 == 666) {
                    add++;
                    break;
                }
            }
        }
        System.out.println(result);
    }
}
