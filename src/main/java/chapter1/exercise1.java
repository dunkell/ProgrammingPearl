package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 如果不缺内存，如何使用一个具有库的语言来实现一种排序算法以表示和排序集合？
 */

public class exercise1 {
    public static void main(String[] args) {
        List<Integer> list = exercise4.createData(exercise2.n, exercise2.k);


        long stime = System.currentTimeMillis();

        //底层使用的是Arrays.sort,双轴快排
        Collections.sort(list);

        long etime = System.currentTimeMillis();
        System.out.printf("执行时长：%d 毫秒.", (etime - stime));
       // System.out.println(list);


    }

}
