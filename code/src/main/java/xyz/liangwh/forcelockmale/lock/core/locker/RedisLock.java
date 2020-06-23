package xyz.liangwh.forcelockmale.lock.core.locker;

import xyz.liangwh.forcelockmale.lock.core.capacity.DistributedLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

public class RedisLock implements DistributedLock {


    @Override
    public void lock() {

    }

    @Override
    public void unlock() {

    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }
}
