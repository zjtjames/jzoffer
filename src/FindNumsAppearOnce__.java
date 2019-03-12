/**
 * created by Zheng Jiateng on 2019/3/11.
 */

import java.util.ArrayList;

/**
 * 数组中只出现一次的数字: 使用位运算中的异或的特性 x^x = 0  x^0=x 并且有交换律 结合律
 * 一个整型数组里除了两个数字之外，其他的数字都出现了偶数次。请写程序找出这两个只出现一次的数字。
 */
public class FindNumsAppearOnce__ {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int result = 0;
        for (int x : array) {
            result ^= x;
        }
        String result0_bi = Integer.toBinaryString(result);
        char[] chars = result0_bi.toCharArray();
        int len = chars.length;
        int flag = (int) Math.pow(2, len - 1);
        ArrayList<Integer> list0 = new ArrayList<>();
        ArrayList<Integer> list1 = new ArrayList<>();
        for (int x : array) {
            if ((flag & x) == 0) {
                list0.add(x);
            } else {
                list1.add(x);
            }
        }
        for (int x : list0) {
            num1[0] ^= x;
        }
        for (int x : list1) {
            num2[0] ^= x;
        }
    }

    public static void main(String[] args) {
//        System.out.println(Integer.toBinaryString(5));
        System.out.println(12 & 4);
    }
}
