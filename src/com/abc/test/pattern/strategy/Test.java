package com.abc.test.pattern.strategy;

/**
 * @version v1.0
 * @ProjectName: java-8
 * @ClassName: Test
 * @Description:
 * @Author: abcpan
 * @Date: 2019/12/29 22:58
 */
public class Test {
    public static void main(String[] args){
        Validator validator = new Validator((s)->s.matches("[a-z]+"));
        boolean ret1 = validator.validate("bbbb");
        boolean ret2 = validator.validate("34343434");
        System.out.println(ret1 +"<===>" + ret2);
    }
}
