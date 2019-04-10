package com.high.extension.toolkit;

import com.high.core.metadata.TableInfo;
import com.high.core.toolkit.TableInfoHelper;
import com.high.util.Assert;
import com.high.util.CollectionUtils;
import com.high.util.GlobalConfigUtils;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionUtils;

import java.util.List;

/**
 * SQL 辅助类
 *
 * @author hubin
 * @since 2016-11-06
 */
public final class SqlHelper {

    private static final Log logger = LogFactory.getLog(SqlHelper.class);
    public static SqlSessionFactory FACTORY;


    /**
     * 批量操作 SqlSession
     *
     * @param clazz 实体类
     * @return SqlSession
     */
    public static SqlSession sqlSessionBatch(Class<?> clazz) {
        // TODO 暂时让能用先,但日志会显示Closing non transactional SqlSession,因为这个并没有绑定.
        return GlobalConfigUtils.currentSessionFactory(clazz).openSession(ExecutorType.BATCH);
    }

    /**
     * 获取sqlSession
     *
     * @param clazz 对象类
     * @return ignore
     */
    private static SqlSession getSqlSession(Class<?> clazz) {
        return SqlSessionUtils.getSqlSession(GlobalConfigUtils.currentSessionFactory(clazz));
    }

    /**
     * 获取Session
     *
     * @param clazz 实体类
     * @return SqlSession
     */
    public static SqlSession sqlSession(Class<?> clazz) {
        return SqlHelper.getSqlSession(clazz);
    }

    /**
     * 获取TableInfo
     *
     * @param clazz 对象类
     * @return TableInfo 对象表信息
     */
    public static TableInfo table(Class<?> clazz) {
        TableInfo tableInfo = TableInfoHelper.getTableInfo(clazz);
        Assert.notNull(tableInfo, "Error: Cannot execute table Method, ClassGenricType not found .");
        return tableInfo;
    }

    /**
     * 判断数据库操作是否成功
     *
     * @param result 数据库操作返回影响条数
     * @return boolean
     */
    public static boolean retBool(Integer result) {
        return null != result && result >= 1;
    }

    /**
     * 删除不存在的逻辑上属于成功
     *
     * @param result 数据库操作返回影响条数
     * @return boolean
     */
    public static boolean delBool(Integer result) {
        return null != result && result >= 0;
    }

    /**
     * 返回SelectCount执行结果
     *
     * @param result ignore
     * @return int
     */
    public static int retCount(Integer result) {
        return (null == result) ? 0 : result;
    }

    /**
     * 从list中取第一条数据返回对应List中泛型的单个结果
     *
     * @param list ignore
     * @param <E> ignore
     * @return ignore
     */
    public static <E> E getObject(List<E> list) {
        if (CollectionUtils.isNotEmpty(list)) {
            int size = list.size();
            if (size > 1) {
                logger.warn(String.format("Warn: execute Method There are  %s results.", size));
            }
            return list.get(0);
        }
        return null;
    }
}
