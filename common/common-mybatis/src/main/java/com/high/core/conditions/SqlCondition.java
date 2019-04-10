package com.high.core.conditions;

/**
 * @Author: HarlanW
 * @Date: 2019/4/8 0008
 * @Version: 1.0
 */
public class SqlCondition {
    public static final String EQUAL = "%s=#{%s}";
    public static final String NOT_EQUAL = "%s&lt;&gt;#{%s}";
    public static final String LIKE = "%s LIKE CONCAT('%%',#{%s},'%%')";
    public static final String LIKE_LEFT = "%s LIKE CONCAT('%%',#{%s})";
    public static final String LIKE_RIGHT = "%s LIKE CONCAT(#{%s},'%%')";

    public SqlCondition() {
    }
}
