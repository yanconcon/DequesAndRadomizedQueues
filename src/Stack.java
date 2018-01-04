import java.util.NoSuchElementException;

/**
 * Created by 聪聪 on 2017/12/8 0008.
 */
public class Stack<Item> {

    private int leng;
    private Node<Item> first;

    private static class Node<Item> {
        private Item value;
        private Node<Item> next;
    }
    public Stack() {
        first = null;
        leng = 0;
    }
    public void push(Item item) {
        if (item == null)
            throw new NullPointerException("没有值添加");
        Node<Item> oldFirst = first;
        first = new Node<Item>();
        first.value = item;
        first.next = oldFirst;
        leng++;
    }
    public Item pop() {
        if (leng < 0)
            throw new NoSuchElementException("pop 失败");
        Item i = first.value;
        first = first.next;
        leng--;
        return i;
    }
    public int size() {
        return leng;
    }
    public Item peek() {
        if (isEmpty()) throw new NoSuchElementException("Stack underflow");
        return first.value;
    }

    private boolean isEmpty() {
        return first == null;
    }

}
