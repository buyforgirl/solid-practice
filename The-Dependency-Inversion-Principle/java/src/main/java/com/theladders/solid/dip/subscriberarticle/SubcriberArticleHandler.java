package com.theladders.solid.dip.subscriberarticle;



import com.theladders.solid.dip.suggestedarticle.SuggestedArticle;

import java.util.List;

/**
 * Created by lliao on 6/10/14.
 */
public interface SubcriberArticleHandler
{
    public List<SuggestedArticle> getArticlesbySubscriber(Integer subscriberId);
}
