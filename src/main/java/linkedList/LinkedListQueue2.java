package linkedList;

import jinterface.Queue;

/**
 * @author jiahuixi
 * @date 2019/2/27 14:06
 */
public class LinkedListQueue2<E> implements Queue<E> {
    private class Node{
        public E e;
        public Node next;
        public Node(E e,Node next){
            this.e = e;
            this.next = next;
        }
        public Node(E e){
            this(e,null);
        }
        public Node(){
            this(null,null);
        }
        @Override
        public String toString(){
            return e.toString();
        }
    }
    Node tail,head;
    int size;
    public LinkedListQueue2(){
        tail = null;
        head = null;
        size = 0 ;
    }
    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size ==0;
    }

    @Override
    public void enqueue(E e) {
        if(tail==null){
            tail = new Node(e);
            head = tail;
        }else{
            tail.next = new Node(e);
            tail = tail.next;
        }
        size ++;
    }

    @Override
    public E dequeue() {
        if(isEmpty())
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");

        Node ret = head;
        head = head.next;
        ret.next = null;
        if(head == null){
            tail = null;
        }
        size--;
        return ret.e;
    }

    @Override
    public E getFront() {
        if(isEmpty())
            throw new IllegalArgumentException("Queue is empty.");
        return head.e;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append("Queue: front ");

        Node cur = head;
        while(cur != null) {
            res.append(cur + "->");
            cur = cur.next;
        }
        res.append("NULL tail");
        return res.toString();
    }
}
