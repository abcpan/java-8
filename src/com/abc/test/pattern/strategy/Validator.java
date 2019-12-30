package com.abc.test.pattern.strategy;

/**
 * @version v1.0
 * @ProjectName: java-8
 * @ClassName: Validator
 * @Description:
 * @Author: abcpan
 * @Date: 2019/12/29 22:57
 */
public class Validator {
    private ValidationStrategy validationStrategy;

    public Validator(ValidationStrategy validationStrategy) {
        this.validationStrategy = validationStrategy;
    }
    public boolean validate(String s){
        return this.validationStrategy.execute(s);
    }
}
