package com.high.factory;

import com.high.core.override.MybatisMapperMethod;
import com.high.core.override.MybatisMapperProxy;
import org.apache.ibatis.session.SqlSession;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 替换掉引用
 * <p>重写类： org.apache.ibatis.binding.MapperProxyFactory</p>
 *
 * @author miemie
 * @since 2018-06-09
 */
public class MybatisMapperProxyFactory<T> {

    private final Class<T> mapperInterface;
    private final Map<Method, MybatisMapperMethod> methodCache = new ConcurrentHashMap<>();

    public MybatisMapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    public Class<T> getMapperInterface() {
        return mapperInterface;
    }

    public Map<Method, MybatisMapperMethod> getMethodCache() {
        return methodCache;
    }

    @SuppressWarnings("unchecked")
    protected T newInstance(MybatisMapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(mapperInterface.getClassLoader(), new Class[]{mapperInterface}, mapperProxy);
    }

    public T newInstance(SqlSession sqlSession) {
        final MybatisMapperProxy<T> mapperProxy = new MybatisMapperProxy<>(sqlSession, mapperInterface, methodCache);
        return newInstance(mapperProxy);
    }
}
