package com.abc.test.collection;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @author abcpan
 * @version 1.0
 * @date 2019/12/28 17:32
 */
public class Test1 {
  public static void main(String[] args){
    Optional<String> optional = Optional.of("pan");
    String result = optional.orElse("");
    System.out.println(result);
  }
}
