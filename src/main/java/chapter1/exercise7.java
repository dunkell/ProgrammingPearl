package chapter1;


/**
 * [R.Weil]本书1.4节中描述的程序存在一些缺陷。
 * 首先是假定在输入中没有出现两次的整数。
 * 如果某个数出现超过一次的话，会发生什么？
 * +++多次的数据无法被记录，只记录一次的数据
 * 在这种情况下，如何修改程序来调用错误处理函数？
 * +++打印“存在重复数据”等信息并把重复数据返回
 * 当输入整数小于零或大于等于n时，又会发生什么？如果某个输入不是数值又如何？
 * +++会报地址溢出错误，不是数值则报类型错误
 * 在这些情况下，程序该如何处理？
 * +++程序应先对数据做输入类型检查和数的边界检查
 * 程序还应该包含哪些明智的检查？
 * +++
 * 描述一些用以测试程序的小型数据集合，并说明如何正确处理上述以及其他的不良情况。
 */

///* phase 1: initialize set to empty */
//for i = [0,n)
//        bit[i] = 0
//        /* phase 2: insert present elements into the set */
//        for each i in the input file
//        bit[i] = 1
//        /* phase 3: write sorted output */
//        for i = [0,n)
//        if bit[i] == 1
//        write i on the output f

public class exercise7 {
}
