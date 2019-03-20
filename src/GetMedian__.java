/**
 * created by Zheng Jiateng on 2019/3/18.
 */


import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 数据流中的中位数: 用两个堆 一个最大堆 一个最小堆 如果数据已排序 则前一半数据在最大堆中 后一半在最小堆中
 * 最大堆的所有数据小于最小堆的所有数据 最大堆的顶和最小堆的顶的平均值就是中位数
 * 第奇数个数据入最大堆 第偶数个数据入最小堆
 *
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class GetMedian__ {

    PriorityQueue<Integer> maxPQ = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });
    PriorityQueue<Integer> minPQ = new PriorityQueue<>(); // 默认是小顶堆
    // 在这里定义了size这个int值后，它被初始化为0，就一直是0，没有变。
//    int size = maxPQ.size() + minPQ.size();


    public void Insert(Integer num) {
        int size = maxPQ.size() + minPQ.size();
        if (size == 0) { // 第一个
            maxPQ.offer(num);
        } else if (size % 2 == 1) { // 第偶数个 要插入小顶堆中 但要先插入大顶堆 在取大顶堆的最大元素插入小顶堆 保证小顶堆中所有元素大于大顶堆中所有元素
            maxPQ.offer(num);
            minPQ.offer(maxPQ.poll());
        } else if (size % 2 == 0) { // 第奇数个 要插入大顶堆中
            minPQ.offer(num);
            maxPQ.offer(minPQ.poll());
        }
    }

    public Double GetMedian() {
        int size = maxPQ.size() + minPQ.size();
        if (size == 0) {
            return null;
        }
        if (size % 2 == 1) {
            return (double) maxPQ.peek();
        }
        return (maxPQ.peek()+minPQ.peek()) / 2.0;
    }

    public static void main(String[] args) {
        GetMedian__ getMedian__ = new GetMedian__();
        getMedian__.Insert(5);
//        getMedian__.Insert(2);
//        getMedian__.Insert(3);
        System.out.println(getMedian__.GetMedian());
    }
}
