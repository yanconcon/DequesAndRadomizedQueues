import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by Administrator on 2017/12/8 0008.
 */
public class Permutation {
    public static void main(String[] args) {
        RandomizedQueue<String> queue = new RandomizedQueue<>();
        int k = Integer.parseInt(args[0]);
        while (!StdIn.isEmpty()) {
            queue.enqueue(StdIn.readString());
        }
        while (k > 0) {
            StdOut.println(queue.dequeue());
            k--;
        }
    }
}
