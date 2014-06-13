package com.theladders.solid.dip;

import com.theladders.solid.dip.subscriberarticle.SubcriberArticleHandler;
import com.theladders.solid.dip.suggestedarticle.SuggestedArticleHandler;

import java.util.List;

public interface SubscriberArticleManager
{
    public List<SuggestedArticle> getArticlesbySubscriber(Integer subscriberId, SubcriberArticleHandler articleHandler);

    public int addSuggestedArticle(SuggestedArticle suggestedArticle, SuggestedArticleHandler articleHandler);

    public void updateNote(Integer id, String note, SuggestedArticleHandler articleHandler);

    public void markRecomDeleted(Integer id, SuggestedArticleHandler articleHandler);
}