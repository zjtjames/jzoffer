/**
 * Created by Zheng Jiateng on 2019/3/19.
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 最小k个数：上一个类的better版 实现nlogm的时间复杂度 上一个类是nlogn
 *
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class GetLeastNumbersBetter {
    public ArrayList<Integer> GetLeastNumbers(int [] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (input.length < k || k == 0) {
            return result;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() { //大顶堆
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1); // 这一行是精髓 应熟记
            }
        });
        for (int i = 0; i < input.length; i++) {
            if (pq.size() < k) {
                pq.offer(input[i]);
            } else {
                if (pq.peek() > input[i]) {
                    pq.poll();
                    pq.offer(input[i]);
                }
            }
        }
        for (Integer item : pq) {
            result.add(item);
        }
        return result;
    }
}
