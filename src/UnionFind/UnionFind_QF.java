package UnionFind;

/**
 * Quick Find 实现
 */
public class UnionFind_QF extends UnionFind {
    public UnionFind_QF(int capacity) {
        super(capacity);
    }

    /**
     * 查找 v 所属的集合
     * @return 根节点（父节点就是根节点）
     */
    @Override
    public int find(int v) {
        rangeCheck(v);
        return parents[v];
    }

    /**
     * 将 v1 所在集合的所有元素，都嫁接到 v2 的父节点上
     */
    @Override
    public void union(int v1, int v2) {
        int p1 = find(v1);
        int p2 = find(v2);
        if(p1 == p2)
            return;
        for (int i = 0; i < parents.length; i++) {
            if(parents[i] == p1)
                parents[i] = p2;
        }
    }
}
