package com.theladders.solid.dip.suggestedarticle;

/**
 * Created by lliao on 6/16/14.
 */
public class SuggestedArticleFactory
{
    private SuggestedArticle suggestedArticle;

    public SuggestedArticleFactory(SuggestedArticle suggestedArticle){
        this.suggestedArticle = suggestedArticle;
    }

    public SuggestedArticle createSuggestedArticle(){
        return suggestedArticle;
    }
}
