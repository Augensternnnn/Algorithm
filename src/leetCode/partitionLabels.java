package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class partitionLabels {

    public static void main(String[] args) {
        List<Integer> list = partitionLabels("qiejxqfnqceocmy");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static List<Integer> partitionLabels(String S) {
        if(S.length() == 0 || S == null)
            return null;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < S.length();) {
            int index = S.lastIndexOf(S.charAt(i));
            int tmp = index;
            if(index == -1) {
                res.add(1);
                i++;
            }else {
                for (int j = i+1; j < tmp; j++) {
                    if(S.lastIndexOf(S.charAt(j)) < tmp)
                        continue;
                    else
                        tmp = S.lastIndexOf(S.charAt(j));
                }
                res.add(tmp - i + 1);
                i = tmp + 1;
            }
        }
        return res;
    }
}
