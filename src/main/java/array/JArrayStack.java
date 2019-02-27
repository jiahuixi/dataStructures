package array;

import jinterface.Stack;

/**
 * @author jiahuixi
 * @date 2019/2/26 16:15
 */
public class JArrayStack<E> implements Stack<E> {
    JArray<E> jArray;

    public JArrayStack () {
         jArray = new JArray<>();
    }
    public JArrayStack (int capacity) {
        jArray = new JArray<>(capacity);
    }
    @Override
    public int getSize() {
        return jArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return jArray.isEmpty();
    }

    @Override
    public void push(E e) {
        jArray.addFirst(e);
    }

    @Override
    public E pop() {
        return jArray.removeFirst();
    }

    @Override
    public E peek() {
        return jArray.getFirst();
    }
    @Override
    public String toString(){
        StringBuffer sb = new StringBuffer();
        sb.append("Stack ");
        sb.append("[");
        for(int i = 0 ; i<jArray.getSize() ; i++){
            sb.append(jArray.get(i));
            if(i !=jArray.getSize() - 1){
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
