package com.high.core.conditions;

import com.high.core.conditions.segments.MergeSegments;
import com.high.core.metadata.TableFieldInfo;
import com.high.core.metadata.TableInfo;
import com.high.core.toolkit.ReflectionKit;
import com.high.core.toolkit.TableInfoHelper;
import com.high.util.CollectionUtils;
import com.high.util.StringUtils;
import java.util.Objects;

/**
 * copy mybatis_plus
 * 条件构造抽象类
 */
public abstract class Wrapper<T> implements ISqlSegment{
    /**
     * 实体对象（子类实现）
     *
     * @return 泛型 T
     */
    public abstract T getEntity();

    public String getSqlSelect() {
        return null;
    }

    public String getSqlSet() {
        return null;
    }

    /**
     * 获取 MergeSegments
     */
    public abstract MergeSegments getExpression();

    /**
     * 获取自定义SQL 简化自定义XML复杂情况
     * <p>使用方法</p>
     * <p>`自定义sql` + ${ew.customSqlSegment}</p>
     * <p>1.逻辑删除需要自己拼接条件 (之前自定义也同样)</p>
     * <p>2.不支持wrapper中附带实体的情况 (wrapper自带实体会更麻烦)</p>
     * <p>3.用法 ${ew.customSqlSegment} (不需要where标签包裹,切记!)</p>
     * <p>4.ew是wrapper定义别名,可自行替换</p>
     */
    public abstract String getCustomSqlSegment();

    /**
     * 查询条件为空(包含entity)
     */
    public boolean isEmptyOfWhere() {
        return isEmptyOfNormal() && isEmptyOfEntity();
    }

    /**
     * 查询条件不为空(包含entity)
     */
    public boolean nonEmptyOfWhere() {
        return !isEmptyOfWhere();
    }

    /**
     * 查询条件为空(不包含entity)
     */
    public boolean isEmptyOfNormal() {
        return CollectionUtils.isEmpty(getExpression().getNormal());
    }

    /**
     * 查询条件为空(不包含entity)
     */
    public boolean nonEmptyOfNormal() {
        return !isEmptyOfNormal();
    }

    /**
     * 深层实体判断属性
     *
     * @return true 不为空
     */
    public boolean nonEmptyOfEntity() {
        T entity = getEntity();
        if (entity == null) {
            return false;
        }
        TableInfo tableInfo = TableInfoHelper.getTableInfo(entity.getClass());
        if (tableInfo == null) {
            return false;
        }
        if (tableInfo.getFieldList().stream().anyMatch(e -> fieldStrategyMatch(entity, e))) {
            return true;
        }
        return StringUtils.isNotEmpty(tableInfo.getKeyProperty()) ? Objects.nonNull(ReflectionKit.getMethodValue(entity, tableInfo.getKeyProperty())) : false;
    }

    /**
     * 根据实体FieldStrategy属性来决定判断逻辑
     */
    private boolean fieldStrategyMatch(T entity, TableFieldInfo e) {
        switch (e.getFieldStrategy()) {
            case NOT_NULL:
                return Objects.nonNull(ReflectionKit.getMethodValue(entity, e.getProperty()));
            case IGNORED:
                return true;
            case NOT_EMPTY:
                return StringUtils.checkValNotNull(ReflectionKit.getMethodValue(entity, e.getProperty()));
            default:
                return Objects.nonNull(ReflectionKit.getMethodValue(entity, e.getProperty()));
        }
    }

    /**
     * 深层实体判断属性
     *
     * @return true 为空
     */
    public boolean isEmptyOfEntity() {
        return !nonEmptyOfEntity();
    }
}
