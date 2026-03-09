package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class LC496 {
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = find(nums2);
        int[] ans = new int[nums1.length];
        for(int i = 0; i < nums1.length; i++){
            for(int j = 0; j < nums2.length; j++){
                if(nums2[j] == nums1[i]){
                    ans[i] = res[j];
                    break;
                }
            }
        }
        return ans;
    }
    private static int[] find(int[] nums){
        int[] ans = new int[nums.length];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0;i<nums.length;i++){
            ans[i] = -1;
            int now = nums[i];
            while(!stack.isEmpty()&&now>nums[stack.peek()]){
                int s =  stack.pop();
                ans[s] = now;
            }
            stack.push(i);
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] nums1 = {1,3,5,2,4};
        int[] nums2 ={5,4,3,2,1};

        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
}
