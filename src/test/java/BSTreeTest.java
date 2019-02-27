import array.JArrayStack;
import jinterface.Stack;
import org.junit.Test;
import tree.BST;

/**
 * @author jiahuixi
 * @date 2019/2/27 15:38
 */
public class BSTreeTest {
    @Test
    public void treeTest(){
        BST bst = new BST();
        for(int i = 0 ; i < 10 ; i++){
            double num = Math.random();
            bst.add(num);

        }
        System.out.println("jArrayStack"+bst.toString());
        bst.inOrder();
        bst.inOrderNR();
    }
}
