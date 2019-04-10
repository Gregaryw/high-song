package com.high.core.injector;

import com.high.core.metadata.TableInfo;
import com.high.core.parser.SqlParserHelper;
import com.high.core.toolkit.TableInfoHelper;
import com.high.util.ArrayUtils;
import com.high.util.GlobalConfigUtils;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.session.Configuration;
import org.springframework.util.Assert;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.List;
import java.util.Set;

/**
 * SQL 自动注入器
 *
 * @author hubin
 * @since 2018-04-07
 */
public abstract class AbstractSqlInjector implements ISqlInjector {

    @Override
    public void inspectInject(MapperBuilderAssistant builderAssistant, Class<?> mapperClass) {
        String className = mapperClass.toString();
        Set<String> mapperRegistryCache = GlobalConfigUtils.getMapperRegistryCache(builderAssistant.getConfiguration());
        if (!mapperRegistryCache.contains(className)) {
            List<AbstractMethod> methodList = this.getMethodList();
            Assert.notEmpty(methodList, "No effective injection method was found.");
            // 循环注入自定义方法
            Class<?> modelClass = extractModelClass(mapperClass);
            if (modelClass != null) {
                TableInfo tableInfo = TableInfoHelper.initTableInfo(builderAssistant, modelClass);
                methodList.forEach(m -> m.inject(builderAssistant, mapperClass, modelClass, tableInfo));
            }
            mapperRegistryCache.add(className);
            /*
             * 初始化 SQL 解析
             */
            if (GlobalConfigUtils.getGlobalConfig(builderAssistant.getConfiguration()).isSqlParserCache()) {
                SqlParserHelper.initSqlParserInfoCache(mapperClass);
            }
        }
    }

    @Override
    public void injectSqlRunner(Configuration configuration) {
        new SqlRunnerInjector().inject(configuration);
    }

    /**
     * 获取 注入的方法
     *
     * @return 注入的方法集合
     */
    public abstract List<AbstractMethod> getMethodList();

    /**
     * 提取泛型模型,多泛型的时候请将泛型T放在第一位
     *
     * @param mapperClass mapper 接口
     * @return mapper 泛型
     */
    protected Class<?> extractModelClass(Class<?> mapperClass) {
        Type[] types = mapperClass.getGenericInterfaces();
        ParameterizedType target = null;
        for (Type type : types) {
            if (type instanceof ParameterizedType) {
                Type[] typeArray = ((ParameterizedType) type).getActualTypeArguments();
                if (ArrayUtils.isNotEmpty(typeArray)) {
                    for (Type t : typeArray) {
                        if (t instanceof TypeVariable || t instanceof WildcardType) {
                            break;
                        } else {
                            target = (ParameterizedType) type;
                            break;
                        }
                    }
                }
                break;
            }
        }
        return target == null ? null : (Class<?>) target.getActualTypeArguments()[0];
    }
}

