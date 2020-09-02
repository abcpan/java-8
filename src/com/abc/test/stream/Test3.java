package com.abc.test.stream;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class Test3 {
  public static void main(String[] args) {
    //test1();
    //test2();
    //test3();
    test4();
    test5();
  }
  
  /**
   *测试
   */
  public static void test1() {
    long uniqueLetterNum = 0;
    try(Stream<String> lines = Files.lines(Paths.get("line.text"), Charset.defaultCharset())){
      uniqueLetterNum = lines.flatMap(line -> {
        System.out.println(line);
        return Arrays.stream(line.split(" "));
      
      }).distinct().count();
      System.out.println(uniqueLetterNum);
    }catch (Exception o) {
      o.printStackTrace();
    }
  }
  
  /**
   * 测试
   */
  public static void test2() {
    long result = LongStream.rangeClosed(1, 1000).parallel().reduce(0L, (prev, cur) -> prev + cur);
    System.out.println(result);
  }
  
  /**
   * 测试java9 的新api 方法
   */
  public static void test3() {
    // 创建的列表是不可以进行修改的
    List<String> list = List.of("潘桂成", "李足春", "郑称心");
    // list.add("南京");
    System.out.println(list);
    //  创建集合
    Set<String> set = Set.of("南京", "无锡", "镇江");
    System.out.println(set);
    
    Map<String, Integer> map = Map.ofEntries(Map.entry("pan", 3), Map.entry("超级", 5));
    System.out.println(map);
  }
  
  /**
   * 测试remoteIf
   */
  public static void test4() {
    // 创建小型不可变的集合
    List<String> list = List.of("潘桂成", "李足春", "郑称心", "王陶");
    List<String> temp = new ArrayList<>(list);
    temp.removeIf((name) -> name.length() == 2);
    System.out.println(temp );
  }
  
  /**
   * 测试迭代
   */
  public static void test5() {
    Map<String, String> map = Map.of("age", "15", "name", "abc");
    map.forEach((k,v)-> {
      System.out.println(k + " --->" + v);
    });
    // 删除一个键值对
    Map<String, Integer> movieMap = new HashMap<>();
    movieMap.put("James Bond", 20);
    movieMap.put("Matrix", 15);
    movieMap.put("Harry Potter", 34);
    // 删除符合条件的键值对
    movieMap.entrySet().removeIf(entry -> entry.getKey().equals("Matrix"));
    movieMap.remove("pan");
    Map<String, String>  cMap = new ConcurrentHashMap(movieMap);
  }
}
