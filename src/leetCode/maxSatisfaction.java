package leetCode;

import java.util.Arrays;

public class maxSatisfaction {

    public static void main(String[] args) {
        int[] arr = {4,3,2};
        System.out.println(maxSatisfaction(arr));
    }
    public static int maxSatisfaction(int[] satisfaction) {
        int len = satisfaction.length;
        Arrays.sort(satisfaction);
        if(satisfaction[len-1]<0)
            return 0;
        int max = 0;
        max = maxSum(satisfaction,0,len);
        for(int i = 1; i < len; i++){
            int maxSum = maxSum(satisfaction,i,len);
            max = Math.max(max,maxSum);
        }
        return max;
    }
    static int maxSum(int[] satisfaction,int start,int end){
        int sum = 0;
        int l = 1;
        for(int i = start; i < end; i++){
            sum += satisfaction[i] * l++;
        }
        return sum;
    }
}
