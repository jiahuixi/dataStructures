package linkedList;

import jinterface.Stack;

/**
 * @author jiahuixi
 * @date 2019/2/27 11:39
 */
public class LinkedListStack<E> implements Stack<E> {
    private JLinkedList<E> jLinkedList;

    public LinkedListStack(){
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
    public void push(E e) {
        jLinkedList.addFirst(e);
    }

    @Override
    public E pop() {
        return jLinkedList.removeFirst();
    }

    @Override
    public E peek() {
        return jLinkedList.getFirst();
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Stack: top ");
        res.append(jLinkedList);
        return res.toString();
    }
}
