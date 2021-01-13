package UnionFind.optimize;

/**
 * Quick Union 实现
 * 优化：基于rank + 路径分裂(Path Spliting)
 */
public class UnionFind_QU_R_PS extends UnionFind_QU_R {
    public UnionFind_QU_R_PS(int capacity) {
        super(capacity);
    }

    @Override
    public int find(int v) {
        rangeCheck(v);
        while (v != parents[v]){
            int parent = parents[v];
            parents[v] = parents[parent];
            v = parent;
        }
        return v;
    }
}
