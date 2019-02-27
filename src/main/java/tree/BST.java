package tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @author jiahuixi
 * @date 2019/2/27 14:37
 */
public class BST<E extends  Comparable<E>> {
    private class Node {
        public Node left,right;
        public E e;
        public Node(E e){
            this.e = e ;
            left = null;
            right = null;
        }
    }
    private Node root;
    private int size;
    public BST(){
        root = null;
        size = 0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void add(E e){
        root = add(root,e);
    }

    private Node add(Node node, E e) {
        if(node ==null){
            size++;
            return new Node(e);
        }
        if(e.compareTo(node.e)>0){
            node.right = add(node.right,e);
        }else if(e.compareTo(node.e)<0){
            node.left = add(node.left,e);
        }
        return node;
    }
    public boolean contains(E e){
        return  contains(root,e);
    }

    private boolean contains(Node node, E e) {
        if(node == null)
            return false;

        if (e.compareTo(node.e) == 0 ){
            return true;
        } else if(e.compareTo(node.e)>0){
           return contains(node.right,e);
        }
        else
            return contains(node.left,e);

    }
    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node ==null){
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR(){
        Deque<Node> stack = new LinkedList<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node cur = stack.pop();
            System.out.println(cur.e);
            if(cur.right!=null){
                stack.push(cur.right);
            }
            if(cur.left!=null){
                stack.push(cur.left);
            }
        }
    }
    public void inOrderNR(){
        Deque<Node> stack = new LinkedList<>();
        Node node =  root;
        while(node!=null || !stack.isEmpty()){
           while(node!=null){
               stack.push(node);
               node = node.left;
           }
           if(stack.size()>0){
               node = stack.pop();
               System.out.print(node.e+"----");
               node = node.right;
           }
        }
    }
    // 二分搜索树的中序遍历
    public void inOrder(){
        inOrder(root);
    }

    // 中序遍历以node为根的二分搜索树, 递归算法
    private void inOrder(Node node){

        if(node == null)
            return;

        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    // 二分搜索树的后序遍历
    public void postOrder(){
        postOrder(root);
    }

    // 后序遍历以node为根的二分搜索树, 递归算法
    private void postOrder(Node node){

        if(node == null)
            return;

        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }
    public  void levelOrder(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node cur = queue.remove();
            System.out.println(cur.e);
            if(cur.left!=null){
                queue.add(cur.left);
            }if(cur.right!=null){
                queue.add(cur.right);
            }
        }
    }
    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        generateBSTString(root, 0, res);
        return res.toString();
    }

    // 生成以node为根节点，深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if(node == null){
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e +"\n");
        generateBSTString(node.left, depth + 1, res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i ++)
            res.append("--");
        return res.toString();
    }
}
