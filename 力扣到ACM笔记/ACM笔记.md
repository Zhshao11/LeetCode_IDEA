# 栈
## LC946
- 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
- 输出：true
- 使用Scanner进行输入：
```angular2html
Scanner scanner = new Scanner(System.in);
while (scanner.hasNextLine()) {
String line1 = scanner.nextLine().trim();进行输入
...
}
```
- `.trim()`用于扫描字符串的开头和结尾，删除空格、制表符、换行符等不可见的控制字符
- 将字符串转为数组：去掉前后[]，以,进行分隔，把值存进数组
## LC503
- 在parseInt代码中，需要先处理完String之后，再new int[]，长度等于处理完之后的数组长度