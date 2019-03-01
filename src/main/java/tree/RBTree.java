package tree;

/**
 * @author jiahuixi
 * @date 2019/3/1 10:16
 */
public class RBTree<K extends Comparable<K> , V> {
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node{
        public K key;
        public V value;
        public Node left,right;
        public boolean color;

        public Node(K key , V value){
            this.key = key ;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }
    private Node root;
    private int size;
    public RBTree(){
        root = null;
        size = 0;
     }
     public int getSize(){
        return size;
     }
     public boolean isEmpty(){
         return size == 0;
     }
     private boolean isRed(Node node){
         if(node == null){
             return BLACK;
         }
         return node.color;
     }
    //   node                     x
    //  /   \     左旋转         /  \
    // T1   x   --------->   node   T3
    //     / \              /   \
    //    T2 T3            T1   T2
    private Node leftRotate(Node node){
         Node x = node.right;
         Node T2 = x.left;

         x.left = node;
         node.right = T2;

         x.color = node.color;
         node.color = RED;

         return x;
    }
    //     node                   x
    //    /   \     右旋转       /  \
    //   x    T2   ------->   y   node
    //  / \                       /  \
    // y  T1                     T1  T2
    private Node rightRotate(Node node){
        Node x = node.left;

        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;

        return x;
    }
    private void flipColors(Node node){
        node.color = RED;
        node.left.color =BLACK;
        node.right.color = RED;
    }
    public void add(K key ,V value ){
        root = add(root,key,value);
        root.color = BLACK;
    }

    private Node add(Node node, K key, V value) {
        if(node == null){
            size ++;
            return new Node(key,value);
        }
        if(key.compareTo(node.key)<0){
            node.left = add(node.left,key,value);
        } else if(key.compareTo(node.key)>0){
            node.right = add(node.right,key,value);
        }else{
            node.value = value;
        }
        //     黑
        //    /   \
        //   红    T2
        //  / \
        //    红
        if(isRed(node.right) && !isRed(node.left)){
            node = leftRotate(node);
        }
        //     黑
        //    /   \
        //   红    T2
        //  /
        // 红
        if(isRed(node.left) && isRed((node.left.left))){
            node = rightRotate(node);
        }
        //   黑
        //  / \
        // 红  红
        if(isRed(node.left) && isRed(node.right)){
            flipColors(node);
        }
        return node;

    }


}
