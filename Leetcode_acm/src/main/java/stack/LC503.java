package stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;
import java.util.stream.IntStream;

public class LC503 {
    public static int[] nextGreaterElements(int[] nums){
        Deque<Integer> stack = new ArrayDeque<>();
//        int[] nums2 = IntStream.concat(Arrays.stream(nums), Arrays.stream(nums)).toArray();
        int[] ans = new int[nums.length];
        for(int i = 0;i<2*nums.length;i++){
            if(i<nums.length){
                ans[i] = -1;
            }
            int now = nums[i%nums.length];
            while(!stack.isEmpty()&&now>nums[stack.peek()]){
                int s = stack.pop();
                ans[s] = now;
            }
            if(i<nums.length){
                stack.push(i);
            }

        }
        return ans;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextLine()){
            String str1 = sc.nextLine().trim();
            int[] nums = parseInt(str1);
            if(str1.isEmpty()) break;
            System.out.println(Arrays.toString(nextGreaterElements(nums)));
        }
        sc.close();
    }
    public static int[] parseInt(String str){

        str = str.substring(1,str.length()-1).trim();
        if(str.isEmpty()) return new int[0];
        String[] strs = str.split(",");
        int[] ans = new int[strs.length];
        for(int i =0 ;i<strs.length;i++){
            ans[i] = Integer.parseInt(strs[i]);
        }
        return ans;
    }
}
