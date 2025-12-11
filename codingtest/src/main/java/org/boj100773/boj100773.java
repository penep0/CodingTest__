package org.boj100773;

import java.util.Scanner;
import java.util.Stack;

// 제로
public class boj100773 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            if(a == 0) {
                stack.pop();
            } else {
                stack.push(a);
            }
        }

        while(!stack.isEmpty()) {
            result += stack.pop();
        }
        System.out.println(result);
    }
}
