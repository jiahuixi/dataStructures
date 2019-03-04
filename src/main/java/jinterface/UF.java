package jinterface;

/**
 * @author jiahuixi
 * @date 2019/3/4 11:44
 */
public interface UF {
    int getSize();
    boolean isConnected(int p , int q);
    void unionElements(int p ,int q);
}
