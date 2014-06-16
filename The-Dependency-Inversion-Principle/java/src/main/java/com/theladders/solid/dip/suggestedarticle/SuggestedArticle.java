package com.theladders.solid.dip.suggestedarticle;

import com.theladders.solid.dip.contentnode.ContentNode;

import java.util.Date;

/**
 * Created by lliao on 6/16/14.
 */
public interface SuggestedArticle
{
    public String getArticleExternalIdentifier();

    public void setContent(ContentNode node);

    public void setSuggestedArticleStatusId(Integer statusId);

    public void setSuggestedArticleSourceId(Integer sourceId);

    public void setCreateTime(Date date);

    public void setUpdateTime(Date date);

    public void setSuggestedArticleId(Integer id);

    public void setNote(String note);
}
