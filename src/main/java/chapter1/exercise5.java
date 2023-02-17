package chapter1;


import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 那个程序员说他有1 MB的可用存储空间，但是我们概要描述的代码需要1.25 MB的空间。
 * 他可以不费力气地索取到额外的空间。
 * 如果1 MB空间是严格的边界，你会推荐如何处理呢？
 * 你的算法的运行时间又是多少？
 *
 */

//使用两趟排序的思想
    //1.先对前一半的数据进行排序
    //2.对后一半的数据进行排序

public class exercise5 {
    static final int N = 1000000;
    static final int K = 100000;
    static final int MASK = 0x1F;

    static int[] arr = new int[(N >> 6)+1];

    public static void main(String[] args) {
        System.out.println((N >> 6) + 1);
        //生成数据
        List<Integer> list = exercise4.createData(N, K);
        int[] result = new int[N+1];

        long stime = System.currentTimeMillis();
        //第一遍排序N>>1之前数字[,)
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) < (N >> 1)){
                setBit(list.get(i));
            }
            //存在数据0则给result置-1
            if(list.get(i) == 0){
                result[0] = -1;
            }
        }
        //将数据存储到result
        for (int i = 1; i < (N >> 1); i++) {
            if(testBit(i)){
                result[i] = i;
            }
        }


        //第二遍排序值大于N>>1
        //清空arr中数据
        arr = new int[(N >> 6) + 1];
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) >= (N >> 1)){
                setBit(list.get(i) - (N >> 1));
            }
        }
        //将数据存储到result
        for (int i = 0; i <= (N >> 1); i++) {
            if(testBit(i)){
                result[i+(N >> 1)] = i + (N >> 1);
            }
        }

        long etime = System.currentTimeMillis();
        System.out.println("执行时长:" + (etime - stime) + "毫秒");

        //检查结果
        //排序list
        Collections.sort(list);
        int[] newresult = new int[result.length];
        int j = 0;
        //将result中的0元素去除
        for (int i : result) {
            if(i != 0){
                newresult[j] = i;
                j++;
            }
        }
        //原数据中有0则把0从-1置回
        if(newresult[0] == -1){
            newresult[0] = 0;
        }
        result = Arrays.copyOf(newresult,j);

        //将list转为int[]
        int[] newlist = list.stream().mapToInt(i -> i).toArray();
        System.out.println(result.length + "+++++" + newlist.length);
        //比较两个结果是否一致
        System.out.println(Arrays.equals(result, newlist));

//        //打印结果
//        for (int i = 0; i <result.length; i++) {
//            System.out.println("kkk:" + result[i] + "    mmm :" + newlist[i]);
//        }

    }

    private static void setBit(int i) {
            arr[i >> 5] |= (1 << (i & MASK));
    }

    private static boolean testBit(int i){
        return (arr[i >> 5] & (1 << (i & MASK))) != 0;
    }

}
