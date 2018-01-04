import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/12/8 0008.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {
    private int leng;
    private Item[] queue;

    public RandomizedQueue() {
        //constructor
        queue = (Item[]) new Object[1];
        leng = 0;
    }
    public boolean isEmpty() {
        return leng == 0;
    }
    public int size() {
        return leng;
    }
    private void resize(int cap) {
        Item[] items = (Item[]) new Object[cap];
        for (int i = 0; i < leng; i++) {
            items[i] = queue[i];
        }
        queue = items;
    }
    public void enqueue(Item item) {
        //add the item
        if (item == null)
            throw new IllegalArgumentException("shu ru wei kong");
        queue[leng++] = item;
        if (leng == queue.length) {
            resize(2 * queue.length);
        }
    }
    public Item dequeue() {
        //remove and return a random item
        if (leng == 0) {
            throw new NoSuchElementException("the radomizeQueue is empty");
        }
        int r = StdRandom.uniform(0, leng);
        leng--;
        Item i = queue[r];
        queue[r] = queue[leng];
        queue[leng] = null;
        if (leng > 0 && leng == queue.length / 4)
            resize(queue.length / 2);
        return i;
    }
    public Item sample() {
        //return a random item (but also not remove it)
        if (leng == 0) {
            throw new NoSuchElementException("the radomizeQueue is empty");
        }
        int r = StdRandom.uniform(0, leng);
        return queue[r];
    }
    @Override
    public Iterator<Item> iterator() {
        return new RandomIterator();
    }
    private class RandomIterator implements Iterator<Item> {
        private int rank;
        private Item[] is;
        public RandomIterator() {
            rank = leng;
            is = (Item[]) new Object[rank];
            for (int i = 0; i < leng; i++) {
                is[i] = queue[i];
            }
        }
        @Override
        public boolean hasNext() {
            return rank > 0;
        }

        @Override
        public Item next() {
            if (leng == 0)
                throw new NoSuchElementException("迭代完了");
            int r = StdRandom.uniform(0, rank);
            rank--;
            Item item = is[r];
            is[r] = is[rank];
            is[rank] = null;
            return item;
        }
        @Override
        public void remove() {
            throw new java.lang.UnsupportedOperationException("不可以用remove");
        }
    }
    public static void main(String[] args) {
           // unit testing (optional)
             RandomizedQueue<String> rq = new RandomizedQueue<String>();
           rq.enqueue("a");
            rq.enqueue("b");
              rq.enqueue("c");
           rq.enqueue("d");
               rq.enqueue("e");
             rq.enqueue("f");
           rq.enqueue("g");
            rq.dequeue();
           Iterator<String> iter1 = rq.iterator();
          Iterator<String> iter2 = rq.iterator();
            while (iter1.hasNext()) {
               System.out.print(iter1.next() + ",");
                }
           System.out.println();
          while (iter2.hasNext()) {
                   System.out.print(iter2.next() + ",");
                   }
               System.out.println();

             }
}
