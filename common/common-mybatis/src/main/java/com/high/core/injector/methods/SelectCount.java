package com.high.core.injector.methods;

import com.high.core.enums.SqlMethod;
import com.high.core.injector.AbstractMethod;
import com.high.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 查询满足条件总记录数
 *
 * @author hubin
 * @since 2018-04-08
 */
public class SelectCount extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod sqlMethod = SqlMethod.SELECT_COUNT;
        String sql = String.format(sqlMethod.getSql(), this.sqlCount(), tableInfo.getTableName(), this.sqlWhereEntityWrapper(true, tableInfo));
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addSelectMappedStatement(mapperClass, sqlMethod.getMethod(), sqlSource, Integer.class, null);
    }
}
