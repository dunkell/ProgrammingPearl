package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * 如果认真考虑了习题3，你将会面对生成小于n且没有重复的k个整数的问题。
 * 最简单的方法就是使用前k个正整数。
 * 这个极端的数据集合将不会明显地改变位图方法的运行时间，但是可能会歪曲系统排序的运行时间。
 * 如何生成位于0至n-1之间的k个不同的随机顺序的随机整数？尽量使你的程序简短且高效。
 */

public class exercise4 {
    public static void main(String[] args) {

        List<Integer> list = createData(20,10);

        System.out.println(list);
        Collections.sort(list);
        System.out.println(list);

    }

    public static List<Integer> createData(int n,int k){
        List<Integer> list = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        for(int i = 0; i < k; i++){
            Collections.swap(list,i, random.nextInt(n-i) + i);
        }

        return list.subList(0,k);
    }



}
