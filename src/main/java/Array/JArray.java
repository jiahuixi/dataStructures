package Array;

import java.util.List;

/**
 * @author jiahuixi
 * @date 2019/2/26 14:07
 */
public class JArray<E>{
    private E[] data;
    private int size;

    /**
     * 初始化数组
     * @param capacity
     */
    public JArray(int capacity){
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 初始长度10
     */
    public JArray(){ this(10); }

    /**
     * 获取数组容量
     * @return
     */
    public int getCapacity(){return data.length;}

    /**
     * 获取数组元素格式
     * @return
     */
    public int getSize(){return size;}

    public boolean isEmpty(){return size == 0;}
    public void addFirst(E e){ add(0,e); }
    public void addLast(E e){ add(size,e); }
    public E getFirst(){return get(0);}
    public E getLast(){return get(size);}
    public E removeFirst(){return remove(0);}
    public E removeLast(){return remove(size);}

    public E remove(int index){
        if(index<0 || index > size ){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        E result = data[index];
        for(int i = index + 1 ; i < size ; i ++){
            data[i - 1] = data[i];
        }
        size --;
        data[size] = null;
        if(size ==data.length/4 && data.length /2 != 0){
            resize(data.length/2);
        }
        return result;
    }
    public void set(int index , E e){
        if(index<0 || index > size ){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        data[index] = e;
    }
    public boolean contains(E e){
        for(int i = 0 ; i < size ; i++){
            if(data[i].equals( e)){
                return true;
            }
        } return false;
    }
    public int find(E e){
        for(int i = 0 ; i < size ; i++){
            if(data[i].equals( e)){
                return i;
            }
        }
        return -1;
    }
public void removeElement(E e){
        int index = find(e);
        if(index!=-1){
            remove(index);
        }
}
    public void add (int index ,E e){
        if(index<0 || index > size ){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if(size == data.length){
            resize(2*data.length);
        }
        for(int i = size -1 ; i >=index ; i--){
            data[i+1]=data[i];
        }
        data[index] = e;
        size ++;
    }
    public E get(int index){
        if(index<0 || index > size ){
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        return data[index];
    }


    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for(int i = 0 ; i< size ; i++){
            newData[i] = data[i];
        }
        data = newData;
    }


}
