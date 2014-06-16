package com.theladders.solid.dip;


import com.theladders.solid.dip.subscriberarticle.SubcriberArticleHandler;
import com.theladders.solid.dip.suggestedarticle.SuggestedArticle;
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

  private SubcriberArticleHandler subcriberArticleHandler;
  private SuggestedArticleHandler suggestedArticleHandler;

  public SubscriberArticleManagerImpl(SubcriberArticleHandler subcriberArticleHandler,
                                      SuggestedArticleHandler suggestedArticleHandler){
      this.subcriberArticleHandler = subcriberArticleHandler;
      this.suggestedArticleHandler = suggestedArticleHandler;
  }

  public List<SuggestedArticle> getArticlesbySubscriber(Integer subscriberId)
  {
    return subcriberArticleHandler.getArticlesbySubscriber(subscriberId);
  }

  public int addSuggestedArticle(SuggestedArticle suggestedArticle)
  {
    return suggestedArticleHandler.addSuggestedArticle(suggestedArticle);
  }


  public void updateNote(Integer id, String note)
  {
      suggestedArticleHandler.updateNote(id, note);
  }

  public void markRecomDeleted(Integer id)
  {
      suggestedArticleHandler.markRecomDeleted(id);
  }
}
