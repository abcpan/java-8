package com.abc.test.pattern.watcher;

/**
 * @version v1.0
 * @ProjectName: java-8
 * @ClassName: Observer
 * @Description:
 * @Author: abcpan
 * @Date: 2019/12/29 23:07
 */
public interface Observer {
    /**
     * 观察者更新信息
     * @param msg
     */
    void update(String msg);
}
