package Sort;

/**
 * 插入排序
 * 基于比较的排序
 */
public class InsertionSort<T extends Comparable<T>> extends Sort<T> {
    /*protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            T v = array[begin];
            int insertIndex = search(begin);
            //将 [insertIndex, begin) 范围内的元素往右边挪动一个单位
            for (int i = begin; i > insertIndex; i--) {
                array[i] = array[i - 1];
            }
            array[insertIndex] = v;
        }
    }*/

    @Override
    protected void sort() {
        for (int begin = 1; begin < array.length; begin++) {
            insert(begin, search(begin));
        }
    }

    /**
     * 将 source 位置的元素插入到 dest 位置
     */
    private void insert(int source, int dest) {
        T v = array[source];
        for (int i = source; i > dest; i--) {
            array[i] = array[i - 1];
        }
        array[dest] = v;
    }

    /**
     * 利用二分搜索，找到 index 位置元素的待插入位置
     * 已经排好序的数组的区间范围是 [0, index)
     */
    private int search(int index) {
        int begin = 0, end = index;
        while (begin < end) {
            int mid = (begin + end) >> 1;
            if(cmp(array[index], array[mid]) < 0)
                end = mid;
            else
                begin = mid + 1;
        }
        return begin;
    }
}

//class InsertionSort_2<T extends Comparable<T>> extends Sort<T> {
//    @Override
//    protected void sort() {
//        for (int begin = 1; begin < array.length; begin++) {
//            int cur = begin;
//            T v = array[cur];
//            while (cur > 0 && cmp(v, array[cur - 1]) < 0){
//                array[cur] = array[cur - 1];
//                cur--;
//            }
//            array[cur] = v;
//        }
//    }
//}

//class InsertionSort_1<T extends Comparable<T>> extends Sort<T> {
//    @Override
//    protected void sort() {
//        for (int begin = 1; begin < array.length; begin++) {
//            int cur = begin;
//            while (cur > 0 && cmp(cur, cur - 1) < 0) {
//                swap(cur, cur - 1);
//                cur--;
//            }
//        }
//    }
//}