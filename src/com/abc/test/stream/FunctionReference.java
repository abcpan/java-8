package com.abc.test.stream;

import org.w3c.dom.ls.LSOutput;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

/**
 * @author abcpan
 * @version 1.0
 * @date 2019/12/26 11:02
 */
public class FunctionReference {
  public static void main(String[] args){
   // functionReference();
    //parallelStreamTest();
    testCollectors();
    testParallelStreamPerformance();
  }
  public static void functionReference(){
    File[] hiddenFiles = new File(".").listFiles(File::isHidden);
    for(File file:hiddenFiles){
      System.out.println(file.getName());
    }
  }

  /**
   * 测试普通流
   */
  public static void parallelStreamTest(){
    //定义颜色map
    HashMap<Integer,String> colorMap = new HashMap<>();
    colorMap.put(0,"red");
    colorMap.put(1,"orange");
    colorMap.put(2,"blue");
    colorMap.put(3,"green");

    //定义重量map
    HashMap<Integer,Integer> weightMap = new HashMap<>();
    weightMap.put(0,300);
    weightMap.put(1,250);
    weightMap.put(2,100);
    weightMap.put(3,50);
    //创建5个苹果
    List<Apple> apples = new ArrayList<>();
    for(int i = 0;i<4;i++){
      Apple apple = new Apple();
      apple.setColor(colorMap.get(i));
      apple.setWeight(weightMap.get(i));
      apples.add(apple);
    }
    //普通流
    apples.stream().forEach(apple-> System.out.println(apple.getColor()));
    System.out.println("======================================>");
    apples.parallelStream().forEach(apple-> System.out.println(apple.getColor()));
  }
  public static void testCollectors(){
    List<Dish> dishes = new ArrayList<>();
    for(int i =0;i<20;i++){
      Dish dish = new Dish();
      dish.setType("meate");
      dish.setCalories(200*i);
      dishes.add(dish);
    }
    for(int i =0;i<20;i++){
      Dish dish = new Dish();
      dish.setType("vegetable");
      dish.setCalories(100*i);
      dishes.add(dish);
    }

    dishes.parallelStream().collect(Collectors.groupingBy(dish->dish.getType(),toList())).forEach((key,value)-> System.out.println(value.size()));
  }

  public static void testParallelStreamPerformance(){
    long result = LongStream.range(1,1001).parallel().reduce(0,(a,b)->a+b);
    System.out.println(result);
  }
  static class Apple{
    private String color;
    private Integer weight;

    public Apple() {
    }

    public String getColor() {
      return color;
    }

    public void setColor(String color) {
      this.color = color;
    }

    public int getWeight() {
      return weight;
    }

    public void setWeight(Integer weight) {
      this.weight = weight;
    }
  }


}
