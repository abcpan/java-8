package com.abc.test.pattern.strategy;

public interface ValidationStrategy {
    /**
     * 执行验证接口
     * @param s
     * @return
     */
    boolean execute(String s);

}
