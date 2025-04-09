package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());
        int highest = 0;
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st2.nextToken());
            arr[i] = a;
            if (a > highest) {
                highest = a;
            }
        }

        br.close();
    }

    public int getTree(int[] arr, int h) {
        int sum = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] > h) {
                sum += arr[i] - h;
            }
        }

        return sum;
    }
}

