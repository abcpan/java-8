package com.abc.test.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author abcpan
 * @version 1.0
 * @date 2019/12/26 17:42
 */
public class Test2 {
  public static void main(String[] args){
    List<String> list = Arrays.asList("zhonghuarenmingognheguowansui,shijierenmindat uanjiewnasui","hua","ren","min","gong","he","guo");
    List<String> newList =  map(list,item->item.toUpperCase());
     forEach(newList,item->{
      System.out.println(item);
    });
  }
  public static <T> void forEach(List<T> list, Predicate<T> predicate){
    for(T item:list){
      predicate.accept(item);
    }
  }

  public static <T,R> List<R> map(List<T> list,Function<T,R> function){
    List<R> newList = new ArrayList<>();
    for(T t:list){
      newList.add(function.apply(t));
    }
    return newList;
  }

  interface Predicate<T>{
    void accept(T t);
  }
  interface Function<T,R>{
    R apply(T data);
  }
}
