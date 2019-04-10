package com.high.core.injector.methods;

import com.high.core.enums.SqlMethod;
import com.high.core.injector.AbstractMethod;
import com.high.core.metadata.TableInfo;
import com.high.util.SqlScriptUtils;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlSource;

/**
 * 根据ID集合，批量查询数据
 *
 * @author hubin
 * @since 2018-04-06
 */
public class SelectBatchByIds extends AbstractMethod {

    @Override
    public MappedStatement injectMappedStatement(Class<?> mapperClass, Class<?> modelClass, TableInfo tableInfo) {
        SqlMethod sqlMethod = SqlMethod.SELECT_BATCH_BY_IDS;
        SqlSource sqlSource = languageDriver.createSqlSource(configuration, String.format(sqlMethod.getSql(),
                sqlSelectColumns(tableInfo, false), tableInfo.getTableName(), tableInfo.getKeyColumn(),
                SqlScriptUtils.convertForeach("#{item}", COLLECTION, null, "item", COMMA)),
                Object.class);
        return addSelectMappedStatement(mapperClass, sqlMethod.getMethod(), sqlSource, modelClass, tableInfo);
    }
}
