package com.high.core;

import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.scripting.xmltags.XMLLanguageDriver;

/**
 * 继承 XMLLanguageDriver 重装构造函数，使用自定义 ParameterHandler
 *
 * @author hubin
 * @since 2016-03-11
 */
public class MybatisXMLLanguageDriver extends XMLLanguageDriver {

    @Override
    public MybatisDefaultParameterHandler createParameterHandler(MappedStatement mappedStatement, Object parameterObject,
                                                                 BoundSql boundSql) {
        /* 使用自定义 ParameterHandler */
        return new MybatisDefaultParameterHandler(mappedStatement, parameterObject, boundSql);
    }
}
