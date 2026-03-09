package stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LC901 {
    public static void main(String[] args) {
        StockSpanner stockSpanner = new StockSpanner();
        System.out.println(stockSpanner.next(100)); // 返回 1
        System.out.println(stockSpanner.next(80));  // 返回 1
        System.out.println(stockSpanner.next(60));  // 返回 1
        System.out.println(stockSpanner.next(70));  // 返回 2
        System.out.println(stockSpanner.next(60));  // 返回 1
        System.out.println(stockSpanner.next(75));  // 返回 4 ，因为截至今天的最后 4 个股价 (包括今天的股价 75) 都小于或等于今天的股价。
        System.out.println(stockSpanner.next(85));
    }
    static class StockSpanner {
        private Deque<int[]> prices = new ArrayDeque<>();
        private int curDay = -1;
        public StockSpanner() {
            prices.push(new int[]{-1,Integer.MAX_VALUE});
        }
        public int next(int price) {
            while(!prices.isEmpty()&&price>=prices.peek()[1]){
                prices.pop();
            }
            curDay++;
            int ans =  curDay-prices.peek()[0];
            prices.push(new int[]{curDay,price});
            return ans;
        }
    }
}
