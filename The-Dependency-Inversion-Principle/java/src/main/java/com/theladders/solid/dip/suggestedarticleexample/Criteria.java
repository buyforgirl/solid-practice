package com.theladders.solid.dip.suggestedarticleexample;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by lliao on 6/13/14.
 */
public class Criteria extends GeneralCriteria
{


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
