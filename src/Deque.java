import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {//overhead 16 bytes
    private int n;//4 bytes
    private Node<Item> firstNode;//8 bytes
    private Node<Item> lastNode;//8 bytes
    //116+48n bytes
    private static class Node<Item> {//overhead 16 bytes + padding 8 bytes == 48 bytes
        private Item value;//8 bytes
        private Node<Item> next;//8 bytes
        private Node<Item> previous;//8 bytes
    }
    public Deque() {
        firstNode = null;
        lastNode = null;
        n = 0;
    }
    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }
    public void addFirst(Item item) {
        if (item == null)
            throw new java.lang.NullPointerException("addFirst empty");
        Node<Item> oldfirst = firstNode;
        firstNode = new Node<Item>();
        firstNode.value = item;
        firstNode.previous = null;
        if(isEmpty()){
            lastNode = firstNode;
            firstNode.next = null;
        }
        else{
            firstNode.next = oldfirst;
            oldfirst.previous = firstNode;
        }
        n++;
    }
    public void addLast(Item item) {
        if (item == null)
            throw new java.lang.IllegalArgumentException("addLast empty");
        Node oldlast = lastNode;
        lastNode = new Node();
        lastNode.value = item;
        lastNode.next = null;
        if(isEmpty()){
            firstNode = lastNode;
            lastNode.previous = null;
        }
        else{
            lastNode.previous = oldlast;
            oldlast.next = lastNode;
        }
        n++;
    }
    public Item removeFirst() {
        if (n == 0) {
            throw new java.util.NoSuchElementException("remoteFirst empty");
        }
        Item i = firstNode.value;
        firstNode = firstNode.next;
        n--;
        if(isEmpty()) {
            lastNode = firstNode = null;
        }else {
            firstNode.previous = null;
        }
        return i;
    }
    public Item removeLast() {
        if (n == 0) {
            throw new java.util.NoSuchElementException("remoteFirst empty");
        }
        Item i = firstNode.value;
        firstNode = firstNode.next;
        n--;
        if (isEmpty()) {
            firstNode = lastNode = null;
        }else {
            lastNode.next = null;
        }
        return i;
    }

    @Override
    public Iterator<Item> iterator() {
        return new MyIterator();
    }
    private class MyIterator implements Iterator<Item> {
        private Node<Item> current;

        public MyIterator() {
            current = firstNode;
        }
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (!hasNext()) {
                throw new NoSuchElementException("已经迭代完了");
            }
            Item i = current.value;
            current = current.next;
            return i;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<Integer>();
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);

        deque.addLast(27);

        for (int i = 0; i < 4; i++) {
            StdOut.println(deque.n + "" + deque.removeLast());
        }


    }

}
