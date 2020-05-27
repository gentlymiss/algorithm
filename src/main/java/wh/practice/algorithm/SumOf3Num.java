package wh.practice.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wanghuan
 */
public class SumOf3Num {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return list;
        }
        int length = nums.length;
        Arrays.sort(nums);
        int l,r,sum;
        for (int i = 0; i < length; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            l = i+1;
            r = length -1;
            while (l < r) {
                sum = nums[i]+nums[l]+nums[r];
                if (sum == 0) {
                    list.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    while (l < r && nums[l] == nums[l+1]) {
                        l++;
                    }
                    while (l < r && nums[r] == nums[r-1]) {
                        r--;
                    }
                    l++;
                    r--;
                } else if (sum > 0) {
                    r--;
                } else {
                    l++;
                }
            }
        }
        return list;
    }
}
