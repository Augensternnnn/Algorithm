package Sort;

/**
 * 计数排序
 * 不是基于比较的排序，典型的用空间换时间
 * 适合对一定范围内的整数进行排序
 */
public class CountingSort extends Sort<Integer> {
    @Override
    protected void sort() {
        int max = array[0]; // 最大值
        int min = array[0]; // 最小值
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max)
                max = array[i];
            if(array[i] < min)
                min = array[i];
        }

        int[] counts = new int[max - min + 1];  // 存储次数
        // 统计每个整数出现的次数
        for (int i = 0; i < array.length; i++)
            counts[array[i] - min]++;
        // 累加次数
        for (int i = 1; i < counts.length; i++)
            counts[i] += counts[i - 1];
        
        int[] output = new int[array.length];   // 存放排好序的数据
        // 从后往前遍历元素，将它放到有序数组中的合适位置
        for (int i = array.length - 1; i >= 0; i--)
            output[--counts[array[i] - min]] = array[i];

        // 覆盖array
        for (int i = 0; i < output.length; i++) {
            array[i] = output[i];
        }
    }
}

/*class CountingSort_1 extends Sort<Integer> {
    @Override
    protected void sort() {
        // 找出最大值
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if(array[i] > max)
                max = array[i];
        }
        // 开辟内存空间，存储每个整数出现的次数
        int[] counts = new int[max + 1];
        for (int i = 0; i < array.length; i++)
            counts[array[i]]++;
        // 根据整数出现次数，对整数进行排序
        int index = 0;
        for (int i = 0; i < counts.length; i++) {
            while (counts[i]-- > 0)
                array[index++] = i;
        }
    }
}*/
