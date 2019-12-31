package com.abc.test.stream;

import java.util.Arrays;
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
    buildStream();
    genFib();
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

  public static void genFib(){
    Stream.iterate(new int[]{0,1},t->new int[]{t[1],t[0]+t[1]}).limit(10).map(t->t[0]).forEach(System.out::println);
  }
}
