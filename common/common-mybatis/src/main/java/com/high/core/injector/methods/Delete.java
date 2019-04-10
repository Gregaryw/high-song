package com.high.core.injector.methods;

import com.high.core.enums.SqlMethod;
import com.high.core.injector.AbstractMethod;
import com.high.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 根据 entity 条件删除记录
 *
 * @author hubin
 * @since 2018-04-06
 */
public class Delete extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod sqlMethod = SqlMethod.DELETE;
        String sql = String.format(sqlMethod.getSql(), tableInfo.getTableName(), this.sqlWhereEntityWrapper(true, tableInfo));
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addDeleteMappedStatement(mapperClass, sqlMethod.getMethod(), sqlSource);
    }
}
