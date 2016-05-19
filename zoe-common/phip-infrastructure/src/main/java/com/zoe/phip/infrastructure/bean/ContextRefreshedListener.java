package com.zoe.phip.infrastructure.bean;

/**
 * Bean环境初始化监听器。
 * Created by zengjiyang on 2016/1/27.
 */
public interface ContextRefreshedListener {
    /**
     * 获取执行顺序，值越小则越先执行。
     *
     * @return 执行顺序。
     */
    int getContextRefreshedSort();

    /**
     * 当Bean环境初始化完成时，自动执行此方法。
     */
    void onContextRefreshed();
}