package com.theladders.solid.dip.suggestedarticleexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lliao on 6/16/14.
 */
public abstract class GeneralCriteria
{
    protected List<Map<String, Object>> criteriaWithSingleValue;

    protected List<Map<String, Object>> criteriaWithListValue;

    public GeneralCriteria() {
        criteriaWithSingleValue = new ArrayList<>();
        criteriaWithListValue = new ArrayList<>();
    }

    protected void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("condition", condition);
        map.put("value", value);
        criteriaWithSingleValue.add(map);
    }

    protected void addCriterion(String condition, List<? extends Object> values, String property) {
        if (values == null || values.size() == 0) {
            throw new RuntimeException("Value list for " + property + " cannot be null or empty");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("condition", condition);
        map.put("values", values);
        criteriaWithListValue.add(map);
    }

    public abstract GeneralCriteria andSubscriberIdEqualTo(Integer value);

    public abstract GeneralCriteria andSuggestedArticleSourceIdEqualTo(Integer value);

    public abstract GeneralCriteria andSuggestedArticleStatusIdIn(List<Integer> values);
}
