package unionFind;

import jinterface.UF;

/**
 * @author jiahuixi
 * @date 2019/3/4 14:13
 */
public class UnionFind2 implements UF{
    private int[] parent;

    @Override
    public int getSize() {
        return parent.length;
    }
    public UnionFind2(int size){
        parent = new int[size];
        for(int i = 0 ; i < size ; i++){
            parent[i] = i ;
        }
    }

    private int find(int p){
        if(p < 0 || p >= parent.length)
            throw new IllegalArgumentException("p is out of bound.");
        while(p != parent[p]){
            p = parent[p];
        }
        return p ;
        }
    @Override
    public boolean isConnected(int p, int q) {
            return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {

        int pRoot = find(p);
        int qRoot = find(q);

        if( pRoot == qRoot )
            return;

        parent[pRoot] = qRoot;
    }
}
