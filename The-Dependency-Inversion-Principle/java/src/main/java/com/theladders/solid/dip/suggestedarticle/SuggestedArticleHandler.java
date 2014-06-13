package com.theladders.solid.dip.suggestedarticle;

import com.theladders.solid.dip.SuggestedArticle;

/**
 * Created by lliao on 6/10/14.
 */
public interface SuggestedArticleHandler
{
    /**
     * Add a SuggestedArticle to the database.
     *
     * @param suggestedArticle
     */

    public int addSuggestedArticle(SuggestedArticle suggestedArticle);

    /**
     * Update the note of the Suggested Article(id)
     *  with the note passed in.
     *
     */
    public void updateNote(Integer id, String note);

    /**
     * Mark as deleted the Suggested Article(id)
     *
     */
    public void markRecomDeleted(Integer id);
}
