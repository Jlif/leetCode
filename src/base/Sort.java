package base;

/**
 * 几种简单排序算法
 *
 * @author JiangChen
 * @date 2019/04/01
 */
public class Sort {

    /**
     * 冒泡排序
     *
     * @param a 待排序数组
     * @param n 数组长度
     */
    public static void bubbleSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; ++i) {
            // 提前退出冒泡循环的标志位
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j) {
                if (a[j] > a[j + 1]) { // 交换
                    int tmp = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = tmp;
                    flag = true;  // 表示有数据交换
                }
            }
            if (!flag) break;  // 没有数据交换，提前退出
        }
    }

    /**
     * 插入排序
     *
     * @param a 待排序数组
     * @param n 数组长度
     */
    public static void insertionSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 1; i < n; ++i) {
            int value = a[i];
            int j = i - 1;
            // 查找插入的位置
            for (; j >= 0; --j) {
                if (a[j] > value) {
                    a[j + 1] = a[j];  // 数据移动
                } else {
                    break;
                }
            }
            a[j + 1] = value; // 插入数据
        }
    }

    /**
     * 选择排序
     *
     * @param a 待排序数组
     * @param n 数组长度
     */
    public static void selectSort(int[] a, int n) {
        if (n <= 1) return;

        for (int i = 0; i < n; i++) {
            int min = i;
            for (int j = i; j < n; j++) {
                if (a[j] < a[min]) min = j;
            }
            if (min != i) {
                int temp = a[i];
                a[i] = a[min];
                a[min] = temp;
            }
        }
    }

}
