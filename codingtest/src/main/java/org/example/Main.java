package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine().toUpperCase();

        int[] count = new int[26];

        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if ('A' <= c && c <= 'Z') {
                count[c - 'A']++;
            }
        }

        int max = 0;
        char answer = '?';

        for (int i = 0; i < 26; i++) {
            if (count[i] > max) {
                max = count[i];
                answer = (char) ('A' + i);
            } else if (count[i] == max && max != 0) {
                answer = '?';
            }
        }

        System.out.println(answer);
    }
}