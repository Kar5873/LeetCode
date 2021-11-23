package com.leetcode.utils;

/**
 * @author kar
 * @create 2021-11-20 12:40
 */
public class CountTime {
    private static final ThreadLocal<Long> TIME_THREADLOCAL = ThreadLocal.withInitial(System::currentTimeMillis);
    public static final void start(){
        TIME_THREADLOCAL.set(System.currentTimeMillis());
    }
    public static final long stop(){
        return System.currentTimeMillis() - TIME_THREADLOCAL.get();
    }
}
