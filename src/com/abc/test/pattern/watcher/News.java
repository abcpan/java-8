package com.abc.test.pattern.watcher;

import java.util.ArrayList;
import java.util.List;

/**
 * @version v1.0
 * @ProjectName: java-8
 * @ClassName: News
 * @Description:
 * @Author: abcpan
 * @Date: 2019/12/29 23:12
 */
public class News {
    private List<Observer> observers = new ArrayList<>();
    public  void addObserver(Observer observer){
        observers.add(observer);
    }
    public void notify(String msg){
        observers.forEach(observer->observer.update(msg));
    }

    public static void main(String[] args) {
        News news = new News();
        news.addObserver(new Guardian());
        news.addObserver(new NYTimes());
        news.notify("美国");
    }
}
