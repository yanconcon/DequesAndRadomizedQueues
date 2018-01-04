import java.util.NoSuchElementException;

/**
 * Created by Administrator on 2017/12/8 0008.
 */
public class MyQueue<Item> {
    private int leng;
    private Node<Item> first;
    private Node<Item> last;

    private static class Node<Item> {
        private Item value;
        private Node<Item> next;
    }
    public MyQueue() {
        first = null;
        last = null;
        leng = 0;
    }
    public boolean isEmpty() {
        return leng > 0;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException("添加非法");
        }
        Node<Item> oldlast = last;
        last = new Node<>();
        last.value = item;
        last.next = null;
        if (isEmpty()) first = last;
        else oldlast.next = last;
        leng++;
    }
    public Item dequeue() {
        if (leng == 0) {
            throw new NoSuchElementException("队列已清空");
        }
        Item item = first.value;
        first = first.next;
        leng--;
        if (isEmpty())
            last = null;
        return item;
    }
}
