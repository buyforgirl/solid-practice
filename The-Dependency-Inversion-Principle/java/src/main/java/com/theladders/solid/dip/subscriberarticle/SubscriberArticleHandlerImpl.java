package com.theladders.solid.dip.subscriberarticle;

import com.theladders.solid.dip.contentnode.ContentNode;
import com.theladders.solid.dip.contentnode.ContentNodeController;
import com.theladders.solid.dip.contentnode.ContentUtils;
import com.theladders.solid.dip.contentnode.RepositoryManager;
import com.theladders.solid.dip.suggestedarticle.SuggestedArticle;
import com.theladders.solid.dip.suggestedarticledao.SuggestedArticleDao;
import com.theladders.solid.dip.suggestedarticleexample.SuggestedArticleExampleFactory;
import com.theladders.solid.dip.suggestedarticleexample.SuggestedArticleExample;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
/**
 * Created by lliao on 6/10/14.
 */
public class SubscriberArticleHandlerImpl implements SubcriberArticleHandler
{


    private SuggestedArticleDao suggestedArticleDao;
    private ContentNodeController contentNodeController;
    private SuggestedArticleExampleFactory suggestedArticleExampleFactory;

    public SubscriberArticleHandlerImpl(SuggestedArticleDao suggestedArticleDao,
                                        ContentNodeController contentNodeController,
                                        SuggestedArticleExampleFactory suggestedArticleExampleFactory)
    {
        this.suggestedArticleDao = suggestedArticleDao;
        this.contentNodeController = contentNodeController;
        this.suggestedArticleExampleFactory = suggestedArticleExampleFactory;
    }

    public List<SuggestedArticle> getArticlesbySubscriber(Integer subscriberId)
    {
        SuggestedArticleExample criteria = suggestedArticleExampleFactory.createArticleExample();
        criteria.createCriteria()
                .andSubscriberIdEqualTo(subscriberId)
                .andSuggestedArticleStatusIdIn(Arrays.asList(1, 2))  // must be New or Viewed
                .andSuggestedArticleSourceIdEqualTo(1);

        criteria.setOrderByClause("create_time desc");
        List<SuggestedArticle> dbSuggestions = this.suggestedArticleDao.selectByExampleWithBlobs(criteria);

        // Fetch content associated with SuggestedArticle (based on externalArticleId)
        contentNodeController.resolveArticles(dbSuggestions);

        return dbSuggestions;
    }


}
