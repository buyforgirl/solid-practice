package com.theladders.solid.dip.suggestedarticledao;



import com.theladders.solid.dip.suggestedarticle.SuggestedArticle;
import com.theladders.solid.dip.suggestedarticle.SuggestedArticleFactory;
import com.theladders.solid.dip.suggestedarticleexample.SuggestedArticleExample;

import java.util.Collections;
import java.util.List;

/**
 * Created by lliao on 6/16/14.
 */
public class SuggestedArticleDaoImpl implements SuggestedArticleDao
{
    private SuggestedArticleFactory suggestedArticleFactory;

    public SuggestedArticleDaoImpl(SuggestedArticleFactory suggestedArticleFactory){
        this.suggestedArticleFactory = suggestedArticleFactory;
    }

    public void updateByPrimaryKeySelective(@SuppressWarnings("unused") SuggestedArticle article){}

    public int insertReturnId(@SuppressWarnings("unused") SuggestedArticle suggestedArticle){return 1;}

    public List<SuggestedArticle> selectByExampleWithBlobs(@SuppressWarnings("unused") SuggestedArticleExample criteria){
        return Collections.singletonList(suggestedArticleFactory.createSuggestedArticle());
    };
}
