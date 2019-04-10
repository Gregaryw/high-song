package com.high.core.injector.methods;

import com.high.core.enums.SqlMethod;
import com.high.core.injector.AbstractMethod;
import com.high.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 根据columnMap 条件删除记录
 *
 * @author hubin
 * @since 2018-04-06
 */
public class DeleteByMap extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod sqlMethod = SqlMethod.DELETE_BY_MAP;
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sqlMethod.getSql(),
                tableInfo.getTableName(), this.sqlWhereByMap(tableInfo)), modelClass);
        return this.addDeleteMappedStatement(mapperClass, sqlMethod.getMethod(), sqlSource);
    }
}
