package com.abc.test.time;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.TimeUnit;

/**
 * @version v1.0
 * @ProjectName: java-8
 * @ClassName: Test
 * @Description:
 * @Author: abcpan
 * @Date: 2019/12/30 23:29
 */
public class Test {
  public static void main(String[] args){
    testLocalDate();
  }
  public static void testLocalDate(){
    LocalDate localDate = LocalDate.of(2019,1,28);
    LocalDate newLocalDate = localDate.plus(5, ChronoUnit.MONTHS);
    System.out.println(newLocalDate);
    System.out.println(newLocalDate.format(DateTimeFormatter.ISO_LOCAL_DATE));
    System.out.println(localDate.format(DateTimeFormatter.ofPattern("yyyy~MM~dd")));
  }
}
