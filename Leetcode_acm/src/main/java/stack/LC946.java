package stack;

import java.util.*;

public class LC946 {

    // 1. 你的核心算法逻辑 (通常在 ACM 模式中我们会把它设为 static，方便 main 函数直接调用)
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        List<Integer> queue = new ArrayList<>();
        int j = 0;
        for(int i = 0; i < pushed.length; i++){
            int top = pushed[i];

            int queueTop = queue.size() > 0 ? queue.get(queue.size()-1) : -1;
            if(top == popped[j]){
                j++;
                if(j == popped.length){
                    return true;
                }
            } else {
                queue.add(top);
            }
            while(queueTop == popped[j]){
                j++;
                queue.remove(queue.size()-1);
                queueTop = queue.size() > 0 ? queue.get(queue.size()-1) : -1;
                if(j == popped.length){
                    return true;
                }
            }
        }
        return false;
    }

    // 2. ACM 模式的输入输出处理
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 假设我们在控制台输入两行数据，例如从 LeetCode 测试用例直接复制下来的：
        // 第一行输入: [1,2,3,4,5]
        // 第二行输入: [4,5,3,2,1]

        while (scanner.hasNextLine()) {
            String line1 = scanner.nextLine().trim();
            if (line1.isEmpty()) break; // 遇到空行结束程序
            String line2 = scanner.nextLine().trim();

            // --- 数据解析部分 (核心难点) ---
            int[] pushed = parseArray(line1);
            int[] popped = parseArray(line2);

            // --- 调用算法并输出结果 ---
            boolean result = validateStackSequences(pushed, popped);
            System.out.println(result);
        }

        scanner.close();
    }

    // 3. 辅助方法：将形如 "[1,2,3,4,5]" 的字符串解析为 int[] 数组
    private static int[] parseArray(String s) {
        // 掐头去尾，去掉 '[' 和 ']'
        s = s.substring(1, s.length() - 1).trim();

        // 处理空数组 "[]" 的边界情况
        if (s.isEmpty()) {
            return new int[0];
        }

        // 按逗号分割字符串
        String[] parts = s.split(",");
        int[] arr = new int[parts.length];

        // 将字符串转换为整数
        for (int i = 0; i < parts.length; i++) {
            arr[i] = Integer.parseInt(parts[i].trim());
        }
        return arr;
    }
}