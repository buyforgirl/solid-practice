package com.theladders.solid.dip;

import java.util.List;

/**
 * Created by lliao on 6/10/14.
 */
public interface SubcriberArticleHandler
{
    public List<SuggestedArticle> getArticlesbySubscriber(Integer subscriberId);
}
