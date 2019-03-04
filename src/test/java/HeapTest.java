import maxHeap.MaxHeap;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Random;

/**
 * @author jiahuixi
 * @date 2019/3/4 16:28
 */
public class HeapTest {
    @Before
    public void before() throws Exception {
        System.out.println("测试开始");
    }
    @After
    public void after() throws Exception {
        System.out.println("测试结束");
    }
    @Test
    private static double testHeap(ArrayList<Integer> testData, boolean isHeapify){

        long startTime = System.nanoTime();

        MaxHeap<Integer> maxHeap;
        if(isHeapify)
            maxHeap = new MaxHeap<>(testData);
        else{
            maxHeap = new MaxHeap<>();
            for(int num: testData)
                maxHeap.add(num);
        }

        int[] arr = new int[testData.size()];
        for(int i = 0 ; i < testData.size() ; i ++)
            arr[i] = maxHeap.extractMax();

        for(int i = 1 ; i < testData.size() ; i ++)
            if(arr[i-1] < arr[i])
                throw new IllegalArgumentException("Error");
        System.out.println("Test MaxHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
    public static void main(String[] args) {

        int n = 10000000;

        Random random = new Random();
        ArrayList<Integer> testData = new ArrayList(n);
        for(int i = 0 ; i < testData.size() ; i ++){
            testData.set(i,random.nextInt(Integer.MAX_VALUE)) ;
        }
        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }
}
