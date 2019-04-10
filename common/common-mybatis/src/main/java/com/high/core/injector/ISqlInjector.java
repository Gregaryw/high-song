package com.high.core.injector;

import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.session.Configuration;

/**
 * SQL 自动注入器接口
 *
 * @author hubin
 * @since 2016-07-24
 */
public interface ISqlInjector {

    /**
     * 检查SQL是否注入(已经注入过不再注入)
     *
     * @param builderAssistant mapper 信息
     * @param mapperClass      mapper 接口的 class 对象
     */
    void inspectInject(MapperBuilderAssistant builderAssistant, Class<?> mapperClass);

    /**
     * 注入 SqlRunner 相关
     *
     * @param configuration 全局配置
     * @see ISqlRunner
     */
    void injectSqlRunner(Configuration configuration);
}
