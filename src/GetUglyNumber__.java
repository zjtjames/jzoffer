/**
 * Created by Zheng Jiateng on 2019/3/9.
 */

import java.util.ArrayList;
import static java.lang.Math.min;

/**
 * 丑数：时间换空间 把index之前所有的丑数都保存起来 这样时间复杂度是n
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 1 2 3 4 5 6 8 9 10 12 15
 * 1 2 3 2*2 5 2*3 2*2*2 3*3 2*5 2*2*3 3*5
 */
public class GetUglyNumber__ {
    public int getUglyNumber(int index) {
        if (index == 0) {
            return 0;
        }
        int[] ugly = new int[index];
        ugly[0] = 1;
        ArrayList<Integer> next2 = new ArrayList<>();
        ArrayList<Integer> next3 = new ArrayList<>();
        ArrayList<Integer> next5 = new ArrayList<>();
        for (int i = 1; i < index; i++) {
            next2.add(ugly[i - 1] * 2);
            next3.add(ugly[i - 1] * 3);
            next5.add(ugly[i - 1] * 5);
            int next = min(min(next2.get(0), next3.get(0)), next5.get(0));
            if (next == next2.get(0)) {
                next2.remove(0);
            }
            if (next == next3.get(0)) {
                next3.remove(0);
            }
            if (next == next5.get(0)) {
                next5.remove(0);
            }
            ugly[i] = next;
        }
        return ugly[index - 1];
    }

    public static void main(String[] args) {
        System.out.println(new GetUglyNumber__().getUglyNumber(11));
    }
}
