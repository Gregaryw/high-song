package com.high.core.conditions.segments;

import com.high.core.conditions.ISqlSegment;
import com.high.core.enums.SqlKeyword;
import com.high.core.enums.WrapperKeyword;

import java.util.function.Predicate;

/**
 * 匹配片段
 *
 * @author miemie
 * @since 2018-06-27
 */
public enum MatchSegment {
    GROUP_BY(i -> i == SqlKeyword.GROUP_BY),
    ORDER_BY(i -> i == SqlKeyword.ORDER_BY),
    NOT(i -> i == SqlKeyword.NOT),
    AND(i -> i == SqlKeyword.AND),
    OR(i -> i == SqlKeyword.OR),
    AND_OR(i -> i == SqlKeyword.AND || i == SqlKeyword.OR),
    EXISTS(i -> i == SqlKeyword.EXISTS),
    HAVING(i -> i == SqlKeyword.HAVING),
    APPLY(i -> i == WrapperKeyword.APPLY);

    private final Predicate<ISqlSegment> predicate;

    MatchSegment(Predicate<ISqlSegment> predicate) {
        this.predicate = predicate;
    }

    public boolean match(ISqlSegment segment) {
        return getPredicate().test(segment);
    }

    protected Predicate<ISqlSegment> getPredicate() {
        return predicate;
    }
}