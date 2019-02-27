/**
 * created by Zheng Jiateng on 2019/2/26.
 */

/**
 * 旋转数组的最小数字: 二分查找的思想，若mid处于发生了旋转的区域之内，则array[mid]<array[0],要找拼接点则要右移
 * 若array[mid]>array[0],则找旋转点要左移
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class MinNumberInRotateArray__ {
    public int minNumberInRotateArray(int [] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
            // 拼接点左右相等只有一种可能就是整个数组的元素都相等
        } else if (array[0] == array[array.length - 1]) {
            return array[0];
        } else {
            int lo = 0;
            int hi = array.length - 1;
            while (lo <= hi) {
                int mid = (lo + hi) / 2;
                if (array[mid] > array[0]) {
                    // 左>右说明右是最小值
                    // 这个条件不能带等于 比如12345677 -> 4567 7123 拼接点左右相等只有一种可能就是整个数组的元素都相等
                    if (array[mid] > array[mid + 1]) {
                        return array[mid + 1];
                    } else {
                        lo = mid + 1;
                    }
                } else if (array[mid] <= array[0]) {
                    hi = mid - 1;
                }
            }
            return 0;
        }
    }
}
