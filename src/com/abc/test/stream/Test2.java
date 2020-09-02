package com.abc.test.stream;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test2 {
  public static void main(String[] args) {
    testRange();
    createStream();
  }
  
  /**
   * 测试流特化
   */
  public static void testMapToInt() {
    List<Integer> list = Arrays.asList(1, 2, 3,4,5);
    int sum = list.stream().mapToInt((num) -> num.intValue()).sum();
    System.out.println(sum);
  }
  
  /**
   * 流装箱
   */
  public static void textBoxed() {
    List<Integer> list = Arrays.asList(1, 2, 3,4,5);
     IntStream intSteam = list.stream().mapToInt((num) -> num.intValue());
     Stream<Integer> stream = intSteam.boxed();
  }
  /**
   *  产生范围
   */

  public static void testRange() {
    IntStream evenNumbers = IntStream.rangeClosed(1, 100);
    long count = evenNumbers.filter((n) -> n % 2 == 0).count();
    System.out.println(count);
  }
  
  /**
   * 由值创建流
   */
  public static void createStream() {
    Stream<String> stream = Stream.of("java", "go", "c", "c++");
    stream.map(String::toUpperCase).forEach(System.out::println);
  }
}
