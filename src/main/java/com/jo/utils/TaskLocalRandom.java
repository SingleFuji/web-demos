package com.jo.utils;

import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * 并发随机数  需jdk1.7以上	
 * 
 * @author mango_jo
 *
 */
public class TaskLocalRandom implements Runnable {

	//实现类构造器，使用current()方法为当前线程初始化随机数生成器
    public TaskLocalRandom(){
        //该方法是一个静态方法，返回与当前线程相关关联的TaskLocalRandom对象，
        //所以可以使用这个对象生成随机数，如果调用该方法的线程还没有关联随机数对象，就会生成一个新的。
        ThreadLocalRandom.current();
    }
    /**
     * 在该方法中调用current()获取本地线程关联的随机数生成器，同时也调用了NextInt()方法并以数字10作为参数传入。、
     * 
     */
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        for(int i = 0;i < 10000;i++){
            try {
                TimeUnit.MILLISECONDS.sleep(1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            System.out.printf("%s: %d\n",name,ThreadLocalRandom.current().nextInt(100));
        }
    }
}
