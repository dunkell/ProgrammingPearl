package chapter1;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何使用位逻辑运算（如与、或、移位）来实现位向量？
 */

public class exercise2 {

    private static final int BITSPERWORD = 32;
    public static final int n = 10000000;
    public static final int k = 1000000;

    public static void main(String[] args) {
        int bitVector = 0;

        int bitIndex = 6;



        bitVector = setBit(bitVector,bitIndex);
        bitVector = setBit(bitVector,3);
        System.out.println(bitVector);

        bitVector = clearBit(bitVector,bitIndex);
        System.out.println(bitVector);


    }

    //设置位值
    public static int setBit(int bitVector,int bitIndex){
        return bitVector | (1 << bitIndex);
    }

    //清除位值
    public static int clearBit(int bitVector,int bitIndex){
        return bitVector & ~(1 << bitIndex);
    }

    //输出结果
    public static List<Integer> printBit(int bitVector){
        List<Integer> list = new ArrayList<>();


        return list;
    };

}
