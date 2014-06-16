package com.theladders.solid.dip.suggestedarticle;


import com.theladders.solid.dip.suggestedarticledao.SuggestedArticleDao;

import java.util.Date;

/**
 * Created by lliao on 6/10/14.
 */
public class SuggestedArticleHandlerImpl implements SuggestedArticleHandler
{
    private SuggestedArticleDao suggestedArticleDao;
    private SuggestedArticleFactory suggestedArticleFactory;

    public SuggestedArticleHandlerImpl(SuggestedArticleDao suggestedArticleDao,
                                       SuggestedArticleFactory suggestedArticleFactory)
    {
        this.suggestedArticleDao = suggestedArticleDao;
        this.suggestedArticleFactory = suggestedArticleFactory;
    }

    public int addSuggestedArticle(SuggestedArticle suggestedArticle)
    {
        Integer STATUS_UNREAD = 1;
        Integer HTP_CONSULTANT = 1;
        suggestedArticle.setSuggestedArticleStatusId(STATUS_UNREAD);
        suggestedArticle.setSuggestedArticleSourceId(HTP_CONSULTANT);
        suggestedArticle.setCreateTime(new Date()); // current date
        suggestedArticle.setUpdateTime(new Date()); // current date
        int newId = suggestedArticleDao.insertReturnId(suggestedArticle);
        return newId;
    }

    public void updateNote(Integer id, String note)
    {
        SuggestedArticle article = suggestedArticleFactory.createSuggestedArticle();
        article.setSuggestedArticleId(id);
        article.setNote(note);
        suggestedArticleDao.updateByPrimaryKeySelective(article);
    }

    public void markRecomDeleted(Integer id)
    {
        Integer STATUS_DELETED = 4;
        SuggestedArticle article = suggestedArticleFactory.createSuggestedArticle();
        article.setSuggestedArticleId(id);
        article.setSuggestedArticleStatusId(STATUS_DELETED);
        suggestedArticleDao.updateByPrimaryKeySelective(article);
    }
}
