package com.high.core.conditions;

import java.io.Serializable;

/**
 * copy mybatis_plus
 * SQL 片段接口
 */
@FunctionalInterface
public interface ISqlSegment extends Serializable {
    /**
     * SQL 片段
     */
    String getSqlSegment();
}
