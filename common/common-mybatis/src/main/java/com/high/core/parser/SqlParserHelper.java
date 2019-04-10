package com.high.core.parser;

import com.high.annotation.SqlParser;
import com.high.core.toolkit.StringPool;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.reflection.MetaObject;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * SQL 解析辅助类
 *
 * @author hubin
 * @since 2018-07-22
 */
public class SqlParserHelper {

    public static final String DELEGATE_MAPPED_STATEMENT = "delegate.mappedStatement";
    /**
     * SQL 解析缓存
     */
    private static final Map<String, Boolean> SQL_PARSER_INFO_CACHE = new ConcurrentHashMap<>();


    /**
     * 初始化缓存 SqlParser 注解信息
     *
     * @param mapperClass Mapper Class
     */
    public synchronized static void initSqlParserInfoCache(Class<?> mapperClass) {
        Method[] methods = mapperClass.getDeclaredMethods();
        for (Method method : methods) {
            SqlParser sqlParser = method.getAnnotation(SqlParser.class);
            if (null != sqlParser) {
                String sid = mapperClass.getName() + StringPool.DOT + method.getName();
                SQL_PARSER_INFO_CACHE.put(sid, sqlParser.filter());
            }
        }
    }


    /**
     * 获取 SqlParser 注解信息
     *
     * @param metaObject 元数据对象
     */
    public static boolean getSqlParserInfo(MetaObject metaObject) {
        return SQL_PARSER_INFO_CACHE.getOrDefault(getMappedStatement(metaObject).getId(), false);
    }


    /**
     * 获取当前执行 MappedStatement
     *
     * @param metaObject 元对象
     */
    public static MappedStatement getMappedStatement(MetaObject metaObject) {
        return (MappedStatement) metaObject.getValue(DELEGATE_MAPPED_STATEMENT);
    }
}
