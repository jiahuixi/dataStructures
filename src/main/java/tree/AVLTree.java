package tree;

import java.util.ArrayList;

/**
 * @author jiahuixi
 * @date 2019/2/28 14:30
 */
public class AVLTree<K extends Comparable<K>,V> {
    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public int height;
        public Node(K key,V value){
            this.key =key;
            this.value = value;
            height = 0;
            right =null;
            left = null;
        }
    }
    private Node root;
    private int size;
    public AVLTree(){
        root = null;
        size =0;
    }
    public int getSize(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isBST(){
        ArrayList<K> array = new ArrayList<>();
        inOrder(root , array);
        for(int i = 1 ; i< array.size() ; i++){
            if(array.get(i-1).compareTo(array.get(i))>0){
                return false;
            }
        }
        return true;
    }
    public boolean isBalanced(Node node){
        if(node == null){
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if(Math.abs(balanceFactor)>1){
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
    }

    private int getBalanceFactor(Node node) {
        if (node ==null){
            return 0 ;
        }
        return getHeight(node.left)-getHeight(node.right);
    }

    private int getHeight(Node node) {
        if(node == null){
            return 0 ;
        }
        return node.height;
    }
    // 对节点y进行向右旋转操作，返回旋转后新的根节点x
    //        y                              x
    //       / \                           /   \
    //      x   T4     向右旋转 (y)        z     y
    //     / \       - - - - - - - ->    / \   / \
    //    z   T3                       T1  T2 T3 T4
    //   / \
    // T1   T2
    private Node rightRotate(Node y){

        Node x = y.left;
        Node T3 = x.right;

        x.right = y;
        y.left = T3;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height =  Math.max(getHeight(x.left), getHeight(x.right)) + 1;

        return x;
    }
    // 对节点y进行向左旋转操作，返回旋转后新的根节点x
    //    y                             x
    //  /  \                          /   \
    // T1   x      向左旋转 (y)       y     z
    //     / \   - - - - - - - ->   / \   / \
    //   T2  z                     T1 T2 T3 T4
    //      / \
    //     T3 T4
    private Node leftRotate(Node y){
        Node x = y.right;
        Node T2 = x.left;
        x.left = y;
        y.right = T2;
        y.height = Math.max(getHeight(y.left),getHeight(y.right))+1;
        x.height =  Math.max(getHeight(x.left), getHeight(x.right)) + 1;
        return x;
    }

    public void add(K key , V value){
        root = add(root ,key,value);
    }

    private Node add(Node node , K key , V value){
        if(node ==null){
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left = add(node.left,key,value);
        }
        else if(key.compareTo(node.key)>0){
            node.right = add(node.right,key,value);
        }else{
            node.value = value;
        }
        node.height = Math.max(getHeight(node.left), getHeight(node.right))+1;

        int balanceFactor = getBalanceFactor(node);
        if(balanceFactor>1 && getBalanceFactor(node.left) >=0){
            return rightRotate(node);
        }
        if(balanceFactor<-1 && getBalanceFactor(node.left) <=0){
            return leftRotate(node);
        }
        if(balanceFactor>1 && getBalanceFactor(node.left)<0){
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if(balanceFactor<-1 && getBalanceFactor(node.left)>0){
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }


    public boolean contains(K key){
        return getNode(root,key)!= null;
    }

    private Node getNode(Node node, K key) {
        if(node == null ){
            return null;
        }
        if(key.equals(node.key)){
            return node;
        }
        if(key.compareTo(node.key)<0){
            return getNode(node.left,key);
        }
        else {
            return getNode(node.left,key);
        }
    }
    public V get(K key){
        Node node = getNode(root,key);
        return node ==null ? null : node.value;
    }
    public void set(K key , V newValue){
        Node node = getNode(root,key);
        if(node == null)
            throw new IllegalArgumentException(key + " doesn't exist!");
        node.value = newValue;
    }
    
    public V remove(K key){
        Node node = getNode(root, key);
        if(node !=null){
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    private Node minimum(Node node){
        if(node.left==null){
            return node;
        }
        return minimum(node.left);
    }
    private Node remove(Node node, K key) {
        if(node == null){
            return  null;
        }
        Node retNode;
        if(key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            retNode = node;
        }else  if(key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
            retNode = node;
        }else{
            if(node.left == null){
                Node righeNode = node.right;
                node.right = null;
                size --;
                retNode = righeNode;
            }
            if(node.right == null){
                Node leftNode = node.left;
                node.left = null;
                size --;
                retNode = leftNode;
            }
            else {
                Node successor = minimum(node.right);
                successor.right = remove(node.right,successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }
        if(retNode == null){
            return null;
        }
        retNode.height = 1 + Math.max(getHeight(retNode.left), getHeight(retNode.right));
        // 计算平衡因子
        int balanceFactor = getBalanceFactor(retNode);
        if(balanceFactor > 1 && getBalanceFactor(retNode.left) >= 0){
            return rightRotate(retNode);
        }
        if(balanceFactor > 1 &&getBalanceFactor(retNode.left) < 0){
            retNode.left = leftRotate(retNode.left);
            return rightRotate(retNode);
        }
        if(balanceFactor<-1 && getBalanceFactor(retNode.right) >= 0){
            retNode.right = rightRotate(retNode.right);
            return leftRotate(retNode);
        }
        if(balanceFactor<-1 && getBalanceFactor(retNode.right) < 0){
           return leftRotate(retNode);
        }
        return retNode;
    }


    private void inOrder(Node root, ArrayList<K> array) {
        if(root ==null ){
            return ;
        }
        inOrder(root.left,array);
        array.add(root.key);
        inOrder(root.right,array);
    }
}
