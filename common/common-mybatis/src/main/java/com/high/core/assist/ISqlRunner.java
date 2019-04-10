package com.high.core.assist;

import com.high.core.metadata.IPage;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * </p>
 *
 * @author yuxiaobin
 * @since 2018/2/7
 */
public interface ISqlRunner {

    String INSERT = "com.high.core.assist.ISqlRunner.Insert";
    String DELETE = "com.high.core.assist.ISqlRunner.Delete";
    String UPDATE = "com.high.core.assist.ISqlRunner.Update";
    String SELECT_LIST = "com.high.core.assist.ISqlRunner.SelectList";
    String SELECT_OBJS = "com.high.core.assist.ISqlRunner.SelectObjs";
    String COUNT = "com.high.core.assist.ISqlRunner.Count";
    String SQL_SCRIPT = "${sql}";
    String SQL = "sql";

    boolean insert(String sql, Object... args);

    boolean delete(String sql, Object... args);

    boolean update(String sql, Object... args);

    List<Map<String, Object>> selectList(String sql, Object... args);

    List<Object> selectObjs(String sql, Object... args);

    Object selectObj(String sql, Object... args);

    int selectCount(String sql, Object... args);

    Map<String, Object> selectOne(String sql, Object... args);

    IPage<Map<String, Object>> selectPage(IPage page, String sql, Object... args);
}

