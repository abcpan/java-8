package com.abc.test.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test3 {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    //testCallable();
    //testConsumer();
    testFunction();
  }
  public static void TestRunnable() {
    Runnable func = () -> System.out.println("Hello World");
    Thread t = new Thread(func);
    t.start();
  }
  
  /**
   *
   * @throws ExecutionException
   * @throws InterruptedException
   */
  public static void testCallable() throws ExecutionException, InterruptedException {
    Callable<String> callTask  = () -> Thread.currentThread().getName();
    ExecutorService service = Executors.newCachedThreadPool();
    Future<String> future = service.submit(callTask);
    String name = future.get();
    System.out.println(name);
  }
  
  /**
   * 测试Consumer 接口
   */
  public static void testConsumer() {
    List<String> strs = Arrays.asList("潘", "桂", "成");
    Consumer<String> consumer = (String target) -> System.out.println(target);
    strs.forEach(consumer);
  }
  
  /**
   * 测试Function 接口
   */
  public static void testFunction() {
    Function<String, Integer> mapper = (String str) -> {
      if(str == null) {
        return 0;
      }
      return str.length();
    };
    List<String> names = Arrays.asList("特朗普", "奥巴马", "布什", "克林顿", "老布什", "卡特");
    List<Integer> nameLenList = names.stream().map(mapper).collect(Collectors.toList());
    nameLenList.forEach((len) -> {
      System.out.println(len);
    });
    
  }
}
