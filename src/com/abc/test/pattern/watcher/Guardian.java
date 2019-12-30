package com.abc.test.pattern.watcher;

/**
 * @version v1.0
 * @ProjectName: java-8
 * @ClassName: Guardian
 * @Description:
 * @Author: abcpan
 * @Date: 2019/12/29 23:10
 */
public class Guardian implements Observer {
    @Override
    public void update(String msg) {
        if("英国".equals(msg)){
            System.out.println("英国卫报收到通知");
        }
    }
}
