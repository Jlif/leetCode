package _38_count_and_say;

/**
 * 给定一个正整数 n ，输出外观数列的第 n 项。
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。
 * 你可以将其视作是由递归公式定义的数字字符串序列：
 * <p>
 * countAndSay(1) = "1"
 * countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-and-say
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author jiangchen
 * @date 2021/5/16
 */
public class CountAndSay {

    public String countAndSay(int n) {
        if (n == 0) return "";
        String ans = "1";//返回值
        String temp;    //临时的外观数组
        while (n > 0) {    //循环n-1次
            temp = "";//这里一定记得要初始化为空，否则就是直接加在上一次结果的后面。
            for (int i = 0; i < ans.length(); i++) {  //只要还没有遍历结束，继续循环
                int count = 1;
                char key = ans.charAt(i);
                while (ans.length() > i+1 && ans.charAt(i++) == key) {
                    count++;//这里注意：it要先自加1
                }
                temp += count;//将个数加在字符串后面
                temp += key;//将字符加在后面
            }
            ans = temp;//更新结果
            n--;
        }
        return ans;
    }

    public static void main(String[] args) {
        CountAndSay demo = new CountAndSay();
        System.out.println(demo.countAndSay(5));
    }


}
