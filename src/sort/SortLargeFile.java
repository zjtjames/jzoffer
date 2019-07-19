/**
 * created by Zheng Jiateng on 2019/7/19.
 */
package sort;

import java.io.*;
import java.util.Arrays;

/**
 * 外部排序
 */
public class SortLargeFile {
    public static final int Max_ARRAY_SIZE = 100000;
    public static final int BUFFER_SIZE = 100000;

    public static void main(String[] args) throws Exception {
        //排序前文件largeFile.bat 和排序后文件sourceFile.bat
        sort("largeFile.bat","sourceFile.bat");

        //打印前100个排序后的数据
        displayFile("sourceFile.bat");
    }

    public static void sort(String sourceFile, String targetfile) throws Exception {

        int numberOfSegments = initialzeSegments(Max_ARRAY_SIZE, sourceFile, "f1.bat");
        //递归合并分段
        merge(numberOfSegments,Max_ARRAY_SIZE,"f1.bat","f2.bat","f3.bat",targetfile);
    }

    public static void merge(int numberOfSegment, int segmentSize, String f1, String f2, String f3, String targetFile) throws Exception {
        if (numberOfSegment > 1) {
            mergeOneStep(numberOfSegment,segmentSize,f1,f2,f3);
            merge((numberOfSegment+1)/2,segmentSize*2,f3,f1,f2,targetFile);
        }else{
            File sortFile = new File(targetFile);
            if (sortFile.exists()) sortFile.delete();
            new File(f1).renameTo(sortFile);
        }
    }

    public static void mergeOneStep(int numberOfSegment, int segmentSize, String f1, String f2, String f3)  throws  Exception{
        DataInputStream f1Input = new DataInputStream(new BufferedInputStream(new FileInputStream(f1), BUFFER_SIZE));
        DataOutputStream f2Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f2), BUFFER_SIZE));
        copyHalfFile(numberOfSegment, segmentSize, f1Input, f2Output);

        f2Output.close();

        DataInputStream f2Input = new DataInputStream(new BufferedInputStream(new FileInputStream(f2), BUFFER_SIZE));
        DataOutputStream f3Output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f3), BUFFER_SIZE));
        mergeSegment(numberOfSegment / 2, segmentSize, f1Input, f2Input, f3Output);

        f1Input.close();
        f2Input.close();
        f3Output.close();
    }

    /**
     * 打印排序好的前100个元素
     * @param fileName
     */
    public static void displayFile(String fileName) {
        try {
            DataInputStream input = new DataInputStream(new FileInputStream(fileName));
            for (int i = 0;i<100;i++)
                System.out.print(input.readInt()+" ");
            input.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    /**
     * 从文件中读取每个数据段，并对分段进行排序，然后将排序好序的分段存在一个新文件中；
     * 返回分段的个数
     *
     * @param segmentSize  划分的分组大小
     * @param originalFile
     * @param f1           临时文件
     * @return
     * @throws Exception
     */
    private static int initialzeSegments(int segmentSize, String originalFile, String f1) throws Exception {
        int[] list = new int[segmentSize];
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(originalFile)));
        //为临时文件创建一个数据输出流。缓冲流用于提高程序性能
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1)));

        int numberOfSegment = 0;
        while (input.available() > 0) {
            numberOfSegment++;
            //从文件读取一段数据到数组中
            int i = 0;
            for (; input.available() > 0 && i < segmentSize; i++) {
                list[i] = input.readInt();
            }

            Arrays.sort(list, 0, i); //排序

            for (int j = 0; j < i; j++) {
                output.writeInt(list[j]);  //将数组中的数据写入临时文件
            }
        }
        input.close();
        output.close();
        return numberOfSegment;
    }
    /**
     * 每步归并都将两个有序分段归并成一个新段。新段的元素是原来的两部，每次归并后分段的个数减少一半
     * 若一个分段太大，它将不能放入内存的数组中。
     * 该方法实现将f1中分段一半复制到f2中
     *
     * @param numberOfSegments
     * @param segmentSize
     * @param f1
     * @param f2
     */
    private static void copyHalfFile(int numberOfSegments, int segmentSize, DataInputStream f1, DataOutputStream f2) throws Exception {
        for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++) {
            f2.writeInt(f1.readInt());
        }
    }
    /**
     * 归并所有分段
     *
     * @param numbernOfSegments
     * @param segmentSize
     * @param f1
     * @param f2
     * @param f3
     */
    private static void mergeSegment(int numbernOfSegments, int segmentSize, DataInputStream f1, DataInputStream f2, DataOutputStream f3) throws Exception {
        for (int i = 0; i < numbernOfSegments; i++) {
            mergeTwoSegments(segmentSize, f1, f2, f3);
        }
        while (f1.available() > 0) {
            f3.writeInt(f1.readInt());
        }
    }

    /**
     * 合并两个分段
     *
     * @param segmentSize
     * @param f1
     * @param f2
     * @param f3
     * @throws Exception
     */
    private static void mergeTwoSegments(int segmentSize, DataInputStream f1, DataInputStream f2, DataOutputStream f3) throws Exception {
        int inputForm1 = f1.readInt();
        int inputForm2 = f2.readInt();
        int f1Count = 1;
        int f2Count = 1;
        while (true) {
            if (inputForm1 < inputForm2) {
                f3.writeInt(inputForm1);
                if (f1.available() == 0 || f1Count++ >= segmentSize) {
                    break;
                } else {
                    inputForm1 = f1.readInt();
                }
            } else {
                f3.writeInt(inputForm2);
                if (f2.available() == 0 || f2Count++ >= segmentSize) {
                    f3.writeInt(inputForm1);
                    break;
                } else {
                    inputForm2 = f2.readInt();
                }
            }
        }
        //将剩余的分段中的数据直接复制到f3
        while (f1.available() > 0 && f1Count++ < segmentSize) {
            f3.writeInt(f1.readInt());
        }
        while (f2.available() > 0 && f2Count++ < segmentSize) {
            f3.writeInt(f2.readInt());
        }
    }
}
