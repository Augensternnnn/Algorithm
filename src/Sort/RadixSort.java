package Sort;

/**
 * 基数排序【针对非负整数的】
 * 不是基于比较的排序，典型的用空间换时间
 * 适合用于整数排序，尤其非负整数
 */
public class RadixSort extends Sort<Integer> {
    @Override
    protected void sort() {
        int max = array[0]; // 最大值
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max)
                max = array[i];
        }
        for (int divider = 1; divider <= max; divider *= 10)
            // 对每一位进行计数排序
            countingSort(divider);
    }

    private void countingSort(int divider) {
        int[] counts = new int[10];  // 存储次数
        // 统计每个整数出现的次数
        for (int i = 0; i < array.length; i++)
            counts[array[i] / divider % 10]++;
        // 累加次数
        for (int i = 1; i < counts.length; i++)
            counts[i] += counts[i - 1];

        int[] output = new int[array.length];   // 存放排好序的数据
        // 从后往前遍历元素，将它放到有序数组中的合适位置
        for (int i = array.length - 1; i >= 0; i--)
            output[--counts[array[i] / divider % 10]] = array[i];

        // 覆盖array
        for (int i = 0; i < output.length; i++)
            array[i] = output[i];
    }
}
