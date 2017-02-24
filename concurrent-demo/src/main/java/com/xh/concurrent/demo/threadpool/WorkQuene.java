package com.xh.concurrent.demo.threadpool;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Logger;

/**
 * <p/>
 * 线程池实现:
 * 1.创建一组线程
 * 2.创建工作队列
 * 3.启动线程池从工作队列获取任务
 * 4.执行任务
 * <p/>
 * risk:
 * 1.死锁：所有线程都阻塞在队列中的另一任务(需要另一任务的执行结果)，但没有空闲线程去执行这一任务
 * 2.note:lock unlock await signal
 * 3.thread leak:线程执行任务抛出异常时没有捕获，导致线程退出，最终无可用线程；线程一直等待用户输入(解决:等待有限时间)
 * 4.请求过载:限制请求数量(抛弃请求|拒绝请求)
 * 5.线程数:CPU+1；等待IO的任务，等待时间（WT）与服务时间（ST）之间的比例， N 个处理器的系统，需要设置大约 N*(1+WT/ST) 个线程来保持处理器得到充分利用。
 *
 * @author Xiong Hao
 */
public class WorkQuene {

    private static final Logger logger = Logger.getLogger("WorkQuene");

    private int threadSize;
    private Thread[] threadPool;//线程池
    private LinkedList<Runnable> quene;//工作队列
    ReentrantLock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public WorkQuene(int threadSize) {
        this.threadSize = threadSize;
        quene = new LinkedList();
        threadPool = new Thread[threadSize];
        for (int i = 0; i < threadSize; i++) {
            threadPool[i] = new WorkThread();
            threadPool[i].start();//启动线程
        }
    }

    public void execute(Runnable r) {
        logger.info("add new task");
        lock.lock();
        quene.push(r);
        condition.signal();
        lock.unlock();
    }

    private class WorkThread extends Thread {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                while (quene.isEmpty()) {
                    try {
                        condition.await();
                        logger.info("await task");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Runnable r = quene.pop();
                lock.unlock();
                try {
                    r.run();
                } catch (RuntimeException e) {
                    // If we don't catch RuntimeException,
                    // the pool could leak threads
                    // log....
                }
            }
        }
    }

    public static void main(String[] args) {
        WorkQuene workQuene = new WorkQuene(5);
        for (int i = 0; i < 5; i++) {
            workQuene.execute(() -> {
                try {
                    System.out.println("running===>" + Thread.currentThread().getId());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        logger.info("finish task");
    }
}
