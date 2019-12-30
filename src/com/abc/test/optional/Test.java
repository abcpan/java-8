package com.abc.test.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @version v1.0
 * @ProjectName: java-8
 * @ClassName: Test
 * @Description:
 * @Author: abcpan
 * @Date: 2019/12/30 18:14
 */
public class Test {
    public static void main(String[] args){
        test();
        mapTest();
    }
    public static void test(){
        String msg = "thinkpad computer is good";
        Optional<String> msgOption = Optional.ofNullable(msg);
        msgOption.ifPresent(value-> System.out.println(value));
    }

    public static void mapTest(){
        Map<String,String> map = new HashMap<>(20);
        map.put("name",null);
        String value = Optional.ofNullable(map.get("name")).orElse("unknown");
        System.out.println(value);
    }
}
