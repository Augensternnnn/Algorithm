package Sort;

/**
 * 归并排序
 * 基于比较的排序
 */
public class MergeSort<T extends Comparable<T>> extends Sort<T> {
    private T[] leftArray;

    @Override
    protected void sort() {
        leftArray = (T[]) new Comparable[array.length >> 1];
        sort(0, array.length);
    }

    /**
     * 对 [begin, end) 范围的数据进行归并排序
     */
    private void sort(int begin, int end) {
        // 至少要有2个元素
        if(end - begin < 2) // 元素数量 < 2
            return;
        int mid =  (begin + end) >> 1;
        sort(begin, mid);
        sort(mid, end);
        merge(begin , mid ,end);
    }

    /**
     * 将 [begin, mid) 和 [mid, end) 范围的序列合并成一个有序序列
     */
    private void merge(int begin, int mid, int end) {
        int li = 0, le = mid - begin;
        int ri = mid, re = end;
        int ai = begin;
        // 备份左边是数组
        for (int i = li; i < le; i++) {
            leftArray[i] = array[begin + i];
        }
        while (li < le) {   // 左边还没有结束
            if(ri < re && cmp(array[ri], leftArray[li]) < 0)
                array[ai++] = array[ri++];
            else
                array[ai++] = leftArray[li++];
        }
    }
}
