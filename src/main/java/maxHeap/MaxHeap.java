package maxHeap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * @author jiahuixi
 * @date 2019/3/4 15:56
 */
public class MaxHeap<E extends Comparable <E>> {
   private  ArrayList<E> data;
   public MaxHeap(int capacity){
       data = new ArrayList(capacity);
   }
   public MaxHeap(){
       data = new ArrayList();
   }
    public MaxHeap(ArrayList<E> arrayList){
       data = arrayList;
        for (int i = arrayList.size() -1 ; i >= 0 ; i--) {
            siftDown(i);
        }
    }

   public int getSize(){
       return data.size();
   }
   public boolean isEmpty(){
       return data.isEmpty();
   }
   //返回父亲节点
   private int  parent(int index){
       if(index == 0)
           throw new IllegalArgumentException("index-0 doesn't have parent.");
        return (index -1)/2;
   }
   private int leftChild(int index){
       if(index == 0)
           throw new IllegalArgumentException("index-0 doesn't have parent.");
       return index * 2 + 1;
   }
    private int rightChild(int index){
        if(index == 0)
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        return index * 2 + 2;
    }

    public void add( E e){
        data.add(e);
        siftUp(data.size()-1);
    }
    private void siftUp(int k){
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k))<0){
            Collections.swap(data , k , parent(k));
            k = parent(k);
        }
    }
    private void siftDown(int k){
        while (leftChild(k)<data.size()){
            int j = leftChild(k);
            if(j+1 <data.size() && data.get(j).compareTo(data.get(j+1)) < 0){
                j = rightChild(k);
            }
            if(data.get(k).compareTo(data.get(j))>= 0){
                break;
            }
            Collections.swap(data,k,j);
            k = j;
        }
    }
    public E findMax(){
        if(data.size() == 0)
            throw new IllegalArgumentException("Can not findMax when heap is empty.");
         return data.get(0);
    }
    public E extractMax(){
        E ret = findMax();
        Collections.swap(data,0,data.size()-1);
        data.remove(data.size()-1);
        siftDown(0);
        return ret;
    }

}
