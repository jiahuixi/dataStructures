package unionFind;

import jinterface.UF;

/**
 * @author jiahuixi
 * @date 2019/3/4 11:53
 */
public class UnionFind1 implements UF {
    private int [] id;
    public UnionFind1(int size){
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }
    @Override
    public int getSize() {
        return id.length;
    }
    private int find(int p ){
        if(p < 0 || p >= id.length)
            throw new IllegalArgumentException("p is out of bound.");
        return id[p];
    }
    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pid = find(p);
        int qid = find(q);
        if(find(p) ==  find(q)){
            return ;
        }
        for (int i = 0; i < id.length; i++) {
                if(id[p] == pid){
                    pid = qid;
                }
        }
    }

    public static void main(String[] args) {
        String a = "hahahahahahah";

        char aa [] = a.toCharArray();
    }
}
