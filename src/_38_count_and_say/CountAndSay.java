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
        if (n == 0) {
            return "";
        }
        if (n == 1) {
            return "1";
        }
        String ans = "1";
        while (n > 1) {
            ans = sub(ans);
            n--;
        }
        return ans;
    }

    private String sub(String source) {
        String ans = "";
        char[] characters = source.toCharArray();
        char tmp = '0';
        int count = 1;
        for (int i = 0; i < characters.length; i++) {
            if (tmp == characters[i]) {
                count++;
            } else {
                ans = ans + count + Character.getNumericValue(tmp);
                count = 1;
            }
            tmp = characters[i];
        }
        ans = ans + count + Character.getNumericValue(tmp);
        return ans.substring(2);
    }

    public static void main(String[] args) {
        CountAndSay demo = new CountAndSay();
        System.out.println(demo.countAndSay(5));
    }


}
