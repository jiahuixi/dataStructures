import Array.JArrayQueue;
import Array.JArrayStack;
import Array.LoopQueue;
import JLinkedList.JLinkedList;
import Jinterface.Queue;
import Jinterface.Stack;
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
        Stack jArrayStack = new JArrayStack();
        for(int i = 0 ; i < 10 ; i++){
            jArrayStack.push(i);

        }
        System.out.println("jArrayStack"+jArrayStack.toString());
        jArrayStack.pop();
        System.out.println("jArrayStack"+jArrayStack.toString());

    }
}
