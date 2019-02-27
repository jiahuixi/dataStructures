
import array.JArrayQueue;
import array.LoopQueue;
import jinterface.Queue;
import jinterface.Stack;
import linkedList.JLinkedList;
import linkedList.LinkedListQueue;
import linkedList.LinkedListStack;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jiahuixi
 * @date 2019/2/27 11:21
 */
public class LinkedListTest {
    @Before
    public void before() throws Exception {
        System.out.println("测试开始");
    }
    @After
    public void after() throws Exception {
        System.out.println("测试结束");
    }
    @Test
    public void linkedListTest(){
        JLinkedList<Integer> jLinkedList = new JLinkedList();
        for(int i = 0 ; i < 10 ; i++){
            jLinkedList.add(i,i);
        }
        System.out.println("jLinkedList"+jLinkedList.toString());
        jLinkedList.remove(5);
        System.out.println("jLinkedList"+jLinkedList.toString());
    }
    @Test
    public void stackTest(){
        Stack stack = new LinkedListStack<>();
        for(int i = 0 ; i < 10 ; i++){
            stack.push(i);
        }
        System.out.println("jArrayStack"+stack.toString());
        stack.pop();
        System.out.println("jArrayStack"+stack.toString());

    }
    @Test
    public void queueTest(){
        Queue queue = new LinkedListQueue();
        for(int i = 0 ; i < 10 ; i++){
            queue.enqueue(i);
        }
        System.out.println("loopQueue"+queue.toString());
        queue.dequeue();
        System.out.println("loopQueue"+queue.toString());
        queue.enqueue(100);
        System.out.println("loopQueue"+queue.toString());

    }
}
