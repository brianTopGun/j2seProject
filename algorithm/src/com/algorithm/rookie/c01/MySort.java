package com.algorithm.rookie.c01;

import com.sun.org.apache.bcel.internal.generic.SWAP;

import java.util.Arrays;

public class MySort {
    public static void print(int num){
        /**
         * 打印数字的二进制
         * int 32位 从最高位往最低位
         * 基本思路：
         * 从最高位开始与1与操作获取对于的二进制数，依次打印
         *
         */
        for (int i = 31;i>=0;i--){
            System.out.print((num &(1<<i))==0?"0":"1");
        }
        System.out.println();
    }

    /**
     * 题目一
     * 给定一个参数N，
     * 返回：  1! + 2! + 3! + 4! + … + N!   的结果（阶乘）
     *
     * 方法1：每个数字都从1开始连续相乘
     * 方法2：每个新的阶乘结果都是前一个阶乘数乘以自身
     *
     * 注意sum 采用long类型
     */

    public static long fun1(int num) {
        long sum = 0;
        for (int i = 1; i <= num; i++) {
            if (i == 1) {
                sum += i;
                continue;
            }
            int tmp = 1;
            for (int j = 1; j <= i; j++) {
                tmp *= j;
            }
            sum += tmp;
            tmp = 1;
        }
        return sum;
    }

    public static long fun2(int num){
        long sum = 0;
        long tmp =1;
        for (int i = 1; i <= num; i++) {
            tmp*=i;
            sum+=tmp;
        }
        return sum;
    }

    /***
     * 选择排序
     * 1、有一个待排序的数组A（以下简称A）。
     * 2、从A中找出最小的元素。
     * 3、将找到的最小元素跟数组A中第一个元素交换位置（如果最小元素就是第一个元素，则自己跟自己交换位置）
     * 4、然后，在剩下的4个数字中再找到最小的那个数字，跟第2个位置的数字交换
     *
     * 0~N-1上选出最小值放到0位置
     * 1~N-1上选出最小值放到1位置
     * 2~N-1上选出最小值放到2位置
     * 以此类推
     * [312]
     * 312-132
     * 32-123
     *
     *
     * @param num
     */

    public static void selectSort(int[] num){
        //1.判断边界
        if (num ==null & num.length<2){
            return;
        }
        //0-N
        //1-N
        //2-N
        //N-1 ~ N
        int N = num.length-1;
        for (int i = 0; i <= N; i++) {
                int minIndex = i;
            for (int j = i+1; j <=N ; j++) {
                minIndex = num[minIndex] > num[j]?j:minIndex;
            }
//            if(i!=minIndex) 不判断也没关系
                swap(num,i,minIndex);
        }
    }

    /***
     * 冒泡排序
     *
     * 0~N  上两两对比数值大与相邻右侧交换，比到N结束
     * 0~N-1上两两对比数值大与相邻右侧交换，比到N-1结束
     * 0-N-2上两两对比数值大与相邻右侧交换，比到N-2结束
     * 以此类推
     *  0~N-1
     *  0~N-2
     *  0~N-3
     *  0~end
     *
     *
     * @param num
     */
    public static void bubbleSort(int[] num){
        //1.判断边界
        if (num ==null & num.length<2){
            return;
        }
//        int N = num.length-1;
//        for (int i = N; i >0 ; i--) {
        for(int i = num.length-1;i>0;i--){
            for (int j = 0; j < i; j++) {
                if (num[j]>num[j+1]){
                    swap(num,j,j+1);
                }

            }
        }

        /***
         * 0 ~ n-1
         * 0 ~ n-2
         * 0 ~ n-3
         * 0 ~ end
         */
//        for (int end = num.length-1; end >=0 ; end--) {
//            for (int sec = 1; sec <=end ; sec++) {
//                if (num[sec-1]>num[sec])
//                    swap(num,sec-1,sec);
//            }
//        }

    }

    /***
     * 插入排序
     * 从第二个元素开始,
     * 0-1 有序，小的数在前面
     * 0-2 有序，小的数在前面
     *0-3 有序，小的数在前面
     * @param num
     */
    public static void insertSort(int[]num){
        //1.判断边界
        if (num ==null & num.length<2){
            return;
        }
        /**
         * 0 ~ N 小的数字往前插入
         * 1 ~N
         * 2 ~N
         * N-1 ~N
         *
         */
        int N = num.length;
        for (int end = 1; end < N ; end++) {
            for (int current = end; current >0 && num[current-1]>num[current] ; current--) {
                    swap(num,current,current-1);
            }
        }

//        for (int end = 0; end < N; end++) {
//            for (int pre = end-1; pre >=0 &&num[pre]>num[pre+1]; pre--) {
//                swap(num,pre,pre+1);
//            }
//        }

    }

    public static void swap(int[]num,int pre,int i){
        int tmp = num[i];
        num[i] = num[pre];
        num[pre] = tmp;
    }

    public static void main(String[] args) {
//        print(8);
        System.out.println(fun1(5));
        System.out.println(fun2(5));
        int[] nums = {2,5,8,6,7,1,9,4,2};
        System.out.println(Arrays.toString(nums));
        insertSort(nums);
        System.out.println(Arrays.toString(nums));


    }

}
