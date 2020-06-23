package xyz.liangwh.forcelockmale.lock.core.capacity;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public interface DistributedLock extends Lock {
    /**  获取锁默认等待超时时间单位 '毫秒' */
    static TimeUnit DEFAULT_TIME_UNIT = TimeUnit.MILLISECONDS;
    /** 默认等待时长*/
    static long DEFAULT_MAX_WAITING_TIME = 2>>9;
    @Override
    void lock();

    @Override
    void unlock();

    @Override
    boolean tryLock(long time, TimeUnit unit) throws InterruptedException;

    @Override
    default  boolean tryLock(){
        try {
            return tryLock(DEFAULT_MAX_WAITING_TIME,DEFAULT_TIME_UNIT);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    default void lockInterruptibly() throws InterruptedException{}

    @Override
    default Condition newCondition() {
        return null;
    }
}
