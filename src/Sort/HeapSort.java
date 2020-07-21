package Sort;

/**
 * 堆排序
 * 基于比较的排序
 */
public class HeapSort<T extends Comparable<T>> extends Sort<T> {
    private int heapSize;   // 记录堆中还有多少数据

    @Override
    protected void sort() {
        // 原地建堆
        heapSize = array.length;
        for (int i = (heapSize >> 1) - 1; i >= 0; i--) {
            siftDown(i);
        }

        while (heapSize > 1) {  // O(nlogn)
            // 交换堆顶元素和尾部元素
            swap(0, --heapSize);
            // 对0位置进行siftDown（恢复堆的性质）
            siftDown(0);
        }
    }

    /**
     * 下滤
     */
    private void siftDown(int index){
        T element = array[index];
        int half = heapSize >> 1;
        while (index < half){
            int childIndex = (index << 1) + 1;
            T child = array[childIndex];

            int rightIndex = childIndex + 1;
            if(rightIndex < heapSize && cmp(array[rightIndex], child) > 0)
                child = array[childIndex = rightIndex];

            if (cmp(element, child) >= 0)
                break;

            array[index] = child;
            index = childIndex;
        }
        array[index] = element;
    }

}