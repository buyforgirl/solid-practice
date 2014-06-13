package com.theladders.solid.dip;


import com.theladders.solid.dip.subscriberarticle.SubcriberArticleHandler;
import com.theladders.solid.dip.suggestedarticle.SuggestedArticleHandler;

import java.util.List;

public class SubscriberArticleManagerImpl implements SubscriberArticleManager
{
  //private  SubcriberArticleHandler subcriberArticleHandler;
  //private  SuggestedArticleHandler suggestedArticleHandler;

  //public SubscriberArticleManagerImpl(SubcriberArticleHandler subcriberArticleHandler,
  //                                    SuggestedArticleHandler suggestedArticleHandler)
  //{
  //  this.suggestedArticleHandler = suggestedArticleHandler;
  //  this.subcriberArticleHandler = subcriberArticleHandler;
  //}

  public List<SuggestedArticle> getArticlesbySubscriber(Integer subscriberId, SubcriberArticleHandler articleHandler)
  {
    return articleHandler.getArticlesbySubscriber(subscriberId);
  }

  public int addSuggestedArticle(SuggestedArticle suggestedArticle, SuggestedArticleHandler articleHandler)
  {
    return articleHandler.addSuggestedArticle(suggestedArticle);
  }


  public void updateNote(Integer id, String note, SuggestedArticleHandler articleHandler)
  {
    articleHandler.updateNote(id, note);
  }

  public void markRecomDeleted(Integer id, SuggestedArticleHandler articleHandler)
  {
    articleHandler.markRecomDeleted(id);
  }
}
