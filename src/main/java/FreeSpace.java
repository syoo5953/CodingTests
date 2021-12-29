import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class FreeSpace {
    public static void main(String[] args) {
        boolean[] prime = new boolean[21];
        Arrays.fill(prime, true);
        for(int i = 2; i <= 20; i++) {
            for(int m = 2; m <= i/2; m++) {
                if(i%m == 0) {
                    prime[i] = false;
                    break;
                }
            }
        }
        for(int i = 2; i <= 20; i++) {
            if(prime[i] == true) {
                System.out.println(i);
            }
        }
    }
}