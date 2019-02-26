package Array;

import Jinterface.Queue;

/**
 * @author jiahuixi
 * @date 2019/2/26 15:17
 */
public class JArrayQueue<E> implements Queue<E>{
    private JArray<E> jArray;

    public JArrayQueue(int capacity){
        jArray = new JArray<>(capacity);
    }

    public JArrayQueue(){
        jArray = new JArray<>();
    }

    public int getSize() {
        return jArray.getSize();
    }

    public boolean isEmpty() {
        return jArray.isEmpty();
    }

    public void enqueue(E e) {
        jArray.addLast(e);
    }

    public E dequeue() {
        return jArray.removeFirst();
    }

    public E getFront() {
        return jArray.getFirst();
    }
    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Queue;front[");
        for(int i = 0 ; i < jArray.getSize() ; i ++){
            sb.append(jArray.get(i));
            if(i != jArray.getSize() - 1)
                sb.append(", ");
        }
        sb.append("] tail");
        return sb.toString();
    }
}
