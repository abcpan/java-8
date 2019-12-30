package com.abc.test.pattern.watcher;

/**
 * @version v1.0
 * @ProjectName: java-8
 * @ClassName: NYTimes
 * @Description:
 * @Author: abcpan
 * @Date: 2019/12/29 23:09
 */
public class NYTimes implements Observer {
    @Override
    public void update(String msg) {
        if("美国".equals(msg)){
            System.out.println("纽约时报收到通知");
        }
    }
}
