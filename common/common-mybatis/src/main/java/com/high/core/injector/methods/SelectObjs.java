package com.high.core.injector.methods;

import com.high.core.enums.SqlMethod;
import com.high.core.injector.AbstractMethod;
import com.high.core.metadata.TableInfo;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 查询满足条件所有数据
 *
 * @author hubin
 * @since 2018-04-06
 */
public class SelectObjs extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod sqlMethod = SqlMethod.SELECT_OBJS;
        String sql = String.format(sqlMethod.getSql(), sqlSelectObjsColumns(tableInfo),
                tableInfo.getTableName(), this.sqlWhereEntityWrapper(true, tableInfo));
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, sql, modelClass);
        return this.addSelectMappedStatement(mapperClass, sqlMethod.getMethod(), sqlSource, Object.class, tableInfo);
    }
}
