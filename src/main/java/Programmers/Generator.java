package Programmers;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Generator{

    public static void main(String[] args) {

        boolean [] bl = new boolean[5001];

        for(int i = 1; i < 5001; i++) {
            int self = (((i/1000) % 10) + ((i/100) % 10) + ((i/10) % 10) + (i%10) + i);

            if (self < 5001) {
                bl[self] = true;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i<5001; i++) {
            if(!bl[i]) {
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);

    }
}