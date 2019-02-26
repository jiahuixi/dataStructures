import Array.JArrayQueue;
import Array.LoopQueue;
import Jinterface.Queue;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author jiahuixi
 * @date 2019/2/26 15:23
 */
public class ArrayTest {
    @Before
    public void before() throws Exception {
        System.out.println("测试开始");
    }
    @After
    public void after() throws Exception {
        System.out.println("测试结束");
    }
    @Test
    public void queueTest(){
        Queue jArrayQueue = new JArrayQueue();
        Queue loopQueue = new LoopQueue();
        for(int i = 0 ; i < 10 ; i++){
            jArrayQueue.enqueue(i);
            loopQueue.enqueue(i);
        }
        System.out.println("jArrayQueue"+jArrayQueue.toString());
        System.out.println("loopQueue"+loopQueue.toString());
        jArrayQueue.dequeue();
        loopQueue.dequeue();
        System.out.println("jArrayQueue"+jArrayQueue.toString());
        System.out.println("loopQueue"+loopQueue.toString());

    }
}
