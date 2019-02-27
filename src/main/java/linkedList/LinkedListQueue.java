package linkedList;

import jinterface.Queue;

/**
 * @author jiahuixi
 * @date 2019/2/27 13:51
 */
public class LinkedListQueue<E> implements Queue<E> {
    private JLinkedList<E> jLinkedList;

    public LinkedListQueue(){
        jLinkedList = new JLinkedList<E>();
    }
    @Override
    public int getSize() {
        return jLinkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return jLinkedList.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        jLinkedList.addLast(e);
    }

    @Override
    public E dequeue() {
        return jLinkedList.removeFirst();
    }

    @Override
    public E getFront() {
        return jLinkedList.getFirst();
    }

    @Override
    public String toString() {
        return "LinkedListQueue{" +
                "jLinkedList=" + jLinkedList +
                '}';
    }
}
