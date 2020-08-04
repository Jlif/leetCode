package middle;

/**
 * 实现  pow(x, n)  ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例  2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例  3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 * <p>
 * -100.0 <  x  < 100.0
 * n  是 32 位有符号整数，其数值范围是  [−231,  231  − 1] 。
 */
public class Powx_n {
    //方法一：直接使用内置函数
    public double myPow(double x, int n) {
        return Math.pow(x, n);
    }

    //方法二：暴力法
    public double myPow2(double x, int n) {
        double result = x;
        for (int i = 0; i < n; i++) {
            result = result * x;
        }
        return result;
    }

    //方法三：快速幂+递归
    public double myPow3(double x, int n) {
        return n >= 0 ? quickMul1(x, n) : 1 / quickMul1(x, -n);
    }

    public double quickMul1(double x, int n) {
        return 0;
    }
}
