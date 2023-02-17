package chapter1;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 运行时效率是设计目标的一个重要组成部分，所得到的程序需要足够高效。
 * 在你自己的系统上实现位图排序并度量其运行时间。
 * 该时间与系统排序的运行时间以及习题1中排序的运行时间相比如何？
 * 假设n为10 000 000，且输入文件包含1 000 000个整数。
 */

public class exercise3 {

    public static void main(String[] args) {
        exercise2 bitvector = new exercise2();
        List<Integer> list = exercise4.createData(bitvector.N,bitvector.K);
        int[] result = new int[bitvector.N+1];
        int[] a = new int[bitvector.N+1];

        long stime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            bitvector.setBit(list.get(i));
        }

        for (int i = 0; i < bitvector.N; i++) {
            if(bitvector.testBit(i)){
                result[i] = i;
            }
        }
        long etime = System.currentTimeMillis();
        System.out.println("位图执行时长:" + (etime - stime) + "毫秒");

        stime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            a[list.get(i)] = list.get(i);
        }
        etime = System.currentTimeMillis();
        System.out.printf("直接排序执行时长：%d 毫秒.", (etime - stime));


        stime = System.currentTimeMillis();
        //底层使用的是Arrays.sort,双轴快排
        Collections.sort(list);
        etime = System.currentTimeMillis();
        System.out.printf("collections执行时长：%d 毫秒.", (etime - stime));

        int[] newresult = new int[result.length];
        int j = 0;
        for (int i : result) {
            if(i != 0){
                newresult[j] = i;
                j++;
            }
        }

        System.out.println(Arrays.equals(Arrays.copyOf(newresult,j), list.stream().mapToInt(i -> i).toArray()));


    }


}
