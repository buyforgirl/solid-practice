package com.theladders.solid.dip;

import com.theladders.solid.dip.subscriberarticle.SubcriberArticleHandler;
import com.theladders.solid.dip.suggestedarticle.SuggestedArticle;
import com.theladders.solid.dip.suggestedarticle.SuggestedArticleHandler;

import java.util.List;

public interface SubscriberArticleManager
{
    public List<SuggestedArticle> getArticlesbySubscriber(Integer subscriberId);

    public int addSuggestedArticle(SuggestedArticle suggestedArticle);

    public void updateNote(Integer id, String note);

    public void markRecomDeleted(Integer id);
}