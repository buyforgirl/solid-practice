package com.theladders.solid.dip.suggestedarticleexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lliao on 6/13/14.
 */
public class Criteria
{
    private List<Map<String, Object>> criteriaWithSingleValue;

    private List<Map<String, Object>> criteriaWithListValue;

    public Criteria() {
        criteriaWithSingleValue = new ArrayList<>();
        criteriaWithListValue = new ArrayList<>();
    }

    public void addCriterion(String condition, Object value, String property) {
        if (value == null) {
            throw new RuntimeException("Value for " + property + " cannot be null");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("condition", condition);
        map.put("value", value);
        criteriaWithSingleValue.add(map);
    }

    public void addCriterion(String condition, List<? extends Object> values, String property) {
        if (values == null || values.size() == 0) {
            throw new RuntimeException("Value list for " + property + " cannot be null or empty");
        }
        Map<String, Object> map = new HashMap<>();
        map.put("condition", condition);
        map.put("values", values);
        criteriaWithListValue.add(map);
    }

    public Criteria andSubscriberIdEqualTo(Integer value) {
        addCriterion("subscriber_id =", value, "subscriberId");
        return (Criteria) this;
    }

    public Criteria andSuggestedArticleSourceIdEqualTo(Integer value) {
        addCriterion("suggested_article_source_id =", value, "suggestedArticleSourceId");
        return (Criteria) this;
    }

    public Criteria andSuggestedArticleStatusIdIn(List<Integer> values) {
        addCriterion("suggested_article_status_id in", values, "suggestedArticleStatusId");
        return (Criteria) this;
    }
}
