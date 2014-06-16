package com.theladders.solid.dip.suggestedarticleexample;



/**
 * Created by lliao on 6/16/14.
 */
public class SuggestedArticleExampleFactory
{
    private SuggestedArticleExample suggestedArticleExample;

    public SuggestedArticleExampleFactory(SuggestedArticleExample suggestedArticleExample){
        this.suggestedArticleExample = suggestedArticleExample;
    }

    public SuggestedArticleExample createArticleExample(){
        return suggestedArticleExample;
    }
}
