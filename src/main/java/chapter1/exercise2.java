package chapter1;

/**
 * 如何使用位逻辑运算（如与、或、移位）来实现位向量？
 */

public class exercise2 {

    private static final int BITSPERWORD = 32;
    public static final int N = 100000000;
    public static final int K = 10000000;

    public static final int MASK = 0x1F;
    public static final int SHIFT = 5;

    static int[] arr = new int[1 + N / BITSPERWORD];

    //设置位值
    public static void setBit(int i){
        arr[i >> SHIFT] |= (1 << (i  & MASK));
    }

    //清除位值
    public static void clearBit(int i){
         arr[i >> SHIFT] &= (~(1 << (i & MASK)));
    }

    //是否存在i
    public static boolean testBit(int i){

        if((arr[i >> SHIFT] & (1 << (i & MASK))) != 0){
            return true;
        }
        return  false;
    };

}
