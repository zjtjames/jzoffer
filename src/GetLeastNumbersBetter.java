/**
 * Created by Zheng Jiateng on 2019/3/19.
 */

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 最小k个数：上一个类的better版 实现nlogm的时间复杂度 上一个类是nlogn
 *
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbersBetter {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int i = 0;
        for (int j = 0; j < k; j++) {
            pq.add(input[i++]);
        }
        while (i < input.length) {
            if (input[i] >= pq.peek()) {
                continue;
            } else {
                pq.poll();
                pq.offer();
            }
        }
    }
}
