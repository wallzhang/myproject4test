package com.wall.myproject4test.java.zzw.thread.extend;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

/**
* @Description: mapReduce jdk1.7后提供单机版本的
* @Author: zhang.zw
* @Date: 2020/11/29
*/
public class ForkJoinDemo extends RecursiveTask<Integer>{

        //计算1...10的累加
        //分割的阈值: 每个任务的大小 2
        private final int THREHOLD = 2;
        private int start;
        private int end;

        public ForkJoinDemo(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        protected Integer compute() {
            int sum = 0;
            boolean canCompute = (end - start) <= THREHOLD;
            if (canCompute) { //不能分割
                System.out.println("start:" + start + "-end:" + end);
                for (int i = start; i <= end; i++) {
                    sum += i;
                }
            } else {
                int middle = (start + end) / 2;
                ForkJoinDemo left = new ForkJoinDemo(start, middle);
                ForkJoinDemo right = new ForkJoinDemo(middle + 1, end);
                left.fork();
                right.fork();
                int leftResult = left.join();
                int rightResult = right.join();
                sum = leftResult + rightResult;
            }
            return sum;
        }

        public static void main(String[] args) throws ExecutionException, InterruptedException {
            ForkJoinPool forkJoinPool = new ForkJoinPool();
            ForkJoinDemo forkJoinDemo = new ForkJoinDemo(1, 10);
            Future<Integer> result = forkJoinPool.submit(forkJoinDemo);
            System.out.println(result.get());
        }

}
