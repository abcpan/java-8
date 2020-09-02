package com.abc.test.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author abcpan
 * @version 1.0
 * @date 2019/12/28 16:02
 */
public class Test1 {
  public static void main(String[] args){
    //testPrimitive();
    //textRange();
    //genTernary();
    //buildStream();
    //genFib();
    //printDistinct();
    //testMap();
    //testFindAny();
    testReduce();
  }
  public static void testPrimitive(){
    int[] numbers = {1,2,3,4,5,3,8,9,10};
    IntStream integerStream  = Arrays.stream(numbers);
    int sum = integerStream.parallel().sum();
    System.out.println(sum);
  }

  /**
   * 生成范围偶数
   */
  public static void textRange(){
    IntStream stream = IntStream.rangeClosed(1,100);
    IntStream eventStream = stream.filter(num->num % 2 ==0);
    System.out.println(eventStream.count());
  }

  public static void genTernary(){
    Stream<double[]> stream = IntStream.rangeClosed(1,100).boxed()
        .flatMap(a->IntStream.rangeClosed(1,100)
            .mapToObj(b->new double[]{a,b,Math.sqrt(a*a+b*b)})).filter(t->t[2]%1==0);
    stream.forEach(item-> System.out.println(item[2]));
  }
  public static void buildStream(){
    Stream<String> strStream = Stream.of("java8","lambda","in","action");
    strStream.map(String::toUpperCase).forEach(System.out::println);
  }
  
  /**
   * 产生斐波拉契
   */
  public static void genFib(){
    Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]}).limit(10).map(t->t[0]).forEach(System.out::println);
  }
  
  /**
   * 测试distinct
   */
  public static void printDistinct() {
    List<Integer> numbers = Arrays.asList(1, 2, 3, 1, 3, 3, 4, 5, 9, 8, 8);
    numbers.stream().filter(i -> i % 2 == 0).distinct().forEach(System.out::println);
  }
  
  public static void testMap() {
    List<String> list = Arrays.asList("Modern", "Java", "In", "Action");
    List<Map<String, Integer>> strLenMap = list.stream().map((str) -> {
      Map<String, Integer> map = new HashMap<>();
      map.put(str, str.length());
      return map;
    }).collect(Collectors.toList());
  
    System.out.println(strLenMap);
  }
  
  /**
   * 测试findAny or findFirst
   */
  public static void testFindAny() {
    List<String> list = Arrays.asList("Modern", "Java", "In", "Action");
    Optional<String> ret = list.stream().filter(str -> str.length() > 100).findAny();
    ret.ifPresent(result -> {
      System.out.println(result);
    });
    String target = ret.orElse("未知");
    System.out.println(target);
  }
  
  public static void testReduce() {
    List<String> list = Arrays.asList("Modern", "Java", "In", "Action");
    StringBuilder stb = new StringBuilder();
    String ret = list.stream().reduce("", (a, b) ->  a + b);
    System.out.println(ret);
  }
}
