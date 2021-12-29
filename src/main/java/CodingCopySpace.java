import java.util.ArrayDeque;
import java.util.Deque;
import java.util.PriorityQueue;
import java.util.Vector;

public class CodingCopySpace {
    public static void main(String[] args) {
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(2);
        dq.add(1);
        dq.add(3);
        dq.removeLast();
        //System.out.println(dq);

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(2);
        pq.add(1);
        pq.add(3);
        System.out.println(pq);
        pq.remove();
       System.out.println(pq);
    }
}
