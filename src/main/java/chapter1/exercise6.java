package chapter1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * 如果那个程序员说的不是每个整数最多出现一次，而是每个整数最多出现10次，你又如何建议他呢？
 * 你的解决方案如何随着可用存储空间总量的变化而变化？
 */

//用4位记录整数出现的次数
    //计算一趟算法编写

public class exercise6 {

    static final int N = 100;
    static final int K = 10;
    static final int MASK = 0xF;

    static int[] arr = new int[(N >> 3) +1];

    public static void main(String[] args) {
        List<Integer> list = createData(N,K);

        //数据写入arr
        for(Integer l:list){
            setBit(l);
        }

        //检查结果是否正确
        int n = 0;
        for (int i = 0; i < N; i++) {
            int m = 0;
            for (Integer integer : list) {
                if ( integer == i){
                    m++;
                }
            }
            if(m != getBit(i)){
                n = 10086;
                break;
            }
        }
        System.out.println(n);

    }


    //添加数据
    private static void setBit(int i) {
        int offset =(i & MASK)*4;
        arr[i >> 3] += (1 << offset);
    }


    //返回数据数量
    private static int getBit(int i){
        //偏移量为模8乘4
        int offset = (i & MASK)*4;
        return ((arr[i >> 3] & (0b1111 << offset) >> offset));
    }

    /**
     * 生成数据
     * @param n
     * @param k
     * @return
     */
    public static List<Integer> createData(int n, int k){
        List<Integer> list = new ArrayList<>();
        Random random = new Random();
        //生成顺序数据
        for (int i = 0; i < n; i++) {
            list.add(random.nextInt(11));
        }
        //打乱排序
        for(int i = 0; i < k; i++){
            //Collections.swap(list,i, random.nextInt(n-i) + i);
            int j = i + random.nextInt(k - i);
            int temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }

        return list.subList(0,k);
    }


}
